package org.lyzd.testlink.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;
import sun.misc.URLClassPath;

import java.io.*;
import java.util.*;

/**
 * @author shuchao
 * @create 2020 06 09 13:56
 * @description
 */
@Component
@ConfigurationProperties(prefix = "testlink")
public class TestLinkConfig {

    private String apiUrl;
    private String apiKey;

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @SuppressWarnings("rawtypes")
    public TestLinkConfig() {
        /*
        try{
            //String path = System.getProperty("user.dir") + "/src/main/resources/testlink.yaml";
            //String path = this.getClass().getResource("/").getPath() + "testlink.yaml";
            String path = TestLinkConfig.class.getResource(".." + File.separator +".." + "testlink.yaml").getPath();
            File yamlFile = new File(path);
            Yaml yaml = new Yaml();
            HashMap map = yaml.loadAs(new FileInputStream(yamlFile), HashMap.class);
            HashMap prop = (HashMap) map.get("testlink");
            apiUrl = prop.get("apiUrl").toString();
            apiKey = prop.get("apiKey").toString();
        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("配置文件找不到");
        }
        */
    }
}


