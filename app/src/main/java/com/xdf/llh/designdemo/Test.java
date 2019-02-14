package com.xdf.llh.designdemo;

import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * author: 李刘欢
 * date：2019/2/14 18:07
 * version:1.0.0
 * description: Test
 */
public class Test {
    public static String check(String inputStr) {
        if (TextUtils.isEmpty(inputStr)) return null;
        if (inputStr.contains(",")) {
            String[] split = inputStr.split(",");
            List<String> list = Arrays.asList(split);
            Map<String, List<String>> treeMap = new TreeMap<>();
            for (String value : list) {
                String subKey = value.substring(0, 1);
                List<String> stringsValues = treeMap.get(subKey);
                if (stringsValues == null || stringsValues.isEmpty()) {
                    stringsValues = new ArrayList<>();
                }
                stringsValues.add(value);
                treeMap.put(subKey, stringsValues);
            }
            if (treeMap!=null && !treeMap.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                Set<Map.Entry<String, List<String>>> entries = treeMap.entrySet();
                for (Map.Entry<String, List<String>> entry : entries) {
                    String key = entry.getKey();
                    List<String> values = entry.getValue();
                    stringBuilder.append(key).append("-->").append("{");
                    for (int i = 0; i <values.size() ; i++) {
                        if (i == values.size()-1){
                            stringBuilder.append(values.get(i));
                        }else {
                            stringBuilder.append(values.get(i)).append(",");
                        }
                    }
                    stringBuilder.append("}").append("\n");
                }
                return stringBuilder.toString();
            }
        }
        return null;
    }
}
