package HeBing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

public class HeBing extends PrintStream{

	public static final int BUFSIZE = 1024 * 8;
	private JTextComponent text;
	private StringBuffer sb = new StringBuffer();
	
	//重载System.out
	public HeBing(OutputStream out, JTextComponent text){
		 super(out);  
	     this.text = text;  
	}
	public void start(String inPath, String outPath){
		System.err.println("开始合并...");
		Long sys1 = System.currentTimeMillis();
		File file = new File(inPath);
		File outFile = new File(outPath);
		if(outFile.exists()){
			outFile.delete();
			System.out.println("目标文件已存在，覆盖生成中...");
		}
		if(file.isDirectory()){
			File[] file_list = file.listFiles();
			//file_list = arr_sort(file_list);
//			List<File> fileList = Arrays.asList(file_list);
//			Collections.sort(fileList, new Comparator<File>() {
//			    @Override
//			    public int compare(File o1, File o2) {
//			        if (o1.isDirectory() && o2.isFile())
//			            return -1;
//			        if (o1.isFile() && o2.isDirectory())
//			            return 1;
//			        return o2.getName().compareTo(o1.getName());
//			    }
//			});
			FileChannel outChannel = null;
			try{
				outChannel = new FileOutputStream(outFile).getChannel();
				for(File f : file_list){
					String lastName = f.getName();
					if(lastName.indexOf(".txt")!=-1){
						System.out.println("找到txt文件："+f.getPath());
						Charset charset=Charset.forName("utf-8");
				        CharsetDecoder chdecoder=charset.newDecoder();
				        CharsetEncoder chencoder=charset.newEncoder();
				        FileChannel fc = new FileInputStream(f).getChannel(); 
				        ByteBuffer bb = ByteBuffer.allocate(BUFSIZE);
				        CharBuffer charBuffer=chdecoder.decode(bb);
				        ByteBuffer nbuBuffer=chencoder.encode(charBuffer);
				        while(fc.read(nbuBuffer) != -1){
				            bb.flip(); 
				            nbuBuffer.flip();
				            outChannel.write(nbuBuffer);
				            bb.clear();
				            nbuBuffer.clear();
				        }
				        fc.close();
					}
				}
				Long sys2 = System.currentTimeMillis();
				System.err.println("合并成功，耗时："+(sys2-sys1)+"ms.");
				System.err.println("文件目录："+outFile.getPath());
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(outChannel!=null){
					try {
						outChannel.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	 /** 
     * 在这里重截,所有的打印方法都要调用的方法 
     */  
    public void write(byte[] buf, int off, int len) {  
    	 final String message = new String(buf, off, len);   
    	 SwingUtilities.invokeLater(new Runnable(){
           public void run(){
              sb.append(message+"\n");
              text.setText(sb.toString());
           }
    	 });
    }
	
	
	/**
	 * 排序
	 * @author 赵鹏展
	 * @date 2016-10-14 上午11:33:01
	 */
	private File[] arr_sort(File[] file_list) {
		File[] num_arr = new File[file_list.length];
		File[] file_arr = new File[file_list.length];
		for(int i=0;i<file_list.length;i++){
			BigDecimal name1 = handleStr(file_list[i].getName());
			BigDecimal name2 = handleStr(file_list[i+1].getName());
		}
		return null;
	}
	
	/**
	 * 判断文件名中的数字
	 * @author 赵鹏展
	 * @date 2016-10-14 下午01:03:49
	 */
	public BigDecimal handleStr(String file_name){
		BigDecimal num = null;
		if(isNumeric(file_name)){//判断是否包含数字
			file_name = file_name.replaceAll("(?<!\\d)\\D", "");//去除非数字
			if(file_name!=null && ".".equals(file_name.substring(file_name.length()-1, file_name.length()))){//去除最末尾的点
				file_name = file_name.substring(0,file_name.length()-1);
			}
			if(file_name!=null && !"".equals(file_name)){
				num = new BigDecimal(file_name);
			}
		}
		return num;
	}
	
	/**
	  * 判断字符串是否包含数字
	  */
	public static boolean isNumeric(String str){
		for (int i = 0; i < str.length(); i++){
			if (Character.isDigit(str.charAt(i))){
				return true;
			}
		}
		return false;
	}
}
