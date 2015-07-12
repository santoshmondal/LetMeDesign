package com.affixus.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Properties;


/**
 * Created by santoshm on 12/7/15.
 */
public class FileHelper {
    public static String getFilePathToSave() {

        Properties prop = new Properties();
        String filePath = "";

        try {

            InputStream inputStream =
                    FileHelper.class.getClassLoader().getResourceAsStream("config.properties");


            prop.load(inputStream);
            filePath = prop.getProperty("json.filepath");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;

    }

    public static void main(String args[]) {
        System.out.println(FileHelper.getFilePathToSave());
    }
}
