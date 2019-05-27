package com.zsl.tracedb.mapper;

import com.zsl.tracedb.model.ImageFile;
import com.zsl.tracedb.model.ImageFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImageFileMapper {
    int countByExample(ImageFileExample example);

    int deleteByExample(ImageFileExample example);

    int deleteByPrimaryKey(String imgId);

    int insert(ImageFile record);

    int insertSelective(ImageFile record);

    List<ImageFile> selectByExample(ImageFileExample example);

    ImageFile selectByPrimaryKey(String imgId);

    int updateByExampleSelective(@Param("record") ImageFile record, @Param("example") ImageFileExample example);

    int updateByExample(@Param("record") ImageFile record, @Param("example") ImageFileExample example);

    int updateByPrimaryKeySelective(ImageFile record);

    int updateByPrimaryKey(ImageFile record);
}