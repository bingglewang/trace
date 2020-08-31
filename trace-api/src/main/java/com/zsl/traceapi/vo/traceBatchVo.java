package com.zsl.traceapi.vo;

import lombok.Data;

import java.util.List;

/**
 * @remark 追溯批次信息视图返回
 * @author CH W
 * @date 2020年7月18日 下午2:55:40
 * @version 1.0
 */
@Data
public class traceBatchVo {
	
	/** 生产批次号 */
    private String batchNo;
    /** 员工数 */
    private Integer employeCount;
    /** 场景数 */
    private Integer sceneCount;
    //	天猫销售渠道地址
    private String tmall;
    //	京东销售渠道地址
    private String jd;
    //	淘宝销售渠道地址
    private String taobao;
    /** 追溯场景信息列表	 */
    private List<traceSceneVo> tsvList;

}