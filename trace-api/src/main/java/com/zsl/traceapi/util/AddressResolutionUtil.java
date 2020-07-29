package com.zsl.traceapi.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressResolutionUtil {

    /**
     * 解析地址
     * @author lin
     * @param address
     * @return
     */
    public static String addressResolution(String address){
        String regex="(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        Matcher m=Pattern.compile(regex).matcher(address);
        while(m.find()){
             return  m.group("city");
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(addressResolution("中国广东省广州市天河区天源广场166"));
    }

}