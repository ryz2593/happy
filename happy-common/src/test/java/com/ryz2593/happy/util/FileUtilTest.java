package com.ryz2593.happy.util;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtilTest {

    @Test
    public void printFile() {
        String filePath = "E:\\compain_email.txt";
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            String str;
            while ((str = in.readLine()) != null) {
                String email = str.substring(str.indexOf('<') + 1, str.indexOf('>'));
                System.out.println(email);
                sb.append("'").append(email).append("',");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
        }
    }
}
