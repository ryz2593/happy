package com.ryz2593.happy.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;

/**
 * @author ryz2593
 * @date 2020/4/2 16:30
 */
public class MD5Util {

    private static Logger logger = Logger.getLogger(MD5Util.class);

    public static String getMD5(String s) {


        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            byte[] btInput = s.getBytes("UTF-8");
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            logger.error(e);
            return null;
        }
    }

    public static String getMD5(InputStream inputStream) {
        try {
            return DigestUtils.md5Hex(inputStream);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error(e);
                }
            }
        }

        return null;
    }

    public static String getMD5FromURL(String url) {
        try {
            return getMD5(new URL(url).openStream());
        } catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    public static String getMD5(File file) {
        try {
            return getMD5(new FileInputStream(file));
        } catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    public static String getMD5(byte[] bytes) {

        return DigestUtils.md5Hex(bytes);
    }

    public static void main(String[] args) throws Exception {
        System.out.print(MD5Util.getMD5("nbksur5uryt"));
    }
}
