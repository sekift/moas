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

    private String highLow;

    private BigDecimal lastDay;

    private BigDecimal last;

    private BigDecimal money;

    private BigDecimal buy;

    private BigDecimal sell;

    private String buySell;

    private BigDecimal coinRange;

    private Date createTime;

    private BigDecimal diffLast10;

    private BigDecimal diffLast30;

    private BigDecimal diffLast60;

    private BigDecimal diffLast1260;

    private BigDecimal diffLast2460;

    private BigDecimal diffVol10;

    private BigDecimal diffVol30;

    private BigDecimal diffVol60;

    private BigDecimal diffVol1260;

    private BigDecimal diffVol2460;
}