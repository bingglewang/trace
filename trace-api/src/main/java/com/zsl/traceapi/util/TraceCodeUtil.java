package com.zsl.traceapi.util;

import java.util.ArrayList;
import java.util.List;

public class TraceCodeUtil {
    public static List<String> generateTraceCode(Long count){
        List<String> result = new ArrayList<>();
        for(int i = 0;i<count;i++){
            result.add(generateCode());
        }
        return result;
    }

    public static String generateCode(){
        return "ahahahahaahaahahah";
    }
}
