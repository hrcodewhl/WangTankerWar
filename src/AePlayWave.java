import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

class AePlayWave extends Thread {
	private String filename;
	private boolean flag=true;
	public AePlayWave(String wavfile) {
		filename = wavfile;
	
	}public void setflag(boolean ff){
			this.flag=ff;
	}
	public void run() {
		while(true){
		System.out.println("��ʼ�����߳�");
		File soundFile = new File(filename);
		AudioInputStream audioInputStream = null;
		try {
		audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (Exception e1) {
		e1.printStackTrace();
		return;
		}
		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		
		auline.start();
		int nBytesRead = 0;
		//���ǻ���
		byte[] abData = new byte[512];
		try {
			while (nBytesRead != -1) {
				//System.out.printf("���ڲ�������");
				while(flag){//�ж��Ƿ񲥷�����
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0)
					auline.write(abData, 0, nBytesRead);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			auline.drain();
			auline.close();
		}
	}
	}
}
	
	
	
	
	
	
	