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
	private static int flag=1;//标记是否已经有符合账号与密码的记录
	private static String sql=null;
	private static String user=null;
	private String psword=null;
	private static String getName=null;
	private static String getPwd=null;
	private static ResultSet rs=null;
	// 用户名
	private JLabel usern;
	private JTextField username;
	// 密码
	private JLabel passw;
	private JPasswordField password;
	private JLabel jl1;//背景
	private JButton bu1;//登入按钮
	private JButton bu2;//注册按钮
	
	
	public Login() {
    	flag=0;
        // 设置窗口标题
        this.setTitle("坦克大战登入");
        // 窗体组件初始化
        init();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // 设置布局方式为绝对定位
        this.setLayout(null);
         
        this.setBounds(0, 0, 355, 265);
        // 设置窗体的标题图标
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image image = tk.getImage(Login.class.getResource("Images/icon.jpg"));
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
	public void init() {
        // 创建一个容器
        Container con = this.getContentPane();
        jl1 = new JLabel();
        // 设置背景图片
        jl1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/background.jpg")));
        jl1.setBounds(0, 0, 355, 265);
        // 用户号码登录输入框
        usern= new JLabel("账号：");
        usern.setBounds(80, 100, 150, 20);
        username = new JTextField();//得到账号信息
        username.setBounds(120, 100, 150, 20);
        // 密码输入框
        passw= new JLabel("密码：");
        passw.setBounds(80, 130, 150, 20);
        password = new JPasswordField();
        password.setBounds(120, 130, 150, 20);
        // 登录按钮设定
        bu1 = new JButton("登录");
        bu1.setBounds(200, 160, 65, 20);
        // 给登录按钮添加1个事件
        bu1.addActionListener(new ActionListener(){
        	@Override
            public void actionPerformed(ActionEvent e) {
        		 String str=e.getActionCommand();
	                if("登录".equals(str)){
	                	 getName =username.getText();//账号
	                     getPwd =password.getText();//密码    
	                }
	                if(getName.length()==0){
	                	flag=1;
	                	JOptionPane.showMessageDialog(null,"请输入账号", str, JOptionPane.INFORMATION_MESSAGE);
	                }
	                else if(getPwd.length()==0){
	                	flag=2;
	                	JOptionPane.showMessageDialog(null,"请输入密码", str, JOptionPane.INFORMATION_MESSAGE);
	                }
	                else{
	                	propertiesclass proper=new propertiesclass();
	                	if(proper.getProperties2(getName.trim(),getPwd.trim())){
	                		flag=3;
	                		Dispose();
	                		new TankClient();
	                	}
	                    if(flag==0){
	                    	JOptionPane.showMessageDialog(null,"账号或密码输入错误", str, JOptionPane.INFORMATION_MESSAGE);
	                    }
	                }
        	}
        });
        bu2 = new JButton("注册");
        bu2.setBounds(120, 160, 65, 20);
        bu2.addActionListener(new ActionListener(){
        	@Override
            public void actionPerformed(ActionEvent e) {
        		 new Register();
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
	public static void main(String[] args){
		new Login();
	}
 }
