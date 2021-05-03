package com.moas.crawler.model;

import java.math.BigDecimal;
import java.util.Date;

public class TopCoin {
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

    public Long getCoinid() {
        return coinid;
    }

    public void setCoinid(Long coinid) {
        this.coinid = coinid;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName == null ? null : coinName.trim();
    }

    public BigDecimal getVol() {
        return vol;
    }

    public void setVol(BigDecimal vol) {
        this.vol = vol;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getLastDay() {
        return lastDay;
    }

    public void setLastDay(BigDecimal lastDay) {
        this.lastDay = lastDay;
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public BigDecimal getSell() {
        return sell;
    }

    public void setSell(BigDecimal sell) {
        this.sell = sell;
    }

    public BigDecimal getCoinRange() {
        return coinRange;
    }

    public void setCoinRange(BigDecimal coinRange) {
        this.coinRange = coinRange;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}