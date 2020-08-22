package com.zsl.traceapi.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SceneForEditBatchVo {
	
	/** 场景批次中间表主键 */
    private Integer sceneBatchId;
    /** 场景时间范围 */
    private String sceneTimeScope;
    /** 员工id */
    private Integer employeId;
    /** 员工名称 */
    private String employeName;
    /** 场景id */
    private Integer sceneId;
    /** 场景名称 */
    private String name;
    /** 场景排序 */
    private Integer sceneSort;
    /** 场景视频 */
    private String videoUrl;
    /** 场景说明 */
    private String description;
    /** 场景图片列表 */
    private List<Map<String, Object>> sceneImages;
    /** 场景的原材料出库信息列表 */
    private List<Map<String, Object>> materialOutStorages;

}