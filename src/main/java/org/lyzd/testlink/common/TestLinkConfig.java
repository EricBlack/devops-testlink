package org.lyzd.testlink.common;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.*;

/**
 * @author shuchao
 * @create 2020 06 09 13:56
 * @description
 */
public class TestLinkConfig {
    private String apiUrl;
    private String apiKey;

    public String getApiUrl() {
        return apiUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    @SuppressWarnings("rawtypes")
    public TestLinkConfig() {
        try{
            String path = System.getProperty("user.dir") + "/src/main/resources/testlink.yaml";
            File yamlFile = new File(path);
            Yaml yaml = new Yaml();
            HashMap map = yaml.loadAs(new FileInputStream(yamlFile), HashMap.class);
            HashMap prop = (HashMap) map.get("testlink");
            apiUrl = prop.get("api-url").toString();
            apiKey = prop.get("api-key").toString();
        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("配置文件找不到");
        }
    }

    public static void main(String[] args) {
        TestLinkConfig config = new TestLinkConfig();
    }
}


