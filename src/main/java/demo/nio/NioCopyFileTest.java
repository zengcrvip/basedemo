package demo.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioCopyFileTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String resource = "d:\\input.txt";
		String destination = "d:\\output.txt";
		try {
			copyFile(resource,destination);
			System.out.println("copy file is success!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("coupy file error"+e.getMessage());
		}

	}
	
	public static void copyFile(String resource,String destination) throws IOException{
		FileInputStream fis = new FileInputStream(resource);
		FileOutputStream fos = new FileOutputStream(destination);
		FileChannel readChannel = fis.getChannel();    //读文件通道
		FileChannel writeChannel = fos.getChannel();   //写文件通道
		ByteBuffer buffer = ByteBuffer.allocate(1024);  //读入数据缓存
		while(true){
			 buffer.clear();
			 int len = readChannel.read(buffer);      //读入数据
			 if(len == -1){
				 break;
			 }
			 buffer.flip();
			 writeChannel.write(buffer);         //写入文件
		 }
		 readChannel.close();
		 writeChannel.close();
		
	}

}
