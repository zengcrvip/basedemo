package demo.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by changrong.zeng on 2017/12/25.
 */
public class ClassLoaderTest extends ClassLoader{
    private String name;
    private String path = "d:\\";
    private final String fileType = ".class";

    public ClassLoaderTest(String name) {
        super();
        this.name = name;
    }

    public ClassLoaderTest(ClassLoader parent, String name) {
        super(parent);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        return this.defineClass(name,data,0,data.length);
    }

    private byte[] loadClassData(String name){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try{
            this.name = this.name.replace(".", "\\");
            is = new FileInputStream(new File(path + name + fileType));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read())){
                baos.write(ch);
            }
            data = baos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                is.close();
                baos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void showClassLoader(ClassLoader loader) throws Exception{
        Class clazz = loader.loadClass("Sample");
        Object object = clazz.newInstance();
    }

    public static void main(String[] args) {
        ClassLoaderTest loader1 = new ClassLoaderTest("loader1");
        loader1.setPath("d:\\loader1\\");
        ClassLoaderTest loader2 = new ClassLoaderTest(loader1, "loader2");
        loader2.setPath("d:\\loader2\\");
        ClassLoaderTest loader3 = new ClassLoaderTest(null, "loader3");
        loader3.setPath("d:\\loader3\\");
        try {
            showClassLoader(loader2);
            showClassLoader(loader3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
