package demo.test;

import java.io.*;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 15:45 2018/2/28 .
 */
public class Singleton {

    private Singleton(){}

    private static class SingletonHolder{
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.instance;
    }

    public Object deepClone() throws IOException,ClassNotFoundException{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos    = new ObjectOutputStream(bos);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois    = new ObjectInputStream(bis);
        return ois.readObject();
    }
}
