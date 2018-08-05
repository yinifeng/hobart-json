package com.hubo.json.common.util;

import java.net.URL;
import java.net.URLDecoder;

public class ClassLoaderUtils {
    
    private static ClassLoader loader=Thread.currentThread().getContextClassLoader();
    
    private static String classPath="";
    
    static {
        
        if(loader == null){
            System.out.println("Using system class loader");
            loader = ClassLoader.getSystemClassLoader();
        }

        try {
            URL url = loader.getResource("");
            //获取类路劲
            if(url != null){
                classPath = url.getPath();
                classPath = URLDecoder.decode(classPath,"utf-8");
            }
            
            //如果是jar包内的，则返回当前路劲
            if(classPath == null || classPath.length() == 0 || classPath.contains(".jar!")){
                classPath = System.getProperty("user.dir");
            }
            
        } catch (Throwable ex) {
            classPath = System.getProperty("user.dir");
            //ex.printStackTrace();
        }

    }

    public static ClassLoader getLoader() {
        return loader;
    }

    public static String getClassPath() {
        return classPath;
    }
}
