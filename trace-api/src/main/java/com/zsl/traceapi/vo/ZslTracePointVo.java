package com.zsl.traceapi.vo;

import com.zsl.tracedb.model.ZslTracePoint;
import lombok.Data;

@Data
public class ZslTracePointVo extends ZslTracePoint {
    private String goodsName;
}
