package com.zsl.traceapi.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName ProductionLinkVo
 * @Description 生产环节包装类
 * @Author binggleW
 * @Date 2019-10-09 16:19
 * @Version 1.0
 **/
@Data
public class ProductionLinkVo {
    /**
     * 环节名称
     */
    private String productionName;

    /**
     * 环节日期
     */
    private String productionTime;

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
