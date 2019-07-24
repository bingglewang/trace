package com.zsl.traceapi.vo;

import com.zsl.traceapi.util.TreeNode;
import lombok.Data;

import java.util.List;

@Data
public class TracePointTreeVo {
    private String goodsName;
    private List<TreeNode> treeNodes;
}
