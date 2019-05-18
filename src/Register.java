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
		// 用户名
		private JLabel usern;
		private JTextField username;
	    // 密码
		private JLabel passw;
		private JPasswordField password;
		private JLabel jl1;//背景
		private JButton bu1;//确定按钮
		private JButton bu2;//返回按钮
	    /*
	     * 构造方法
	     */
		
	    public Register() {
	    	flag=false;
	        // 设置窗口标题
	        this.setTitle("账号注册");
	        // 窗体组件初始化
	        init();
	        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        // 设置布局方式为绝对定位
	        this.setLayout(null);
	         
	        this.setBounds(0, 0, 355, 265);
	        // 设置窗体的标题图标
	        Toolkit tk = Toolkit.getDefaultToolkit();
	        Image image = tk.getImage(Register.class.getResource("Images/icon.jpg"));
	       	this.setIconImage(image);
	         
	        // 窗体大小不能改变
	        this.setResizable(false);
	         
	        // 居中显示
	        this.setLocationRelativeTo(null);
	 
	        // 窗体可见
	        this.setVisible(true);
	    }
	    public void Dispose(){
			this.dispose();
		}
	    public void init(){
	    	 // 创建一个容器
	        Container con = this.getContentPane();
	        jl1 = new JLabel();
	        // 设置背景图片
	        jl1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/background.jpg")));
	        jl1.setBounds(0, 0, 355, 265);
	        // 用户号码登录输入框
	        usern= new JLabel("账号：");
	        usern.setBounds(80, 100, 150, 20);
	        username = new JTextField();
	        username.setBounds(120, 100, 150, 20);
	        // 密码输入框
	        passw= new JLabel("密码：");
	        passw.setBounds(80, 130, 150, 20);
	        password = new JPasswordField();
	        password.setBounds(120, 130, 150, 20);
	        // 注册按钮设定
	        bu1 = new JButton("确定");
	        bu1.setBounds(120, 160, 65, 20);
	        // 给注册按钮添加1个事件
	        bu1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String getName =username.getText();//账号
                    String getPwd =password.getText();//密码
                    String us1=null;
                    String sql=null;
                   //判断注册的账号和密码的长度是否符合要求
                    //账号小于30个字节
                    //密码小于20个字节
                    if(getName.length()>30||getPwd.length()>20){
                    	JOptionPane.showConfirmDialog(null,"账号或密码过长！");
                    }
                    else{
                    	if(getName.length()==0){
    						JOptionPane.showMessageDialog(null,"请输入账号", null, JOptionPane.INFORMATION_MESSAGE);
    					}
                    	else if(getPwd.length()==0){
    						JOptionPane.showMessageDialog(null,"请输入密码", null, JOptionPane.INFORMATION_MESSAGE);
    					}
                    	else {
                    		propertiesclass proper=new propertiesclass();
                    		flag=proper.getProperties1(getName.trim());
                    		if(flag){
                    			JOptionPane.showMessageDialog(null,"该账号已被注册", null, JOptionPane.INFORMATION_MESSAGE);
                    		}
                    	}
    					if(!flag){
    						propertiesclass proper=new propertiesclass();
    						proper.saveproperties(getName.trim(), getPwd.trim());
    						JOptionPane.showMessageDialog(null,"账号注册成功", null, JOptionPane.INFORMATION_MESSAGE);
    						Dispose();
    						new Login();
    					}
                    }
				}
	        });
	        
	        //返回按钮
	        bu2 = new JButton("返回");
	        bu2.setBounds(200, 160, 65, 20);
	        // 给注册按钮添加1个事件
	        bu2.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Login();
					Dispose();
				}
	  
	        });
	        
	      //控件加入面板
	        jl1.add(usern);
	        jl1.add(username);
	        jl1.add(passw);
	        jl1.add(password);
	        jl1.add(bu1);
	        jl1.add(bu2);
	        con.add(jl1);
	    }

}
