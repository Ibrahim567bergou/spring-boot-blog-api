package com.blog.blogrbac_system.utils;

public class FileUtil {

    public static String getFileExtension(String fileName){
        int lastIndex = fileName.lastIndexOf(".");
        if(lastIndex != -1 && lastIndex < fileName.length()-1){
            return fileName.substring(lastIndex + 1).toLowerCase();
        }else{
            return "";
        }
    }
}
