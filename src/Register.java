import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register extends JFrame{

		private static boolean flag=false;
		private static ResultSet rs=null;
		// �û���
		private JLabel usern;
		private JTextField username;
	    // ����
		private JLabel passw;
		private JPasswordField password;
		private JLabel jl1;//����
		private JButton bu1;//ȷ����ť
		private JButton bu2;//���ذ�ť
	    /*
	     * ���췽��
	     */
		
	    public Register() {
	    	flag=false;
	        // ���ô��ڱ���
	        this.setTitle("�˺�ע��");
	        // ���������ʼ��
	        init();
	        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        // ���ò��ַ�ʽΪ���Զ�λ
	        this.setLayout(null);
	         
	        this.setBounds(0, 0, 355, 265);
	        // ���ô���ı���ͼ��
	        Toolkit tk = Toolkit.getDefaultToolkit();
	        Image image = tk.getImage(Register.class.getResource("Images/icon.jpg"));
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
	    public void init(){
	    	 // ����һ������
	        Container con = this.getContentPane();
	        jl1 = new JLabel();
	        // ���ñ���ͼƬ
	        jl1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/background.jpg")));
	        jl1.setBounds(0, 0, 355, 265);
	        // �û������¼�����
	        usern= new JLabel("�˺ţ�");
	        usern.setBounds(80, 100, 150, 20);
	        username = new JTextField();
	        username.setBounds(120, 100, 150, 20);
	        // ���������
	        passw= new JLabel("���룺");
	        passw.setBounds(80, 130, 150, 20);
	        password = new JPasswordField();
	        password.setBounds(120, 130, 150, 20);
	        // ע�ᰴť�趨
	        bu1 = new JButton("ȷ��");
	        bu1.setBounds(120, 160, 65, 20);
	        // ��ע�ᰴť���1���¼�
	        bu1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String getName =username.getText();//�˺�
                    String getPwd =password.getText();//����
                    String us1=null;
                    String sql=null;
                   //�ж�ע����˺ź�����ĳ����Ƿ����Ҫ��
                    //�˺�С��30���ֽ�
                    //����С��20���ֽ�
                    if(getName.length()>30||getPwd.length()>20){
                    	JOptionPane.showConfirmDialog(null,"�˺Ż����������");
                    }
                    else{
                    	if(getName.length()==0){
    						JOptionPane.showMessageDialog(null,"�������˺�", null, JOptionPane.INFORMATION_MESSAGE);
    					}
                    	else if(getPwd.length()==0){
    						JOptionPane.showMessageDialog(null,"����������", null, JOptionPane.INFORMATION_MESSAGE);
    					}
                    	else {
                    		propertiesclass proper=new propertiesclass();
                    		flag=proper.getProperties1(getName.trim());
                    		if(flag){
                    			JOptionPane.showMessageDialog(null,"���˺��ѱ�ע��", null, JOptionPane.INFORMATION_MESSAGE);
                    		}
                    	}
    					if(!flag){
    						propertiesclass proper=new propertiesclass();
    						proper.saveproperties(getName.trim(), getPwd.trim());
    						JOptionPane.showMessageDialog(null,"�˺�ע��ɹ�", null, JOptionPane.INFORMATION_MESSAGE);
    						Dispose();
    						new Login();
    					}
                    }
				}
	        });
	        
	        //���ذ�ť
	        bu2 = new JButton("����");
	        bu2.setBounds(200, 160, 65, 20);
	        // ��ע�ᰴť���1���¼�
	        bu2.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Login();
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

}
