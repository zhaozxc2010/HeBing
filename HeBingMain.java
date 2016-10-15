package HeBing;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class HeBingMain extends JFrame{
	
	public int width  = 800;
	public int height = 550;
	public String fileName = "合并结果.txt";
	String inPath = null;
	String outPath = null;
	JTextField jtf1 = null;
	JTextField jtf2 = null;
	JFrame jframe = null;
	JTextArea jta;//多行文本框

	public HeBingMain(){
		super();
		jframe = new JFrame("合并txt");//容器
		JLabel jl1 = new JLabel("需要合并的文件目录:");
		JLabel jl2 = new JLabel("需要导出的文件目录:");
		jtf1 = new JTextField(30);
		jtf2 = new JTextField(30);
		
		JButton jb1 = new JButton("选择目录");
		jb1.addActionListener(new button1Action());
		
		JButton jb2 = new JButton("选择目录");
		jb2.addActionListener(new button2Action());
		
		JButton jb3 = new JButton("合并");
		jb3.addActionListener(new button3Action());
		
		JButton jb4 = new JButton("打开文件夹");
		jb4.addActionListener(new button4Action());
		
		JPanel jp1 = new JPanel(/*new GridLayout(1,3)*/);//第一行（三个控件,一行三列） 
		JPanel jp2 = new JPanel(/*new GridLayout(1,3)*/);//第二行 （三个控件） 
		JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.CENTER));//第三行（一个按钮，居中显示） 
		JPanel up = new JPanel(new GridLayout(3,1));//上面
		
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jb1);
		
		jp2.add(jl2);
		jp2.add(jtf2);
		jp2.add(jb2);
		
		jp3.add(jb3);
		jp3.add(jb4);
		
		up.add(jp1);
		up.add(jp2);
		up.add(jp3);
		
		//文本域
		jta = new JTextArea();
		jta.setEditable(false);
		JScrollPane down = new JScrollPane(jta);
		
		//分割面板(包含上面和下面)
		JSplitPane all = new JSplitPane(JSplitPane.VERTICAL_SPLIT,up,down);
		
		//将控制组件添加到容器中
		this.add(all);
		//设置网格布局，参数分别表示：几行，几列，水平间距，垂直间距 
		//this.setLayout(new GridLayout(2,1,1,1));
		this.setResizable(false);//resizeable值为true时，表示在生成的窗体可以自由改变大小；
		this.setVisible(true);//true为窗口可见
		this.setSize(width, height);
		this.setLocation(Util.getWindowCenterWidth(width), Util.getWindowCenterHeight(height));
		this.setTitle("合并txt");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//一定要设置关闭
	}
	
	/**
     * 监听器类实现ActionListener接口，主要实现actionPerformed方法
     */
    private class button1Action implements ActionListener{
    	 public void actionPerformed(ActionEvent e){
        	 JFileChooser fc = new JFileChooser();
			  fc.setDialogTitle("请选择文件所在的目录...");
			  fc.setApproveButtonText("确定");
			  fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			  if (JFileChooser.APPROVE_OPTION == fc.showOpenDialog(jframe)) {
			      inPath=fc.getSelectedFile().getPath();
			      jtf1.setText(inPath);
			  }
        }
    }
    
    /**
     * 监听器类实现ActionListener接口，主要实现actionPerformed方法
     */
    private class button2Action implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	 JFileChooser fc = new JFileChooser();
			  fc.setDialogTitle("请选择文件所在的目录...");
			  fc.setApproveButtonText("确定");
			  fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			  if (JFileChooser.APPROVE_OPTION == fc.showOpenDialog(jframe)) {
			      outPath=fc.getSelectedFile().getPath();
			      jtf2.setText(outPath);
			  }
        }
    }
    
    /**
     * 监听器类实现ActionListener接口，主要实现actionPerformed方法
     */
    private class button3Action implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	if(jtf1.getText()==null || "".equals(jtf1.getText())){
        		JOptionPane.showMessageDialog(null, "【需要合并的文件目录】不能为空！", "注意", JOptionPane.WARNING_MESSAGE);
        		return;
        	}
        	if(jtf2.getText()==null || "".equals(jtf2.getText())){
        		JOptionPane.showMessageDialog(null, "【需要导出的文件目录】不能为空！", "注意", JOptionPane.WARNING_MESSAGE);
        		return;
        	}
        	HeBing hb = new HeBing(System.out, jta);
        	System.setOut(hb);  
        	System.setErr(hb);
        	if(jtf2.getText().indexOf(".txt")==-1){
        		hb.start(jtf1.getText(), jtf2.getText()+"/"+fileName);
        	}else{
        		hb.start(jtf1.getText(), jtf2.getText());
        	}
        }
    }
    
    /**
     * 监听器类实现ActionListener接口，主要实现actionPerformed方法
     */
    private class button4Action implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	HeBing hb = new HeBing(System.out, jta);
        	System.setOut(hb);  
        	System.setErr(hb);
        	if(jtf2.getText().indexOf(".txt")==-1){
        		hb.openFilePath(jtf2.getText()+"/"+fileName);
        	}else{
        		hb.openFilePath(jtf2.getText());
        	}
        }
    }
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {  
            public void run() {  
            	HeBingMain f = new HeBingMain();  
            }                 
        }); 
	}
}
