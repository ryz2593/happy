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

    /**
     * @param fileDir
     * @throws IOException
     */
    public static void generateFileMd5(File fileDir) throws IOException {
        File[] fs = fileDir.listFiles();
        for (File f : fs) {
            Set<String> list = new HashSet<String>();
            list.add(f.getAbsolutePath());

            if (f.isFile()) {
                String md5 = DigestUtils.md5Hex(new FileInputStream(f));
                System.out.println(md5);
            } else {
                generateFileMd5(f);
            }
        }
    }
}
