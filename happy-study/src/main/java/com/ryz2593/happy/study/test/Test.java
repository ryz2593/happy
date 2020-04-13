package com.ryz2593.happy.study.test;

import com.ryz2593.happy.util.JsonUtil;
import java.util.LinkedHashMap;

/**
 * 自定义对象来接收string字符串，
 * 即使用JsonUtil工具类将string字符串转换成自定义的对象
 *
 * @author ryz2593
 * @date 2020/4/9 16:25
 */
public class Test {
    public static void main(String[] args) {
        String iwindowVersion = "{\n" +
                "    \"code\":0,\n" +
                "    \"msg\":\"success\",\n" +
                "    \"data\":{\n" +
                "        \"configVersion\":\"IHV2020031102\",\n" +
                "        \"iWindowVersion\":{\n" +
                "            \"1\":\"1570850626\",\n" +
                "            \"2\":\"1570850626\",\n" +
                "            \"3\":\"1570850626\",\n" +
                "            \"4\":\"1570850626\",\n" +
                "            \"-88\":\"3.2.3\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        Response response = JsonUtil.toObject(iwindowVersion, Response.class);
        LinkedHashMap linkedHashMap = response.getData().getiWindowVersion();
        System.out.println(linkedHashMap);


    }

    /**
     * 要定义为static类型
     */
    static class DataBean {
        private String configVersion;
        private LinkedHashMap iWindowVersion;


        public String getConfigVersion() {
            return configVersion;
        }

        public void setConfigVersion(String configVersion) {
            this.configVersion = configVersion;
        }

        public LinkedHashMap getiWindowVersion() {
            return iWindowVersion;
        }

        public void setiWindowVersion(LinkedHashMap iWindowVersion) {
            this.iWindowVersion = iWindowVersion;
        }
    }

    /**
     * 因为是main()中调用， main()方法是static类型的，所以Response也要定义为static类型
     */
    static class Response {
        private int code;
        private String msg;
        private DataBean data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }
    }


}
