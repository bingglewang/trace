package com.zsl.traceapi.util;

import com.zsl.tracedb.model.ZslTracePoint;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeNode extends ZslTracePoint {
    protected List<TreeNode> children = new ArrayList<TreeNode>();
}
