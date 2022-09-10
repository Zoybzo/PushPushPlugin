package com.zoybzo.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtil {
    /**
     * Object 转换为 json 文件
     *
     * @param finalPath finalPath 是绝对路径 + 文件名，请确保欲生成的文件所在目录已创建好
     * @param object    需要被转换的 Object
     */
    public static void object2JsonFile(String finalPath, Object object) {
        String jsonString = JSON.toJSONString(object);
        try {
            OutputStreamWriter osw = new OutputStreamWriter(Files.newOutputStream(Paths.get(finalPath)), StandardCharsets.UTF_8);
            osw.write(jsonString);
            osw.flush();
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jsonString);
    }

    /**
     * json 文件转换为 Object
     *
     * @param finalPath   finalPath 是绝对路径 + 文件名，请确保欲生成的文件所在目录已创建好
     * @param targetClass 需要被转换的 json 对应的目标类
     * @param <T>         需要被转换的 json 对应的目标类
     * @return 解析后的 Object
     */
    public static <T> T jsonFile2Object(String finalPath, Class<T> targetClass) {
        String jsonString;
        File file = new File(finalPath);
        try {
            FileInputStream inputStream = new FileInputStream(file);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            jsonString = new String(buffer, StandardCharsets.UTF_8);
            T object = JSON.parseObject(jsonString, targetClass);
            return object;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("IO exception");
        }
    }
}
