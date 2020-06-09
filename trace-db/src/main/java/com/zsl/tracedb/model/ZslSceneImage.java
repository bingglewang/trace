package com.zsl.tracedb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ZslSceneImage implements Serializable {
    private Integer sceneImageId;

    @ApiModelProperty(value = "追溯场景主键id")
    private Integer sceneId;

    @ApiModelProperty(value = "图片链接")
    private String imageUrl;

    @ApiModelProperty(value = "图片顺序")
    private Integer showSort;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getSceneImageId() {
        return sceneImageId;
    }

    public void setSceneImageId(Integer sceneImageId) {
        this.sceneImageId = sceneImageId;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getShowSort() {
        return showSort;
    }

    public void setShowSort(Integer showSort) {
        this.showSort = showSort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sceneImageId=").append(sceneImageId);
        sb.append(", sceneId=").append(sceneId);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", showSort=").append(showSort);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}