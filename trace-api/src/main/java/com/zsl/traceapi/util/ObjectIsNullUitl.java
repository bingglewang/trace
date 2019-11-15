package com.zsl.traceapi.util;

import com.zsl.traceapi.dto.ProductionLinkParam;
import com.zsl.traceapi.dto.TraceRecordInsertParam;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ObjectIsNullUitl
 * @Description 判断对象各个属性是否为空
 * @Author binggleW
 * @Date 2019-11-15 17:14
 * @Version 1.0
 **/
public class ObjectIsNullUitl {
    public static boolean checkFieldAllNull(Object object) throws IllegalAccessException {
        for (Field f : object.getClass().getDeclaredFields()) {
            System.out.println("name:" + f.getName());
            f.setAccessible(true);
            if (Modifier.isFinal(f.getModifiers()) && Modifier.isStatic(f.getModifiers())) {
                continue;
            }
            if (!isEmpty(f.get(object))) {
                return false;
            }
            f.setAccessible(false);
        }
        //父类public属性
        for (Field f : object.getClass().getFields()) {
            System.out.println("name:" + f.getName());
            f.setAccessible(true);
            if (Modifier.isFinal(f.getModifiers()) && Modifier.isStatic(f.getModifiers())) {
                continue;
            }
            if (!isEmpty(f.get(object))) {
                return false;
            }
            f.setAccessible(false);
        }
        return true;
    }

    private static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof String && (object.toString().equals(""))) {
            return true;
        }
        if (object instanceof Collection && ((Collection) object).isEmpty()) {
            return true;
        }
        if (object instanceof Map && ((Map) object).isEmpty()) {
            return true;
        }
        if (object instanceof Object[] && ((Object[]) object).length == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ProductionLinkParam model = new ProductionLinkParam();
        model.setProductionName("");
        model.setProductionMan("");
        model.setProductionDescripe("");
        model.setProductionPicList(new ArrayList<>());
        boolean ret = false;
        try {
            ret = ObjectIsNullUitl.checkFieldAllNull(model);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("ret:" + ret);
    }

}
