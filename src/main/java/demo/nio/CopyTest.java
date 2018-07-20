package demo.nio;

import java.io.RandomAccessFile;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 19:10 2018/5/24 .
 */
public class CopyTest {
    public static void main(String[] args) {
        try {
            RandomAccessFile fromFile = new RandomAccessFile("D:\\ABC_001.txt","rw");
            RandomAccessFile toFile   = new RandomAccessFile("D:\\to.txt","rw");
            FileChannel fromChannel = fromFile.getChannel();
            FileChannel toChannel   = toFile.getChannel();

            long position = 0;
            long count = fromChannel.size();

            toChannel.transferFrom(fromChannel,position,count);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
