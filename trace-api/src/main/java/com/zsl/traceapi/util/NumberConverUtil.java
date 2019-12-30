package com.zsl.traceapi.util;

import com.zsl.tracedb.model.ZslTracePoint;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName NumberConverUtil
 * @Description 数字转换合并
 * @Author binggleW
 * @Date 2019-12-24 16:08
 * @Version 1.0
 **/
public class NumberConverUtil {
    public static void main(String[] args) {
      /*  Set<Integer> points = new HashSet<>();
        points.add(4);
        points.add(1);
        points.add(2);
        points.add(3);
        points.add(10);
        points.add(7);
        points.add(6);
        List<String> list = getConvertNum(points);*/

        List<ZslTracePoint> list = new ArrayList<>();
        ZslTracePoint item = new ZslTracePoint();
        item.setTracePointName("张三");
        item.setTraceParentId(1);
        list.add(item);
        ZslTracePoint item1 = new ZslTracePoint();
        item1.setTracePointName("里斯");
        item1.setTraceParentId(2);
        list.add(item1);
        ZslTracePoint item2 = new ZslTracePoint();
        item2.setTracePointName("里斯33");
        item2.setTraceParentId(2);
        list.add(item2);
        Map<Integer, List<ZslTracePoint>> map = groupBillingDataByExcpBatchCode(list);
        for(Integer key:map.keySet()){
            System.out.println("key="+key+"and value=" +map.get(key));
        }
    }

    public static List<String> getConvertNum(Set<Integer> zslPoints){
        Set newSet = zslPoints.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toSet());
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.addAll(newSet);

        Integer[] NoNum = new Integer[treeSet.size()];
        treeSet.toArray(NoNum);

        String result = convert(NoNum, 0);
        result = result.substring(0, result.length() - 1);
        List<String> list = Arrays.stream(result.split(",")).collect(Collectors.toList());
        return list;
    }

    /**
     * 按照异常批次号对已开单数据进行分组
     * @param billingList
     * @return
     * @throws Exception
     */
    public static Map<Integer, List<ZslTracePoint>> groupBillingDataByExcpBatchCode(List<ZslTracePoint> billingList){
        Map<Integer, List<ZslTracePoint>> resultMap = new HashMap<Integer, List<ZslTracePoint>>();
        try{
            for(ZslTracePoint tmExcpNew : billingList){

                if(resultMap.containsKey(tmExcpNew.getTraceParentId())){//map中异常批次已存在，将该数据存放到同一个key（key存放的是异常批次）的map中
                    resultMap.get(tmExcpNew.getTraceParentId()).add(tmExcpNew);
                }else{//map中不存在，新建key，用来存放数据
                    List<ZslTracePoint> tmpList = new ArrayList<ZslTracePoint>();
                    tmpList.add(tmExcpNew);
                    resultMap.put(tmExcpNew.getTraceParentId(), tmpList);

                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultMap;
    }



    public static String convert(Integer[] ints, int index) {
        int end = index;
        if (ints.length == index) {//结束条件，遍历完数组
            return "";

        } else {
            for (int i = index; i < ints.length; i++) {
                if (i < ints.length - 1) {
                    if (ints[i] + 1 == ints[i + 1]) {
                        end = i;
                    } else {
                        if (i > index)
                            end = end + 1;
                        break;
                    }
                } else {
                    if (end == ints.length - 2) {
                        end = ints.length - 1;
                        break;
                    }
                }
            }
            if (index == end)//相等说明不连续
                return ints[index] + "-" + ints[index] + "," + convert(ints, end + 1);
            else//连续
                return ints[index] + "-" + ints[end] + "," + convert(ints, end + 1);

        }
    }
}
