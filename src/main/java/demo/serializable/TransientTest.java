package demo.serializable;

import java.io.*;

/**
 * Created by changrong.zeng on 2017/12/7.
 */
public class TransientTest {
    public static void main(String[] args) {

        Studyer studyer = new Studyer();
        studyer.setUsername("Alexia");
        studyer.setPasswd("123456");
        studyer.setCode("ABCDEF");

        System.out.println("read before Serializable: ");
        System.out.println("username: " + studyer.getUsername());
        System.err.println("password: " + studyer.getPasswd());
        System.out.println("code: " + studyer.getCode());

        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("D:/user.txt"));
            os.writeObject(studyer); // 将User对象写进文件
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(
                    "D:/user.txt"));
            studyer = (Studyer) is.readObject(); // 从流中读取User的数据
            is.close();

            System.out.println("\n read after Serializable: ");
            System.out.println("username: " + studyer.getUsername());
            System.err.println("password: " + studyer.getPasswd());
            System.out.println("code: " + studyer.getCode());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class User implements Serializable {
    private static final long serialVersionUID = 8294180014912103005L;

    private String username;
    private transient String passwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }



}

class Studyer extends User{
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
