package demo.utils;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * @Description: zip压缩工具
 * @Author: changrong.zeng
 * @Date: Created in 13:57 2018/5/29 .
 */
public class ZipUtil {
    private static final Logger logger = Logger.getLogger(ZipUtil.class.getName());

    /**
     * zip压缩方法
     * @param fileName 要压缩的源文件
     * @param zipName  目标文件
     */
    public static  void zip(String fileName,String zipName){
        //打包压缩文件
        try {
            File file = new File(fileName);
            ArrayList<File> files = new ArrayList<File>();
            files.add(file);
            ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipName)));
            byte[] buf = new byte[8192];
            int len;
            for (File tmpFile : files) {
                if (!tmpFile.isFile()) continue;
                ZipEntry ze = new ZipEntry(tmpFile.getName());
                zos.putNextEntry(ze);
                BufferedInputStream bis = new BufferedInputStream( new FileInputStream( tmpFile ) );
                while ((len = bis.read( buf ) ) > 0 ) {
                    zos.write( buf, 0, len );
                }
                zos.closeEntry();
            }
            zos.close();
        } catch (IOException e) {
           logger.error("ZipUtil zip error,fileName=" + fileName);
        }
    }

//    private void zip(File file) {
//        logger.info("zipFile=" + file.getName());
//        long start = System.currentTimeMillis();
//        try {
//            String fileName = file.getName();
//            fileName = constants.getToBankZipPath() + "/" + fileName.substring(0, fileName.lastIndexOf(".")) + ".zip";
//            ZipFile zipFile = new ZipFile(fileName);
//            ZipParameters parameters = new ZipParameters();
//            // 设置压缩方法
//            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
//            // 设置压缩级别
//            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_FASTEST);
//            if(constants.getPassword() != null && !"".equals(constants.getPassword())) {
//                // 设置压缩文件加密
//                parameters.setEncryptFiles(true);
//                // 设置加密方法
//                parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
//                // 设置密码
//                parameters.setPassword(constants.getPassword());
//                // 设置AES加密强度
//                parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
//            }
//            // 添加文件到压缩文件
//            zipFile.addFile(file, parameters);
//            if(constants.isDoCksum()) {
//                // constants.getCksumSB().append(" ")
//                // .append(file.getPath().replaceAll("\\(", "\\\\(").replaceAll("\\)", "\\\\)"));// 源文件全路径
//                // constants.getCksumSB().append(" ")
//                // .append(fileName.replaceAll("\\(", "\\\\(").replaceAll("\\)", "\\\\)"));// 压缩文件全路径
//                constants.getCksumSB().append(" ").append(file.getPath());// 源文件全路径
//                constants.getCksumSB().append(" ").append(fileName);// 压缩文件全路径
//            }
//        }catch (Exception e) {
//            log.error(e.getMessage());
//        }
//        long end = System.currentTimeMillis();
//        log.info("zip " + file.getName() + " cost " + (end - start) / 1000 + "s");
//    }
}
