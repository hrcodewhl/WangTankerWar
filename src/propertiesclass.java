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
		Properties pro=new Properties();//����Properties����
		pro.setProperty(key, value);//���������ļ�ֵ
		try{
			FileOutputStream out=new FileOutputStream(path);
			pro.store(out, "�û��˺���Ϣ");//����Ϣͨ����д�뵽�����ļ�
			out.close();//�ر���
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean getProperties1(String keyname){//���ע����˺��Ƿ��Ѿ�����
		int flag=0;String path=null;
		InputStream ins=null;
		ins=this.getClass().getResourceAsStream("Images/message.properties");
		//path=this.getClass().getResource("message.properties").getPath();
		
		/*try {
			ins = new FileInputStream(path);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//���������ļ�����InputStream����*/
		Properties pro= new Properties();//����Properties����
		try {
			pro.load(ins);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//���������ж�ȡ�����ļ��е���Ϣ
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
	public boolean getProperties2(String keyname,String password){//��֤�˺������Ƿ�������ȷ
		int flag=0;String path=null;
		InputStream ins=null;
		ins=this.getClass().getResourceAsStream("Images/message.properties");
		Properties pro= new Properties();//����Properties����
		try {
			pro.load(ins);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//���������ж�ȡ�����ļ��е���Ϣ
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
