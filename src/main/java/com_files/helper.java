package com_files;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class helper {

    public static String json_data_filter(Response response, String key){
        String resp=response.asString();
        JsonPath   js = new JsonPath(resp);
        return js.get(key).toString();
    }

    public static String  getGlobal(String s) throws IOException {
        Properties prop= new Properties();
        FileInputStream fis=new FileInputStream("src/test/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(s);
    }

}
