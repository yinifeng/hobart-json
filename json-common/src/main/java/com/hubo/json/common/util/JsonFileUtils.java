package com.hubo.json.common.util;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;

public class JsonFileUtils {
    private static final String[] DEFAULT_FILE_SEARCH_LOCATIONS = new String[]{"./config/", "./"};

    public static String readJsonFile(String filePath) {
        StringBuilder json=new StringBuilder();
        BufferedReader reader=null;
        try {
            reader = new BufferedReader(new InputStreamReader(loadJsonFileToInputStream(filePath)));
            char [] buffer=new char[1024];
            int len = 0;
            while ((len = reader.read(buffer)) > 0){
                json.append(new String(buffer,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    private static InputStream loadJsonFileToInputStream(String filePath) {
        try {
            for(String searchLocation : DEFAULT_FILE_SEARCH_LOCATIONS){
                File candidate = Paths.get(searchLocation, filePath).toFile();
                if(candidate.exists() && candidate.isFile() && candidate.canRead()){
                    System.out.println("Reading JsonFile from resource "+candidate.getAbsolutePath());
                    return new FileInputStream(candidate);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            URL url = ClassLoaderUtils.getLoader().getResource(filePath);
            if(url != null){
                InputStream is = url.openStream();
                if(is != null){
                    System.out.println("Reading json file from "+url.getPath());
                    return is;
                }
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }

        File candidate=new File(System.getProperty("user.dir"),filePath);
        try {
            if(candidate.exists() && candidate.isFile() && candidate.canRead()){
                return new FileInputStream(candidate);
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
        return null;
    }
}
