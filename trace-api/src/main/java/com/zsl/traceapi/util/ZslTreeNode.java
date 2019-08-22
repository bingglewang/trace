package com.zsl.traceapi.util;

import com.zsl.tracedb.model.ZslTraceSubcode;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ZslTreeNode extends ZslTraceSubcode {
    protected List<TreeNode> children = new ArrayList<TreeNode>();
    private String name;
}
