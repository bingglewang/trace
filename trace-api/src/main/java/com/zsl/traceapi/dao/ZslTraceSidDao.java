package com.zsl.traceapi.dao;

import com.zsl.traceapi.dto.ZslTraceSidPageParam;
import com.zsl.traceapi.dto.ZslTraceSidVo;
import com.zsl.tracedb.model.ZslTraceSid;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ZslTraceSidDao
 * @Description sid操作
 * @Author binggleW
 * @Date 2019-09-20 15:21
 * @Version 1.0
 **/
public interface ZslTraceSidDao {
    List<ZslTraceSid> listByCount();
    List<ZslTraceSid> listBlankCodePart();
    List<ZslTraceSidVo> getByPage(@Param("queryParam") ZslTraceSidPageParam queryParam);
}
