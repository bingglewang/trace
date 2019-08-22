package com.zsl.traceapi.vo;

import com.zsl.traceapi.util.ZslTreeNode;
import com.zsl.tracedb.model.ZslTraceSubcode;
import lombok.Data;

import java.util.List;

@Data
public class ZslTraceSubcodeVo extends ZslTraceSubcode {
    private Integer count;
    private Integer isEnable;
    private List<ZslTreeNode> treeNodeCodes;
}
