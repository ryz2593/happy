package com.ryz2593.happy.util;

import com.google.common.collect.Lists;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 文件操作工具类
 * @author ryz2593
 */
public class FileUtil {

    /**
     * 获取文件后缀
     *
     * @param file
     * @return
     */
    public static String getFileSuffix(File file) {
        return file.getName().substring(file.getName().lastIndexOf(".") + 1);
    }

    /**
     * 读取文件中的内容，
     * 按行读取进行比较包含指定字符串则返回true，不包含则返回false
     *
     * @param path
     * @return
     */
    public static boolean readFile(String path) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String str;
            while ((str = in.readLine()) != null) {
                if (str.contains("ContourLight")) {
                    System.out.println(str);
                    return true;
                }
            }
        } catch (IOException e) {
        }
        return false;
    }

    /**
     * 读取文件，按行读取
     * @param path
     */
    public static void printFile(String path) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
        }
    }

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
     * 获取文件夹下指定文件后缀的文件列表
     * @param fileDir 文件目录
     * @param suffix  后缀名
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
     * 下载文件
     *
     * @param destUrl  源地址
     * @param fileName 保存地址
     * @throws IOException
     */
    public static void downloadToFile(String destUrl, String fileName) throws IOException {
        int BUFFER_SIZE = 1024;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;
        try {
            //建立链接
            url = new URL(destUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.setConnectTimeout(3000);
            httpUrl.setReadTimeout(60 * 1000);
            //连接指定的资源
//            httpUrl.connect();
            //获取网络输入流
            bis = new BufferedInputStream(httpUrl.getInputStream());
            new File(fileName).getParentFile().mkdirs();

            //建立文件
            fos = new FileOutputStream(fileName);

            //保存文件
            while ((size = bis.read(buf)) != -1) {
                fos.write(buf, 0, size);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                fos.close();
                bis.close();
            } catch (Exception e) {

            }

        }

    }

    /**
     * 解压文件
     *
     * @param zipFile  待解压文件
     * @param descFile 解压目录
     */
    public static void unZipFiles(java.io.File zipFile, String descFile) {
        byte[] buf = new byte[1024];
        try {
            ZipFile zf = new ZipFile(zipFile);
            for (Enumeration entries = zf.entries(); entries.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();
                InputStream in = zf.getInputStream(entry);
                OutputStream out = new FileOutputStream(descFile + zipEntryName);
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 计算文件的md5值
     *
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

    public static void main(String[] args) throws IOException {
//        String templateListFolder = "C:\\Users\\ryz2593\\Desktop\\eyeshadow_upper(5)";
//        File file = new File(templateListFolder);
//        //generateFileMd5(file);
//
//        getFiles(file, "ini");
//        System.out.println(getFileSuffix(new File("C:\\Users\\ryz2593\\Desktop\\eyeshadow_upper(5)\\web_aa001_upper.ini")));
//        System.out.println(ReadFile("C:\\Users\\ryz2593\\Desktop\\eyeshadow_upper(5)\\web_aa001_upper.ini"));


        //20191211
        List<String> objectiveList = Lists.newArrayList();
        String baseLocalPath = "E:\\aaa\\";
        String tmpPath = baseLocalPath + "tmp" + File.separator;
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String pathWithDate = tmpPath + df.format(new Date()) + File.separator;
        File dirFile = new File(FilenameUtils.getFullPath(pathWithDate));
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        int index = 1;
        for (String s : FileConstant.containList) {
            System.out.println("processing " + index++ + " file, file name = " + s);
            String fileName = FilenameUtils.getName(s);
            String fileNameWithoutSuffix = fileName.substring(0, fileName.lastIndexOf("."));
            String filePath = pathWithDate + fileName;
            downloadToFile(s, filePath);
            File fa = new File(filePath);
            String mbaUnzipFile = pathWithDate + "unzipFile/" + fileNameWithoutSuffix + File.separator;
            dirFile = new File(FilenameUtils.getFullPath(mbaUnzipFile));
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            unZipFiles(fa, mbaUnzipFile);
            List<File> ll = getFiles(new File(mbaUnzipFile), "mba");
            if (CollectionUtils.isNotEmpty(ll)) {
                String absolutePath = ll.get(0).getAbsolutePath();
                if (readFile(absolutePath)) {
                    objectiveList.add(s);
                }
            }
        }

        System.out.println("====================================================================");
        System.out.println("共有" + objectiveList.size() + "个包含Contour");
        System.out.println("====================================================================");
        for (String s : objectiveList) {
            System.out.println(s);
        }
        System.out.println("====================================================================");
        //20191211

    }

    static class FileConstant {
        public static final List<String> containList = com.google.common.collect.Lists.newArrayList("http://aasdf.zip");
    }
}
