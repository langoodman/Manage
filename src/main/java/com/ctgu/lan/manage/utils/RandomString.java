package com.ctgu.lan.manage.utils;

import java.util.Random;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-05-27 20:36
 * @ClassName RandomString
 * @Version 1.0.0
 */
public class RandomString {
    /**
     * 获取随机字符串
     * @param length
     * @return
     */
    public static String randStr(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for( int i = 0 ; i < length ; i++ ){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
