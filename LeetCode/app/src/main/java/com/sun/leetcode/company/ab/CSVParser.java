package com.sun.leetcode.company.ab;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.*;

/**
 * Author: jfson sun
 * Create on:  2019/1/3
 * Question:
 * Description:
 * Train of thought:
 */
public class CSVParser {
    /*
    CSV Parser
    AirBnB Interview Question
    http://creativyst.com/Doc/Articles/CSV/CSV01.htm#EmbedBRs
    csv parser
    如果有逗号，转化成|
    如果有引号，把不考虑引号里逗号，把引号里的内容去引号整体打印。 '\"'
    如果有两重引号，只去掉一重引号。
     */

    public ArrayList<String> parseCSV2(String str) {
        ArrayList<String> res = new ArrayList<String>();
        boolean inQuote = false;
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (inQuote) {
                if (str.charAt(i) == '"') {
                    if (i == str.length() - 1) {
                        res.add(buffer.toString());
                        return res;
                    } else if (str.charAt(i + 1) == '"') {
                        buffer.append('"');
                        i++;
                    } else {
                        res.add(buffer.toString());
                        buffer.setLength(0);
                        inQuote = false;
                        i++;
                    }
                } else buffer.append(str.charAt(i));
            } else {
                if (str.charAt(i) == '"') {
                    inQuote = true;
                } else if (str.charAt(i) == ',') {
                    res.add(buffer.toString());
                    buffer.setLength(0);
                } else {
                    buffer.append(str.charAt(i));
                }
            }
        }
        if (buffer.length() > 0) res.add(buffer.toString());
        return res;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String parseCSV(String str) {
        List<String> res = new ArrayList<>();
        boolean inQuote = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (inQuote) {
                if (str.charAt(i) == '\"') {
                    if (i < str.length() - 1 && str.charAt(i + 1) == '\"') {
                        sb.append("\"");
                        i++;
                    } else {
                        inQuote = false;
                    }
                } else {
                    sb.append(str.charAt(i));
                }
            } else {
                if (str.charAt(i) == '\"') {
                    inQuote = true;
                } else if (str.charAt(i) == ',') {
                    res.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(str.charAt(i));
                }
            }
        }
        if (sb.length() > 0) {
            res.add(sb.toString());
        }
        return String.join("|", res);
    }
}
