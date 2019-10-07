package com.zsl.traceapi.dao;

import com.zsl.tracedb.model.ZslTraceSid;

import java.util.List;

/**
 * @ClassName ZslTraceSidDao
 * @Description sid操作
 * @Author binggleW
 * @Date 2019-09-20 15:21
 * @Version 1.0
 **/
public interface ZslTraceSidDao {
    ZslTraceSid selectNewPrePaperCode();
    ZslTraceSid selectByStartAndEndIndex();
    List<ZslTraceSid> listByCount();
    List<ZslTraceSid> listBlankCodePart();
}
