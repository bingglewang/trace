package com.zsl.traceapi.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName ProductionLinkParam
 * @Description 生产环节包装类
 * @Author binggleW
 * @Date 2019-10-09 14:59
 * @Version 1.0
 **/
@Data
public class ProductionLinkParam {
    /**
     * 环节名称
     */
    private String productionName;

    /**
     * 环节日期
     */
    private Long productionTime;

    /**
     * 负责人
     */
    private String productionMan;

    /**
     * 环节描述
     */
    private String productionDescripe;

    /**
     * 环节图片列表
     */
    private List<String> productionPicList;
}
