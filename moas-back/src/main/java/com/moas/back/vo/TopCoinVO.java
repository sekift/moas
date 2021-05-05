package com.moas.back.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(description="虚拟币信息")
public class TopCoinVO {
    private Long coinid;

    private String coinName;

    private BigDecimal vol;

    private BigDecimal high;

    private BigDecimal low;

    private BigDecimal lastDay;

    private BigDecimal last;

    private BigDecimal money;

    private BigDecimal buy;

    private BigDecimal sell;

    private BigDecimal coinRange;

    private Date createTime;

    private String diff10;

    private String diff30;

    private String diff60;

    private String diff1260;

    private String diff2460;
}