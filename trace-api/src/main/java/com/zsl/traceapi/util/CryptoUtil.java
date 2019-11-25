package com.zsl.traceapi.util;

/**
 * @ClassName CryptoUtil
 * @Description TODO
 * @Author binggleW
 * @Date 2019-11-25 14:47
 * @Version 1.0
 **/

import java.security.MessageDigest;



public class CryptoUtil {
    private CryptoUtil() {
    }

    public static String getSHA256(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (Exception e) {
            System.out.println("getSHA256 is error" + e.getMessage());
        }
        return encodeStr;
    }

    private static String byte2Hex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        String temp;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                builder.append("0");
            }
            builder.append(temp);
        }
        return builder.toString();
    }

    /**
     * 计算hash服务
     * @param sid
     * @param + 固定字符串
     * @param data 数据
     * @return 当前hash
     */
    public static   String calculateHash(Long sid,String data) {
        StringBuilder builder = new StringBuilder();
        builder.append(sid).append("+").append(data);
        String hashcode = CryptoUtil.getSHA256(builder.toString());
        return hashcode;
    }

    public static void main(String[] args) {
        Long sid = 16000001L;
        String traceCode = "zs1571638695617000575411014";
        String hashcode = calculateHash(sid,traceCode);
        System.out.println("哈希值："+hashcode+"长度："+hashcode.length());
    }
}