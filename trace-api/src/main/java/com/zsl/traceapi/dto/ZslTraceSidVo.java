package com.zsl.traceapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName ZslTraceSidVo
 * @Description TODO
 * @Author binggleW
 * @Date 2020-07-21 14:56
 * @Version 1.0
 **/

@Data
public class ZslTraceSidVo {
    private Long id;

    private Long sidStartIndex;

    private Long sidEndIndex;

    private Integer sidPreCreate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Long enableCount;

    private String accountName;

    private String uniqueCode;
}
