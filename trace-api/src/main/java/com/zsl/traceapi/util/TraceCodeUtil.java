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

    public static String generateBlock(String traceCode,Long totalCount){
        String result = "";
        String suffix = traceCode.substring(traceCode.length()-6);
        Long suffixLong = Long.parseLong(suffix);
        Long blockLong = totalCount + suffixLong;
        String blockLongStr = String.format("%06d", blockLong);
        System.out.println("字符串:"+blockLongStr);
        if(((blockLongStr.charAt(blockLongStr.length()-5) - '0') == 0)){
            if(((blockLongStr.charAt(blockLongStr.length()-6) - '0') == 0)){
                result = "1"+ blockLongStr.substring(blockLongStr.length()-5);
            }else{
                result = blockLongStr.substring(blockLongStr.length()-6);
            }
        }else{
            result = blockLongStr.substring(blockLongStr.length()-5);
        }
        return result;
    }

    //判断起始编码，和结束编码,(起始编码必须小于结束编码，)

    public static void main(String[] args) {
        String traceCode = "zs1572491288681000576007495";
        Long totalCount = 40L;
        String block = generateBlock(traceCode,totalCount);
        System.out.println("区块："+block);
    }
}
