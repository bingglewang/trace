package com.zsl.traceapi.util;



import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ListGroupUtil
 * @Description 将list集合分成平均的n份
 * @Author binggleW
 * @Date 2019-10-23 16:37
 * @Version 1.0
 **/
public class ListGroupUtil {
    /**
     * 将一个list均分成n个list,主要通过偏移量来实现的
     * @param source
     * @return
     */
    public static <T> List<List<T>> averageAssign(List<T> source,int n){
        List<List<T>> result=new ArrayList<List<T>>();
        int remaider=source.size()%n; //(先计算出余数)
        int number=source.size()/n; //然后是商
        int offset=0;//偏移量
        for(int i=0;i<n;i++){
            List<T> value=null;
            if(remaider>0){
                value=source.subList(i*number+offset, (i+1)*number+offset+1);
                remaider--;
                offset++;
            }else{
                value=source.subList(i*number+offset, (i+1)*number+offset);
            }
            result.add(value);
        }
        return result;
    }


    public static void main(String[] args) {
        List<String> mStrings=new ArrayList<>();
        for (int i = 0; i < 501; i++) {
            mStrings.add(String.valueOf(i));
        }
        int size = mStrings.size();
        int groupCount = 500;
        int n = size % groupCount == 0 ? (size / groupCount) : (size / groupCount + 1);
        List<List<String>> result = averageAssign(mStrings,n);
        for(List<String> item : result){
            for(String sss : item){
                System.out.print(sss+",");
            }
            System.out.println();
        }
    }
}
