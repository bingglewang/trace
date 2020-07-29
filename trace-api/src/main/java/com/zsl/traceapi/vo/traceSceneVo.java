package com.zsl.traceapi.vo;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * @remark 追溯生产场景信息视图返回
 * @author CH W
 * @date 2020年7月18日 下午2:57:19
 * @version 1.0
 */
@Data
public class traceSceneVo {
	
	/** 场景操作时间范围 */
    private String sceneTimeScope;
    /** 员工名称 */
    private String employeName;
    /** 场景名称 */
    private String sceneName;
    /** 场景描述 */
    private String description;
    /** 场景图片列表 */
    private List<String> sceneImageList;
    /** 场景的出库原材料列表 */
    private List<Map<String, Object>> materialList;
    
}
