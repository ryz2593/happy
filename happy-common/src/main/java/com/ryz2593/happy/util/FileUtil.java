package com.ryz2593.happy.util;

import com.google.common.collect.Lists;

import java.io.*;
import java.util.List;

/**
 * @author ryz2593
 */
public class FileUtil {
    /**
     * 读取文件
     *
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
     * 获取文件夹下制定文件后缀的文件列表
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
}
