package com.zsl.traceapi.util;

public enum  IntegralEnum {
    INTEGRAL_DECUCT_RATIO_TYPE_1(1,100,"积分金额换算比例"),
    INTEGRAL_DECUCT_RATIO_TYPE_2(2,1,"关联商品/新增追溯点积分扣除数"),
    INTEGRAL_DECUCT_RATIO_TYPE_3(3,1,"纸质标签兑换需要积分数"),
    INTEGRAL_DECUCT_RATIO_TYPE_4(4,1,"商品录入/编辑扣除积分数"),
    INTEGRAL_DECUCT_RATIO_TYPE_5(5,1,"用户扫码追溯扣除积分数");



    private Integer id;
    private Integer ratio;
    private  String description;

    IntegralEnum(Integer id, Integer ratio, String description) {
        this.id = id;
        this.ratio = ratio;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRatio() {
        return ratio;
    }

    public void setRatio(Integer ratio) {
        this.ratio = ratio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
