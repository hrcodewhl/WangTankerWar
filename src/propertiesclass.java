import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.print.DocFlavor.URL;

public class propertiesclass {
	public void saveproperties(String key,String value){
		String path=null;
		//path = propertiesclass.class.getResource("/").getPath()+"message.properties";
		path=this.getClass().getResource("Images/message.properties").getPath();
		Properties pro=new Properties();//定义Properties对象
		pro.setProperty(key, value);//设置属性文件值
		try{
			FileOutputStream out=new FileOutputStream(path);
			pro.store(out, "用户账号信息");//将信息通过流写入到属性文件
			out.close();//关闭流
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean getProperties1(String keyname){//检查注册的账号是否已经存在
		int flag=0;String path=null;
		InputStream ins=null;
		ins=this.getClass().getResourceAsStream("Images/message.properties");
		//path=this.getClass().getResource("message.properties").getPath();
		
		/*try {
			ins = new FileInputStream(path);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//根据属性文件创建InputStream对象*/
		Properties pro= new Properties();//创建Properties对象
		try {
			pro.load(ins);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//从输入流中读取属性文件中的信息
		for (Object key : pro.keySet()) { 
               if(key.equals(keyname)){
               flag=1;break;
               }
		}
		try {
			ins.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag==1){
		return true;
		}
		else{
		return false;
		}
	}
	public boolean getProperties2(String keyname,String password){//验证账号密码是否输入正确
		int flag=0;String path=null;
		InputStream ins=null;
		ins=this.getClass().getResourceAsStream("Images/message.properties");
		Properties pro= new Properties();//创建Properties对象
		try {
			pro.load(ins);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//从输入流中读取属性文件中的信息
		for (Object key : pro.keySet()) { 
               if(key.equals(keyname)&&pro.get(key).equals(password)){
               flag=1;break;
               }
		}
		try {
			ins.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag==1){
		return true;
		}
		else{
		return false;
		}
	}

}
