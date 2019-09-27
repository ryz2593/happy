package com.ryz2593.happy;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ryz2593.happy.util.FileUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.util.*;

import static com.ryz2593.happy.HtmlParser.readHtml;

/**
 * @author ryz2593
 */
public class GetFileName {

    static final List<String> excludeFolder = Arrays.asList("images","js","resource","FAQ","CacheData","config","script","inappmessage");
    static final List<String> excludeExt = Arrays.asList("jpg", "png", "js", "css","JPG","db","json","zip","xlsx");
    static final List<String> excludeContains = Arrays.asList("index_");
    static final List<String> excludeSuffix = Arrays.asList("_cs", "_ct", "_de", "_en", "_es", "_fr", "_id", "_it", "_jp", "_kr", "_pt", "_ru", "_tw");
    static final String existStaticJsonFilePath = "D:\\IdeaProjects\\private_source\\happy\\happy-common\\src\\main\\resources\\staticIwindowList.json";
    static final Map<String, String> map = new HashMap();

    static {
        File file = new File(existStaticJsonFilePath);
        String JsonContext = FileUtil.ReadFile(file.toString());
        JsonArray jsonArray = new JsonParser().parse(JsonContext).getAsJsonArray();
        Set set = new HashSet();
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject staticIwindowPathInfo = jsonArray.get(i).getAsJsonObject();
            set.add(staticIwindowPathInfo.get("hotstyleNumber").getAsString());
        }

        for (Object o : set) {
            map.put(o.toString(), "1");
        }
    }

    public static String[] getFileName(String path) {
        File file = new File(path);
        String[] fileName = file.list();
        return fileName;
    }

    public static boolean contains(String name) {
        String result = map.get(name);
        if (result != null) {
            return true;
        }
        return false;
    }

    static String getNameFilterExcludeSuffix(String name) {
        for (String suffix : excludeSuffix) {
            if (name.endsWith(suffix)) {
                return name.replace(suffix, "");
            }
        }
        return name;
    }

    static boolean isExcludeFolder(String name) {
        return excludeFolder.contains(name);
    }

    static boolean isExcludeExtFile(String name) {
        return excludeExt.contains(name);
    }

    static boolean isExcludePrefixFile(String name) {
        for (String s : excludeContains) {
            if (name.contains(s)) {
                return true;
            }
        }
        return false;
    }

    private static void testFileDirOrName(String path, String floderName) throws Exception {
        File dirFile = new File(path);
        File[] files = dirFile.listFiles();
        if (files == null) {
            throw new Exception("folder is empty");
        }
        Set<IwindowInfo> set = new HashSet();
        String folderName = floderName;
        for (File fileChildDir : files) {

            if (fileChildDir.isDirectory()) {
                if (isExcludeFolder(fileChildDir.getName())) {
                    continue;
                }
                //输出文件夹名
                if (!fileChildDir.getName().equals("hotstylehtml")) {
//                    System.out.print("此为目录名: ");
//                    System.out.println(fileChildDir.getName());
                    folderName = fileChildDir.getName();
                }
                //通过递归的方式,把目录中的所有文件全部遍历出来
                testFileDirOrName(fileChildDir.getAbsolutePath(), folderName);
            }

            outer:
            if (fileChildDir.isFile()) {
                Integer pointPos = fileChildDir.getName().lastIndexOf(".");
                if (pointPos <0) {
                    System.out.println("pointPos = " + pointPos);
                }
                String fileName = fileChildDir.getName().substring(0, pointPos);
                String ext = fileChildDir.getName().substring(pointPos +1, fileChildDir.getName().length());
//                String fileName = fileChildDir.getName().split("\\.")[0];
//                String ext = fileChildDir.getName().split("\\.")[1];
//                if (fileChildDir.getName().contains("jquery-1.7.2.min")) {
//                    System.out.println("fileChildDir = " + fileChildDir.getName());
//                }
                if (isExcludePrefixFile(fileName)) {
                    continue;
                }
                if (isExcludeExtFile(ext)) {
                    continue;
                }

                String name = getNameFilterExcludeSuffix(fileName);

                if (contains(name)) {
                    continue;
                }


                IwindowInfo iwindowInfo = new IwindowInfo();
//                iwindowInfo.setStyleName(folderName);
                iwindowInfo.setStyleNo(name);
                iwindowInfo.setStylePath(fileChildDir.getAbsolutePath().replace("_cs", "_en"));
                inner:
                for (IwindowInfo info : set) {
                    if (info.getStyleNo().equals(name)) {
                        break outer;
                    }
                }
                String title = HtmlParser.getTitle(fileChildDir.getAbsolutePath().replace("_cs", "_en"));
                if (title == null) {
                    iwindowInfo.setStyleName(floderName);
                } else {
                    iwindowInfo.setStyleName(title);
                }
                set.add(iwindowInfo);
                //输出文件名
//                System.out.print("此为文件名 :  ");
                System.out.println(iwindowInfo.toString());

            }
        }
    }

    public static void getAllFileName(String path, ArrayList<String> fileName) {
        File file = new File(path);
        File[] files = file.listFiles();
        String[] names = file.list();
        if (names != null) {
            fileName.addAll(Arrays.asList(names));
        }
        for (File a : files) {
            if (a.isDirectory()) {
                getAllFileName(a.getAbsolutePath(), fileName);
            }
        }
    }

    public static void main(String[] args) throws Exception {
//        String[] fileName = getFileName("H:\\新建文件夹\\Spring_2018");
//        for (String name : fileName) {
//            System.out.println(name);
//        }
//        System.out.println("--------------------------------");
//        ArrayList<String> listFileName = new ArrayList<String>();
//        getAllFileName("D:\\IdeaProjects\\private_source\\happy\\happy-common\\src\\main\\resources\\Spring_2018", listFileName);
//        for (String name : listFileName) {
//            System.out.println(name);
//        }

        testFileDirOrName("H:\\iwindowPages", null);

    }
}
