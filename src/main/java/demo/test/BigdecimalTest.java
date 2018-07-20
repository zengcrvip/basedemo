package demo.test;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 15:22 2018/5/7 .
 */
public class BigdecimalTest {
    private static  final  String columnSeparator = new String("\\|");

    public static void main(String[] args) {
        //File类型可能是文件也可以是文件夹
        deal("D:\\source");

        String fileName = "ICBX_001.txt";
        String filePrefix = fileName.split("\\.")[0];
        String menuName = filePrefix.split("\\_")[0];
        String orderNo  = filePrefix.split("\\_")[1];
        System.out.println("menuName="+menuName + ",orderNo=" + orderNo);
    }

    public static void deal(String sourceName) {
        File file = new File(sourceName);
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isFile()) {//判断是否为文件
                System.out.println("===============" + fileList[i].getName());
                System.out.println("===============" + fileList[i].getParent());
                System.out.println("===============" + fileList[i].getAbsolutePath());
            }else{
                deal(fileList[i].getAbsolutePath());
            }
        }

    }
}
