package test;
import java.awt.*;
    import java.awt.event.KeyEvent;
    import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
    /*
    * ���ߣ���־��
    * ���ܣ�ͼ�ν���GUI,Swing
    * ���ڣ�2013-2-2
    * 1. awt, swt,swing,jFace֮�����
    * awt,sun��˾�ṩ��GUI�������߰�AWT(Abstract Window Toolkit)������һЩ���󴰿ڹ���
    * swing,sun��˾����һ��GUI��ܣ������awt���ڵ�lcd(���ػ�)����
    * awt,IBM������һ���µ�GUI�⣬��ΪSwing�������ڴ�
    * JFace,IBM�ṩ�ĸ�ǿ���GUI����
    * 2, ���ֹ�������
    * �߽粼��(BorderLayout)��
    * ��ʽ����(FlowLayout,�����ң��Զ�����)
    * ���񲼾�(GridLayout)
    *
    * 3, ���濪����һ�㲽�裺
    * �̳�JFrame
    * �������(����)
    * �������(���캯��)
    * ������(���뵽JFrame)
    * �Դ����������
    * ��ʾ����
    * 4, ��������JPael,�಼�ֹ��������Ƕ���������Ĭ��Ϊ��ʽ����
    */
    public class ͼ�ν���GUI extends JFrame{//������̳�JFrame
    //JButton jb ;//�ڴ˶������
    JButton jb1,jb2,jb3,jb4,jb5,jb6;//��ť
    JPanel jp1,jp2,jp3,jp4,jp5;//���
    JLabel jl1,jl2,jl3,jl4,jl5;//��ǩ
    JTextField jtf1,jtf2;//�ɱ༭�ı���
    JPasswordField jpf1;//�����
    JCheckBox jcb1,jcb2,jcb3 ;//��ѡ��
    JRadioButton jrb1,jrb2 ;//��ѡ����Ҫ�ȷ��뵽ButtonGroup�У�������ʵ�ֵ�ѡ
    ButtonGroup bg ;
    JComboBox jcb ;//������
    JList jl ;//�б�����
    JScrollPane jsp ;//��������ͨ����JList���ʹ��
    JSplitPane jsp1 ;//��ִ��ڣ����������
    JTextArea jta ; //�����ı���
    JTabbedPane jtp ;//ѡ�����
    JMenuBar jmb ;//�˵������������
    JMenu jm1,jm2,jm3,jm4,jm5, jm6 ;//�˵����������֦�������������֦��ֱ����Ҷ Ϊֹ
    JMenuItem jmi1,jmi2,jmi3,jmi4,jmi5,jmi6,jmi7, jmi8,jmi9 ;//�˵����������Ҷ
    JToolBar jtb ;//������������ֽй������
    int size = 9;
    JButton [] jbs = new JButton[size];
    public static void main(String args[]){
    	ͼ�ν���GUI gui = new ͼ�ν���GUI();
    }
    public ͼ�ν���GUI(){
//     JFrame jf = new JFrame();//���壬�̳�֮��Ͳ���ʵ������
//     this.setTitle("hi, JFrame");//���⣬�̳�֮�����this����jf;
//     this.setSize(800, 500);//��С(����)
//     this.setLocation(300,100);//���ô����λ�ã�x = 100, y = 200;
//     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���õ�����ر�ʱ���˳�jvm(�����);
//     this.setVisible(true);//��ʾ��Ĭ��Ϊfalse
//     
    	
    	//�߽粼�֣�BorderLayout
//     jb1 = new JButton("��");//ʵ������ť����������
//     jb2 = new JButton("��");//ʵ������ť����������
//     jb3 = new JButton("��");//ʵ������ť����������
//     jb4 = new JButton("��");//ʵ������ť����������
//     jb5 = new JButton("��");//ʵ������ť����������
//     this.add(jb1,BorderLayout.CENTER);//������
//     this.add(jb2,BorderLayout.NORTH);
//     this.add(jb3,BorderLayout.EAST);
//     this.add(jb4,BorderLayout.SOUTH);
//     this.add(jb5,BorderLayout.WEST);//��ȱ��һ������ʱ���м�ͻ�����ռ����"����"
//     this.setTitle("���Ǳ߽粼��");
//     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���õ�����ر�ʱ���˳�JVM(�����);
//     this.setSize(200,200); //��С(����)
//     this.setVisible(true);//��ʾ��Ĭ��ΪFALSE
//     
    	
    	//��ʽ���֣�FlowLayout
//     jb1 = new JButton("����");//ʵ������ť����������
//     jb2 = new JButton("�ŷ�");
//     jb3 = new JButton("����");
//     jb4 = new JButton("��");
//     jb5 = new JButton("����");
//     jb6 = new JButton("�ҵ�");
//     this.add(jb1);
//     this.add(jb2);
//     this.add(jb3);
//     this.add(jb4);
//     this.add(jb5);
//     this.add(jb6);
//     //���ò��ַ�ʽ�������ö��뷽ʽ��Ĭ��Ϊ����
//     this.setLayout(new FlowLayout(FlowLayout.LEFT));
//     this.setTitle("������ʽ����");
//     this.setResizable(true);//�����û����������޸Ĵ�С
//     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���õ�����ر�ʱ���˳�jvm(�����);
//     this.setSize(300, 400);//��С(����)
//     this.setLocation(1000,200);//���ô����λ�ã�x = 200, y = 200;
//     this.setVisible(true);//��ʾ��Ĭ��Ϊfalse
//     
    	
    	//���񲼾�GridLayout
//     for(int i = 0; i < size; i ++){
//	     //System.out.println("aa");
//	     jbs[i] = new JButton(String.valueOf(i+1));
//	     this.add(jbs[i]);
//     }
//     //�������񲼾֣������ֱ��ʾ��3�У�3�У�ˮƽ��࣬��ֱ���
//     this.setLayout(new GridLayout(3, 3, 5, 5));
//     this.setTitle("�������񲼾�");
//     this.setResizable(false);//�����û����������޸Ĵ�С
//     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���õ�����ر�ʱ���˳�jvm(�����);
//     this.setSize(300, 400);//��С(����)
//     this.setLocation(1000,200);//���ô����λ�ã�x = 200, y = 200;
//     this.setVisible(true);//��ʾ��Ĭ��Ϊfalse
//    
    	
    	//����������JPanel
//     jp1 = new JPanel();//Ĭ��Ϊ������
//     jp2 = new JPanel();
//     jb1 = new JButton("����");
//     jb2 = new JButton("ƻ��");
//     jb3 = new JButton("�㽶");
//     jb4 = new JButton("����");
//     jb5 = new JButton("ľ��");
//     jb6 = new JButton("��֦");
//     // ��ӵ�JPanel
//     jp1.add(jb1);
//     jp1.add(jb2);
//     jp2.add(jb3);
//     jp2.add(jb4);
//     jp2.add(jb5);
//     //���뵽JFame
//     this.add(jp1, BorderLayout.NORTH);
//     this.add(jp2, BorderLayout.SOUTH);
//     this.add(jb6, BorderLayout.CENTER);
//     this.setTitle("������岼��");
//     this.setResizable(false);//�����û����������޸Ĵ�С
//     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���õ�����ر�ʱ���˳�jvm(�����);
//     this.setSize(400, 200);//��С(����)
//     this.setLocation(200,200);//���ô����λ�ã�x = 200, y = 200;
//     this.setVisible(true);//��ʾ��Ĭ��Ϊfalse
//    
    	
    	//��������������ۺ�Ӧ�ã���¼ϵͳ-�ɱ༭�ı��򣬱�ǩ�������
//     jb1 = new JButton("ȷ��");
//     jb2 = new JButton("ȡ��");
//     jl1 = new JLabel("�û���");
//     jl2 = new JLabel("��  ��");
//     jtf1 = new JTextField(10);
//     jpf1 = new JPasswordField(10);//ʵ���������ô�С
//     //�������
//     jp1 = new JPanel();
//     jp2 = new JPanel();
//     jp3 = new JPanel();
//     //����������
//     jp1.add(jl1);
//     jp1.add(jtf1);
//     jp2.add(jl2);
//     jp2.add(jpf1);
//     jp3.add(jb1);
//     jp3.add(jb2);
//     this.add(jp1);
//     this.add(jp2);
//     this.add(jp3);
//     //���ò��ַ�ʽ ���������У��У�ˮƽ��࣬��ֱ��ࣩ
//     this.setLayout(new GridLayout(3,1,1,1));
//     this.setTitle("���¼");
//     this.setResizable(false);//�����û����������޸Ĵ�С
//     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���õ�����ر�ʱ���˳�jvm(�����);
//     this.setSize(300, 170);//��С(����)
//     this.setLocation(200,200);//���ô����λ�ã�x = 200, y = 200;
//     this.setVisible(true);//��ʾ��Ĭ��Ϊfalse
//    
    	
    	//��������������ۺ�Ӧ�ã���ѡ���뵥ѡ��
//	 jl1 = new JLabel("��ϲ����ˮ����");
//	 jcb1 = new JCheckBox("ƻ��");
//	 jcb2 = new JCheckBox("����");
//	 jcb3 = new JCheckBox("�㽶");
//	 jl2 = new JLabel("�����Ա�");
//	 jrb1 = new JRadioButton("��");
//	 jrb2 = new JRadioButton("Ů");
//	 jb1 = new JButton("ע��");
//	 jb2 = new JButton("ȡ��");
//     bg = new ButtonGroup();
//     bg.add(jrb1);//�ѵ�ѡ��ť���뵽bg��
//     bg.add(jrb2);
//     //���
//     jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
//     jp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
//     jp3 = new JPanel();
//     jp1.add(jl1);
//     jp1.add(jcb1);
//     jp1.add(jcb2);
//     jp1.add(jcb3);
//     jp2.add(jl2);
//     jp2.add(jrb1);
//     jp2.add(jrb2);
//     jp3.add(jb1);
//     jp3.add(jb2);
//     this.add(jp1);
//     this.add(jp2);
//     this.add(jp3);
//     this.setLayout(new GridLayout(3,1,1,1));
//     this.setTitle("���¼");
//     this.setResizable(false);//�����û����������޸Ĵ�С
//     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���õ�����ر�ʱ���˳�jvm(�����);
//     this.setSize(300, 150);//��С(����)
//     this.setLocation(200,200);//���ô����λ�ã�x = 200, y = 200;
//     this.setVisible(true);//��ʾ��Ĭ��Ϊfalse
//	
    	
    	//��������������ۺ�Ӧ�ã��б��������
//     jl1 = new JLabel("��ѡ����У�");
//     jl2 = new JLabel("��ѡ�񾰵㣺");
//     String jg [] = new String[]{"����", "�Ͼ�", "���"};
//     jcb = new JComboBox(jg);
//     String jd [] = new String[]{"����", "�찲��", "�ƺ�"};
//     jl = new JList(jd);
//     jl.setVisibleRowCount(2);////����ϣ����ʾ���ٸ�ѡ��
//     jsp = new JScrollPane(jl);//���б���뵽��������
//     //���
//     jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
//     jp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
//     jp1.add(jl1);
//     jp1.add(jcb);
//     jp2.add(jl2);
//     jp2.add(jsp);//������б�Ĺ�����
//     this.add(jp1);
//     this.add(jp2);
//     this.setLayout(new GridLayout(2,1,1,1));
//     this.setTitle("��ѡ��");
//     this.setResizable(false);//�����û����������޸Ĵ�С
//     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���õ�����ر�ʱ���˳�jvm(�����);
//     this.setSize(300, 200);//��С(����)
//     this.setLocation(200,200);//���ô����λ�ã�x = 200, y = 200;
//     this.setVisible(true);//��ʾ��Ĭ��Ϊfalse
//    
    	
    	//��ִ���
//     String words [] = new String []{"girl","boy","book","good" };
//     jl = new JList(words);
//     jl1 = new JLabel(new ImageIcon("images/f81.png"));
//     jsp1 = new JSplitPane (JSplitPane.HORIZONTAL_SPLIT, jl, jl1);//ˮƽ���HORIZONTAL_SPLIT,��ֱ���VERTICAL_SPLIT
//     jsp1.setOneTouchExpandable(true);//��ֵĴ��ڿ�����
//     this.add(jsp1);
//     this.setTitle("��ִ���");
//     this.setResizable(false);//�����û����������޸Ĵ�С
//     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���õ�����ر�ʱ���˳�jvm(�����);
//     this.setSize(500, 500);//��С(����)
//     this.setLocation(200,200);//���ô����λ�ã�x = 200, y = 200;
//     this.setVisible(true);//��ʾ��Ĭ��Ϊfalse
    
    	
    	//QQ�������
//     jta = new JTextArea();
//     jsp = new JScrollPane(jta);//���������
//     jp1 = new JPanel();
//     String myj [] = new String [] {"��־��","����","���ϼ"};
//     jcb = new JComboBox(myj);
//     jtf1 = new JTextField(20);
//     jb1 = new JButton("����");
//     jp1.add(jcb);
//     jp1.add(jtf1);
//     jp1.add(jb1);
//     this.setLayout(new BorderLayout());
//     this.add(jsp);
//     this.add(jp1, BorderLayout.SOUTH);
//     this.setTitle("qq����");
//     this.setIconImage(new ImageIcon("images/f8.png").getImage());//����Icon
//     this.setResizable(false);//�����û����������޸Ĵ�С
//     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���õ�����ر�ʱ���˳�jvm(�����);
//     this.setSize(500, 500);//��С(����)
//     this.setLocation(200,200);//���ô����λ�ã�x = 200, y = 200;
//     this.setVisible(true);//��ʾ��Ĭ��Ϊfalse
    
    	
    	//qq��¼����
//     jl1 = new JLabel(new ImageIcon("images/bg.gif"));
//     jl2 = new JLabel("QQ����", JLabel.CENTER);
//     jl3 = new JLabel("QQ����", JLabel.CENTER);
//     jl4 = new JLabel("��������", JLabel.CENTER);
//     jl4.setFont(new Font("����", Font.PLAIN, 16));//��������
//     jl4.setForeground(Color.BLUE);
//     jl5 = new JLabel("<html><a href='www.qq.com'>�������뱣��</a>");//���ó�����
//     jl5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//�����"����"
//     jcb1 = new JCheckBox("�����¼");
//     jcb2 = new JCheckBox("��ס����");
//     jtf1 = new JTextField();
//     jpf1 = new JPasswordField();
//     jtp = new JTabbedPane();
//     jp1 = new JPanel();
//     jp2 = new JPanel(new GridLayout(3,3,5,5));
//     jp3 = new JPanel();
//     jp3.setBackground(Color.BLUE);
//     jp4 = new JPanel();
//     jp4.setBackground(Color.CYAN);
//     jb4 = new JButton("�������");
//     jb1 = new JButton("��          ¼");
//     jb1.addActionListener(new ActionListener() {
//     	public void actionPerformed(ActionEvent e) {
//     		System.out.println("���ѵ�¼��");
//     	}
//     });
//     jb2 = new JButton("ȡ          ��");
//     jb3 = new JButton("ע����");
//     jp1.add(jb1);
//     jp1.add(jb2);
//     jp1.add(jb3);
//     jp2.add(jl2);
//     jp2.add(jtf1);
//     jp2.add(jb4);
//     jp2.add(jl3);
//     jp2.add(jpf1);
//     jp2.add(jl4);
//     jp2.add(jcb1);
//     jp2.add(jcb2);
//     jp2.add(jl5);
//     jtp.add("QQ����",jp2);
//     jtp.add("�ֻ�����",jp3);
//     jtp.add("QQ����",jp4);
//     getContentPane().setLayout(new BorderLayout());
//     getContentPane().add(jtp);
//     getContentPane().add(jl1, BorderLayout.NORTH);
//     getContentPane().add(jp1, BorderLayout.SOUTH);
//     this.setTitle("qq����");
//    this.setIconImage(new ImageIcon("images/f8.png").getImage());//����Icon
//    this.setResizable(false);//�����û����������޸Ĵ�С
//    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���õ�����ر�ʱ���˳�jvm(�����);
//    this.setSize(300, 250);//��С(����)
//    this.setLocation(500,400);//���ô����λ�ã�x = 200, y = 200;
//    this.setVisible(true);//��ʾ��Ĭ��Ϊfalse
   
    
    //���±����˵�Ӧ��
    //�½�������(����)
    jtb = new JToolBar();
    jb1 = new JButton("�½�");
    jb1.setToolTipText("�½�һ���ļ�");//���õ�����ƶ��������ťʱ��ʾ����ʾ��Ϣ
    jb2 = new JButton("����");
    jb2.setToolTipText("����һ���ļ�");
    jb3 = new JButton("��");
    jb4 = new JButton("����");
    jb5 = new JButton("ճ��");
    jb6 = new JButton("����");
    //�½��˵��������ɣ�����
    jmb = new JMenuBar();
    jm1 = new JMenu("�ļ�(F)");
    jm1.setMnemonic('F');//�������Ƿ�
    jm2 = new JMenu("�༭(E)");
    jm2.setMnemonic('E');
    jm3 = new JMenu("��ʽ(O)");
    jm3.setMnemonic('O');
    jm4 = new JMenu("�鿴(V)");
    jm4.setMnemonic('V');
    jm5 = new JMenu("����(H)");
    jm5.setMnemonic('H');
    jm6 = new JMenu("�½�");
    jmi1 = new JMenuItem("�ļ�");
    jmi2 = new JMenuItem("����");
    jmi3 = new JMenuItem("��", new ImageIcon("iamges/f8.png"));
    jmi4 = new JMenuItem("����(s)");
    jmi4.setMnemonic('S');
    //jmi4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.vk_S,));
    jmi5 = new JMenuItem("���Ϊ");
    jmi6 = new JMenuItem("ҳ������");
    jmi7 = new JMenuItem("��ӡ");
    jmi8 = new JMenuItem("�˳�");
    jm6.add(jmi1);//�½��м�����Ҷ
    jm6.add(jmi2);
    jm1.add(jm6);//Ϊ�ļ��˵�������֦��Ҷ
    //jm1.add(jmi2);
    jm1.add(jmi3);
    jm1.add(jmi4);
    jm1.add(jmi5);
    jm1.addSeparator();//����ָ���
    jm1.add(jmi6);
    jm1.add(jmi7);
    jm1.addSeparator();
    jm1.add(jmi8);
    jmb.add(jm1);//���˵���ӵ��˵�����
    jmb.add(jm2);
    jmb.add(jm3);
    jmb.add(jm4);
    jmb.add(jm5);
    jta = new JTextArea();//�����ı���
    jtb.add(jb1);
    jtb.add(jb2);
    jtb.add(jb3);
    jtb.add(jb4);
    jtb.add(jb5);
    jtb.add(jb6);
    //���˵������뵽������
    this.setJMenuBar(jmb);
    this.add(jtb, BorderLayout.NORTH);//�����������뵽����(����)��
    jsp = new JScrollPane(jta);
    //jsp.setVerticalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);//�������������
    this.add(jsp);
    this.setTitle("���±�");
    this.setIconImage(new ImageIcon("images/f8.png").getImage());//����Icon
    this.setResizable(false);//�����û����������޸Ĵ�С
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���õ�����ر�ʱ���˳�jvm(�����);
    this.setSize(400, 550);//��С(����)
    this.setLocation(500,400);//���ô����λ�ã�x = 200, y = 200;
    this.setVisible(true);//��ʾ��Ĭ��Ϊfalse
    }
   }