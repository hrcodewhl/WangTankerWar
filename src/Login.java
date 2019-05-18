import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;

import javax.swing.*;
public class Login extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int flag=1;//����Ƿ��Ѿ��з����˺�������ļ�¼
	private static String sql=null;
	private static String user=null;
	private String psword=null;
	private static String getName=null;
	private static String getPwd=null;
	private static ResultSet rs=null;
	// �û���
	private JLabel usern;
	private JTextField username;
	// ����
	private JLabel passw;
	private JPasswordField password;
	private JLabel jl1;//����
	private JButton bu1;//���밴ť
	private JButton bu2;//ע�ᰴť
	
	
	public Login() {
    	flag=0;
        // ���ô��ڱ���
        this.setTitle("̹�˴�ս����");
        // ���������ʼ��
        init();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // ���ò��ַ�ʽΪ���Զ�λ
        this.setLayout(null);
         
        this.setBounds(0, 0, 355, 265);
        // ���ô���ı���ͼ��
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image image = tk.getImage(Login.class.getResource("Images/icon.jpg"));
       	this.setIconImage(image);
         
        // �����С���ܸı�
        this.setResizable(false);
         
        // ������ʾ
        this.setLocationRelativeTo(null);
 
        // ����ɼ�
        this.setVisible(true);
    }
	public void Dispose(){
		this.dispose();
	}
	public void init() {
        // ����һ������
        Container con = this.getContentPane();
        jl1 = new JLabel();
        // ���ñ���ͼƬ
        jl1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/background.jpg")));
        jl1.setBounds(0, 0, 355, 265);
        // �û������¼�����
        usern= new JLabel("�˺ţ�");
        usern.setBounds(80, 100, 150, 20);
        username = new JTextField();//�õ��˺���Ϣ
        username.setBounds(120, 100, 150, 20);
        // ���������
        passw= new JLabel("���룺");
        passw.setBounds(80, 130, 150, 20);
        password = new JPasswordField();
        password.setBounds(120, 130, 150, 20);
        // ��¼��ť�趨
        bu1 = new JButton("��¼");
        bu1.setBounds(200, 160, 65, 20);
        // ����¼��ť���1���¼�
        bu1.addActionListener(new ActionListener(){
        	@Override
            public void actionPerformed(ActionEvent e) {
        		 String str=e.getActionCommand();
	                if("��¼".equals(str)){
	                	 getName =username.getText();//�˺�
	                     getPwd =password.getText();//����    
	                }
	                if(getName.length()==0){
	                	flag=1;
	                	JOptionPane.showMessageDialog(null,"�������˺�", str, JOptionPane.INFORMATION_MESSAGE);
	                }
	                else if(getPwd.length()==0){
	                	flag=2;
	                	JOptionPane.showMessageDialog(null,"����������", str, JOptionPane.INFORMATION_MESSAGE);
	                }
	                else{
	                	propertiesclass proper=new propertiesclass();
	                	if(proper.getProperties2(getName.trim(),getPwd.trim())){
	                		flag=3;
	                		Dispose();
	                		new TankClient();
	                	}
	                    if(flag==0){
	                    	JOptionPane.showMessageDialog(null,"�˺Ż������������", str, JOptionPane.INFORMATION_MESSAGE);
	                    }
	                }
        	}
        });
        bu2 = new JButton("ע��");
        bu2.setBounds(120, 160, 65, 20);
        bu2.addActionListener(new ActionListener(){
        	@Override
            public void actionPerformed(ActionEvent e) {
        		 new Register();
        		 Dispose();
        	}
        });
        //�ؼ��������
        jl1.add(usern);
        jl1.add(username);
        jl1.add(passw);
        jl1.add(password);
        jl1.add(bu1);
        jl1.add(bu2);
        con.add(jl1);
	}
	public static void main(String[] args){
		new Login();
	}
 }
