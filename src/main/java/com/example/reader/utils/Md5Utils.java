package com.example.reader.utils;


import org.apache.commons.codec.digest.DigestUtils;

public class Md5Utils {
    public static String md5Digest(String source,Integer salt){
        char[] ca = source.toCharArray();
        for (char c : ca) {
            c = (char) (c+salt);
        }
        String target = new String(ca);
        return DigestUtils.md5Hex(target);
    }
}
