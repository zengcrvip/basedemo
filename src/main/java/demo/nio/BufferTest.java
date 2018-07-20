package demo.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 15:44 2018/5/31 .
 */
public class BufferTest {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("D:\\ABC_001.txt","rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buffer1 = ByteBuffer.allocate(1024);
            ByteBuffer buffer2 = ByteBuffer.allocate(512);
            channel.read(buffer1);
            buffer1.flip();
            while(buffer1.hasRemaining()){
                System.out.print((char) buffer1.get()); // read 1 byte at a time
            }

            System.out.println("==================================");
            channel.read(buffer2);
            buffer2.flip();
            while (buffer2.hasRemaining()){
                System.out.print((char) buffer2.get());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
