package org.lyzd.testlink.common;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author shuchao
 * @create 2020 06 09 13:34
 * @description
 */

@Component
public class TestlinkUtils {

    private static TestLinkConfig config;

    public static TestLinkConfig getConfig() {
        return config;
    }

    @Autowired(required = true)
    public void setConfig(TestLinkConfig config) {
        TestlinkUtils.config = config;
    }

    public static String getTestLinkURL() {
        return config.getApiUrl();
    }

    public static String getTestLinkApiKey() {
        return config.getApiKey();
    }

    public static TestLinkAPI connect() {
        String url = getTestLinkURL();
        String devKey = getTestLinkApiKey();
        TestLinkAPI api = null;
        try {
            api = new TestLinkAPI(new URL(url), devKey);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        System.out.println(api.about());

        return api;
    }

    public static boolean check(TestLinkAPI api){
        try {
            api.ping();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
