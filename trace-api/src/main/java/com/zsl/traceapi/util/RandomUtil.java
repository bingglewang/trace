package com.zsl.traceapi.util;

import java.util.Random;

public class RandomUtil {
    /**
     * 生成指定长度的数字随机数
     * @param length 长度
     * @return String
     */
    public static  String getRandNumberCode (int length)    {
        Random random = new Random();
        String result="";
        for(int i=0;i<length;i++){
            result+=random.nextInt(10);
        }
        return result;
    }
}
