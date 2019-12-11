package com.ryz2593.happy.util;

import com.google.common.collect.Lists;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ryz2593
 */
public class FileUtil {

    /**
     * 获取文件后缀
     * @param file
     * @return
     */
    public static String getFileSuffix(File file) {
        return file.getName().substring(file.getName().lastIndexOf(".") + 1);
    }

    /**
     * 读取文件
     * @param Path
     * @return
     */
    public static String ReadFile(String Path) {
        BufferedReader reader = null;
        StringBuilder laststr = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr.toString();
    }

    /**
     * 获取文件夹下指定文件后缀的文件列表
     *
     * @param fileDir
     * @param suffix
     * @return
     */
    public static List<File> getFiles(File fileDir, String suffix) {
        List<File> files = Lists.newArrayList();
        File[] fs = fileDir.listFiles();
        for (File f : fs) {
            if (f.isFile()) {
                if (suffix.equalsIgnoreCase(f.getName().substring(f.getName().lastIndexOf(".") + 1))) {
                    files.add(f);
                }
            } else {
                List<File> fts = getFiles(f, suffix);
                files.addAll(fts);
            }
        }
        return files;
    }

    /**
     * 计算文件的md5值
     * @param fileDir
     * @throws IOException
     */
    public static void generateFileMd5(File fileDir) {
        File[] fs = fileDir.listFiles();
        for (File f : fs) {
            Set<String> list = new HashSet<String>();
            list.add(f.getAbsolutePath());

            if (f.isFile()) {
                String md5 = null;
                try {
                    md5 = DigestUtils.md5Hex(new FileInputStream(f));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(f.getName() + ", " + md5);
            } else {
                generateFileMd5(f);
            }
        }
    }

    public static void main(String[] args) {
        String templateListFolder = "C:\\Users\\ryz2593\\Desktop\\eyeshadow_upper(5)";
        File file = new File(templateListFolder);
        //generateFileMd5(file);

        getFiles(file, "ini");
        System.out.println(getFileSuffix(new File("C:\\Users\\ryz2593\\Desktop\\eyeshadow_upper(5)\\web_aa001_upper.ini")));
        System.out.println(ReadFile("C:\\Users\\ryz2593\\Desktop\\eyeshadow_upper(5)\\web_aa001_upper.ini"));
    }
}
