package demo.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 16:40 2018/5/22 .
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        try {
            Charset charset = Charset.forName("UTF-8");//Java.nio.charset.Charset处理了字符转换问题。它通过构造CharsetEncoder和CharsetDecoder将字符序列转换成字节和逆转换。
            CharsetDecoder decoder = charset.newDecoder();
            File file = new File("D:\\test_dev.txt");
            FileInputStream fis = new FileInputStream(file);
            FileChannel channel = fis.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            CharBuffer cb = CharBuffer.allocate(2000);
            int byteRead = channel.read(buffer);
            while (byteRead != -1) {
//                System.out.println("Read " + byteRead);
                buffer.flip();
                decoder.decode(buffer, cb, false);
                cb.flip();
                while (cb.hasRemaining()) {
                    System.out.print((char) cb.get());
                }
                buffer.clear();
                cb.clear();
                byteRead = channel.read(buffer);
            }
            fis.close();
            } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
