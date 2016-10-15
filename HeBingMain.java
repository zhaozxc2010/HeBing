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
	public String fileName = "�ϲ����.txt";
	String inPath = null;
	String outPath = null;
	JTextField jtf1 = null;
	JTextField jtf2 = null;
	JFrame jframe = null;
	JTextArea jta;//�����ı���

	public HeBingMain(){
		super();
		jframe = new JFrame("�ϲ�txt");//����
		JLabel jl1 = new JLabel("��Ҫ�ϲ����ļ�Ŀ¼:");
		JLabel jl2 = new JLabel("��Ҫ�������ļ�Ŀ¼:");
		jtf1 = new JTextField(30);
		jtf2 = new JTextField(30);
		
		JButton jb1 = new JButton("ѡ��Ŀ¼");
		jb1.addActionListener(new button1Action());
		
		JButton jb2 = new JButton("ѡ��Ŀ¼");
		jb2.addActionListener(new button2Action());
		
		JButton jb3 = new JButton("�ϲ�");
		jb3.addActionListener(new button3Action());
		
		JButton jb4 = new JButton("���ļ���");
		jb4.addActionListener(new button4Action());
		
		JPanel jp1 = new JPanel(/*new GridLayout(1,3)*/);//��һ�У������ؼ�,һ�����У� 
		JPanel jp2 = new JPanel(/*new GridLayout(1,3)*/);//�ڶ��� �������ؼ��� 
		JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.CENTER));//�����У�һ����ť��������ʾ�� 
		JPanel up = new JPanel(new GridLayout(3,1));//����
		
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jb1);
		
		jp2.add(jl2);
		jp2.add(jtf2);
		jp2.add(jb2);
//		
		jp3.add(jb3);
		jp3.add(jb4);
		
		up.add(jp1);
		up.add(jp2);
		up.add(jp3);
		
		//�ı���
		jta = new JTextArea();
		jta.setEditable(false);
		JScrollPane down = new JScrollPane(jta);
		
		//�ָ����(�������������)
		JSplitPane all = new JSplitPane(JSplitPane.VERTICAL_SPLIT,up,down);
		
		//�����������ӵ�������
		this.add(all);
		//�������񲼾֣������ֱ��ʾ�����У����У�ˮƽ��࣬��ֱ��� 
		//this.setLayout(new GridLayout(2,1,1,1));
		this.setResizable(false);//resizeableֵΪtrueʱ����ʾ�����ɵĴ���������ɸı��С��
		this.setVisible(true);//trueΪ���ڿɼ�
		this.setSize(width, height);
		this.setLocation(Util.getWindowCenterWidth(width), Util.getWindowCenterHeight(height));
		this.setTitle("�ϲ�txt");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//һ��Ҫ���ùر�
	}
	
	/**
     * ��������ʵ��ActionListener�ӿڣ���Ҫʵ��actionPerformed����
     */
    private class button1Action implements ActionListener{
    	 public void actionPerformed(ActionEvent e){
        	 JFileChooser fc = new JFileChooser();
			  fc.setDialogTitle("��ѡ���ļ����ڵ�Ŀ¼...");
			  fc.setApproveButtonText("ȷ��");
			  fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			  if (JFileChooser.APPROVE_OPTION == fc.showOpenDialog(jframe)) {
			      inPath=fc.getSelectedFile().getPath();
			      jtf1.setText(inPath);
			  }
        }
    }
    
    /**
     * ��������ʵ��ActionListener�ӿڣ���Ҫʵ��actionPerformed����
     */
    private class button2Action implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	 JFileChooser fc = new JFileChooser();
			  fc.setDialogTitle("��ѡ���ļ����ڵ�Ŀ¼...");
			  fc.setApproveButtonText("ȷ��");
			  fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			  if (JFileChooser.APPROVE_OPTION == fc.showOpenDialog(jframe)) {
			      outPath=fc.getSelectedFile().getPath();
			      jtf2.setText(outPath);
			  }
        }
    }
    
    /**
     * ��������ʵ��ActionListener�ӿڣ���Ҫʵ��actionPerformed����
     */
    private class button3Action implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	if(jtf1.getText()==null || "".equals(jtf1.getText())){
        		JOptionPane.showMessageDialog(null, "����Ҫ�ϲ����ļ�Ŀ¼������Ϊ�գ�", "ע��", JOptionPane.WARNING_MESSAGE);
        		return;
        	}
        	if(jtf2.getText()==null || "".equals(jtf2.getText())){
        		JOptionPane.showMessageDialog(null, "����Ҫ�������ļ�Ŀ¼������Ϊ�գ�", "ע��", JOptionPane.WARNING_MESSAGE);
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
     * ��������ʵ��ActionListener�ӿڣ���Ҫʵ��actionPerformed����
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
