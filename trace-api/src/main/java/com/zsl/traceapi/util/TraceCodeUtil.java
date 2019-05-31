package com.zsl.traceapi.util;

import java.util.ArrayList;
import java.util.List;

public class TraceCodeUtil {
    // 追溯码编号：【时间戳（到毫秒）+3位随机数+本次申请数量+序号】*37
    public static List<String> generateTraceCode(Long count){
        List<String> result = new ArrayList<>();
        for(int i = 0;i<count;i++){
            Long time = System.currentTimeMillis()*1000;
            Long random = Long.parseLong(RandomUtil.getRandNumberCode(3));
            result.add(((time+random+count+i+1)*37)+"");
        }
        return result;
    }
}
