package com.zsl.traceapi.util;

import java.util.ArrayList;
import java.util.List;

public class TraceCodeUtil {
    // 追溯码编号：【3位随机数+时间戳（到毫秒+本次申请数量+序号】*37
    // 追溯码编号：【4位随机数+时间戳（到毫秒+本次申请数量+序号】
   /* public static List<String> generateTraceCode(Long count){
        List<String> result = new ArrayList<>();
        for(int i = 0;i<count;i++){
            Long time = System.currentTimeMillis()*1000;
            Long random = Long.parseLong(RandomUtil.getRandNumberCode(3));
            result.add(((time+random+count+i+1)*37)+"");
        }
        return result;
    }*/

    public static List<String> generateTraceCode(Long count){
        List<String> result = new ArrayList<>();
        for(int i = 0;i<count;i++){
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(RandomUtil.getRandNumberCode(4));
            stringBuffer.append(System.currentTimeMillis()*1000);
            stringBuffer.append(i+1);
            result.add(stringBuffer.toString());
        }
        return result;
    }

    //判断起始编码，和结束编码,(起始编码必须小于结束编码，)
}
