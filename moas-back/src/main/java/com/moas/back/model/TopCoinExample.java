package com.moas.back.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TopCoinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TopCoinExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCoinidIsNull() {
            addCriterion("coinid is null");
            return (Criteria) this;
        }

        public Criteria andCoinidIsNotNull() {
            addCriterion("coinid is not null");
            return (Criteria) this;
        }

        public Criteria andCoinidEqualTo(Long value) {
            addCriterion("coinid =", value, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidNotEqualTo(Long value) {
            addCriterion("coinid <>", value, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidGreaterThan(Long value) {
            addCriterion("coinid >", value, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidGreaterThanOrEqualTo(Long value) {
            addCriterion("coinid >=", value, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidLessThan(Long value) {
            addCriterion("coinid <", value, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidLessThanOrEqualTo(Long value) {
            addCriterion("coinid <=", value, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidIn(List<Long> values) {
            addCriterion("coinid in", values, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidNotIn(List<Long> values) {
            addCriterion("coinid not in", values, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidBetween(Long value1, Long value2) {
            addCriterion("coinid between", value1, value2, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidNotBetween(Long value1, Long value2) {
            addCriterion("coinid not between", value1, value2, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinNameIsNull() {
            addCriterion("coin_name is null");
            return (Criteria) this;
        }

        public Criteria andCoinNameIsNotNull() {
            addCriterion("coin_name is not null");
            return (Criteria) this;
        }

        public Criteria andCoinNameEqualTo(String value) {
            addCriterion("coin_name =", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameNotEqualTo(String value) {
            addCriterion("coin_name <>", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameGreaterThan(String value) {
            addCriterion("coin_name >", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameGreaterThanOrEqualTo(String value) {
            addCriterion("coin_name >=", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameLessThan(String value) {
            addCriterion("coin_name <", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameLessThanOrEqualTo(String value) {
            addCriterion("coin_name <=", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameLike(String value) {
            addCriterion("coin_name like", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameNotLike(String value) {
            addCriterion("coin_name not like", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameIn(List<String> values) {
            addCriterion("coin_name in", values, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameNotIn(List<String> values) {
            addCriterion("coin_name not in", values, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameBetween(String value1, String value2) {
            addCriterion("coin_name between", value1, value2, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameNotBetween(String value1, String value2) {
            addCriterion("coin_name not between", value1, value2, "coinName");
            return (Criteria) this;
        }

        public Criteria andVolIsNull() {
            addCriterion("vol is null");
            return (Criteria) this;
        }

        public Criteria andVolIsNotNull() {
            addCriterion("vol is not null");
            return (Criteria) this;
        }

        public Criteria andVolEqualTo(BigDecimal value) {
            addCriterion("vol =", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotEqualTo(BigDecimal value) {
            addCriterion("vol <>", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolGreaterThan(BigDecimal value) {
            addCriterion("vol >", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vol >=", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolLessThan(BigDecimal value) {
            addCriterion("vol <", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolLessThanOrEqualTo(BigDecimal value) {
            addCriterion("vol <=", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolIn(List<BigDecimal> values) {
            addCriterion("vol in", values, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotIn(List<BigDecimal> values) {
            addCriterion("vol not in", values, "vol");
            return (Criteria) this;
        }

        public Criteria andVolBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vol between", value1, value2, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vol not between", value1, value2, "vol");
            return (Criteria) this;
        }

        public Criteria andHighIsNull() {
            addCriterion("high is null");
            return (Criteria) this;
        }

        public Criteria andHighIsNotNull() {
            addCriterion("high is not null");
            return (Criteria) this;
        }

        public Criteria andHighEqualTo(BigDecimal value) {
            addCriterion("high =", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotEqualTo(BigDecimal value) {
            addCriterion("high <>", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighGreaterThan(BigDecimal value) {
            addCriterion("high >", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("high >=", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighLessThan(BigDecimal value) {
            addCriterion("high <", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighLessThanOrEqualTo(BigDecimal value) {
            addCriterion("high <=", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighIn(List<BigDecimal> values) {
            addCriterion("high in", values, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotIn(List<BigDecimal> values) {
            addCriterion("high not in", values, "high");
            return (Criteria) this;
        }

        public Criteria andHighBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("high between", value1, value2, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("high not between", value1, value2, "high");
            return (Criteria) this;
        }

        public Criteria andLowIsNull() {
            addCriterion("low is null");
            return (Criteria) this;
        }

        public Criteria andLowIsNotNull() {
            addCriterion("low is not null");
            return (Criteria) this;
        }

        public Criteria andLowEqualTo(BigDecimal value) {
            addCriterion("low =", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowNotEqualTo(BigDecimal value) {
            addCriterion("low <>", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowGreaterThan(BigDecimal value) {
            addCriterion("low >", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("low >=", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowLessThan(BigDecimal value) {
            addCriterion("low <", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("low <=", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowIn(List<BigDecimal> values) {
            addCriterion("low in", values, "low");
            return (Criteria) this;
        }

        public Criteria andLowNotIn(List<BigDecimal> values) {
            addCriterion("low not in", values, "low");
            return (Criteria) this;
        }

        public Criteria andLowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("low between", value1, value2, "low");
            return (Criteria) this;
        }

        public Criteria andLowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("low not between", value1, value2, "low");
            return (Criteria) this;
        }

        public Criteria andLastDayIsNull() {
            addCriterion("last_day is null");
            return (Criteria) this;
        }

        public Criteria andLastDayIsNotNull() {
            addCriterion("last_day is not null");
            return (Criteria) this;
        }

        public Criteria andLastDayEqualTo(BigDecimal value) {
            addCriterion("last_day =", value, "lastDay");
            return (Criteria) this;
        }

        public Criteria andLastDayNotEqualTo(BigDecimal value) {
            addCriterion("last_day <>", value, "lastDay");
            return (Criteria) this;
        }

        public Criteria andLastDayGreaterThan(BigDecimal value) {
            addCriterion("last_day >", value, "lastDay");
            return (Criteria) this;
        }

        public Criteria andLastDayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("last_day >=", value, "lastDay");
            return (Criteria) this;
        }

        public Criteria andLastDayLessThan(BigDecimal value) {
            addCriterion("last_day <", value, "lastDay");
            return (Criteria) this;
        }

        public Criteria andLastDayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("last_day <=", value, "lastDay");
            return (Criteria) this;
        }

        public Criteria andLastDayIn(List<BigDecimal> values) {
            addCriterion("last_day in", values, "lastDay");
            return (Criteria) this;
        }

        public Criteria andLastDayNotIn(List<BigDecimal> values) {
            addCriterion("last_day not in", values, "lastDay");
            return (Criteria) this;
        }

        public Criteria andLastDayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_day between", value1, value2, "lastDay");
            return (Criteria) this;
        }

        public Criteria andLastDayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_day not between", value1, value2, "lastDay");
            return (Criteria) this;
        }

        public Criteria andLastIsNull() {
            addCriterion("last is null");
            return (Criteria) this;
        }

        public Criteria andLastIsNotNull() {
            addCriterion("last is not null");
            return (Criteria) this;
        }

        public Criteria andLastEqualTo(BigDecimal value) {
            addCriterion("last =", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastNotEqualTo(BigDecimal value) {
            addCriterion("last <>", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastGreaterThan(BigDecimal value) {
            addCriterion("last >", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("last >=", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastLessThan(BigDecimal value) {
            addCriterion("last <", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastLessThanOrEqualTo(BigDecimal value) {
            addCriterion("last <=", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastIn(List<BigDecimal> values) {
            addCriterion("last in", values, "last");
            return (Criteria) this;
        }

        public Criteria andLastNotIn(List<BigDecimal> values) {
            addCriterion("last not in", values, "last");
            return (Criteria) this;
        }

        public Criteria andLastBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last between", value1, value2, "last");
            return (Criteria) this;
        }

        public Criteria andLastNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last not between", value1, value2, "last");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(BigDecimal value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(BigDecimal value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(BigDecimal value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(BigDecimal value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<BigDecimal> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<BigDecimal> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andBuyIsNull() {
            addCriterion("buy is null");
            return (Criteria) this;
        }

        public Criteria andBuyIsNotNull() {
            addCriterion("buy is not null");
            return (Criteria) this;
        }

        public Criteria andBuyEqualTo(BigDecimal value) {
            addCriterion("buy =", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyNotEqualTo(BigDecimal value) {
            addCriterion("buy <>", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyGreaterThan(BigDecimal value) {
            addCriterion("buy >", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("buy >=", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyLessThan(BigDecimal value) {
            addCriterion("buy <", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("buy <=", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyIn(List<BigDecimal> values) {
            addCriterion("buy in", values, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyNotIn(List<BigDecimal> values) {
            addCriterion("buy not in", values, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buy between", value1, value2, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buy not between", value1, value2, "buy");
            return (Criteria) this;
        }

        public Criteria andSellIsNull() {
            addCriterion("sell is null");
            return (Criteria) this;
        }

        public Criteria andSellIsNotNull() {
            addCriterion("sell is not null");
            return (Criteria) this;
        }

        public Criteria andSellEqualTo(BigDecimal value) {
            addCriterion("sell =", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellNotEqualTo(BigDecimal value) {
            addCriterion("sell <>", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellGreaterThan(BigDecimal value) {
            addCriterion("sell >", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sell >=", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellLessThan(BigDecimal value) {
            addCriterion("sell <", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sell <=", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellIn(List<BigDecimal> values) {
            addCriterion("sell in", values, "sell");
            return (Criteria) this;
        }

        public Criteria andSellNotIn(List<BigDecimal> values) {
            addCriterion("sell not in", values, "sell");
            return (Criteria) this;
        }

        public Criteria andSellBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell between", value1, value2, "sell");
            return (Criteria) this;
        }

        public Criteria andSellNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell not between", value1, value2, "sell");
            return (Criteria) this;
        }

        public Criteria andCoinRangeIsNull() {
            addCriterion("coin_range is null");
            return (Criteria) this;
        }

        public Criteria andCoinRangeIsNotNull() {
            addCriterion("coin_range is not null");
            return (Criteria) this;
        }

        public Criteria andCoinRangeEqualTo(BigDecimal value) {
            addCriterion("coin_range =", value, "coinRange");
            return (Criteria) this;
        }

        public Criteria andCoinRangeNotEqualTo(BigDecimal value) {
            addCriterion("coin_range <>", value, "coinRange");
            return (Criteria) this;
        }

        public Criteria andCoinRangeGreaterThan(BigDecimal value) {
            addCriterion("coin_range >", value, "coinRange");
            return (Criteria) this;
        }

        public Criteria andCoinRangeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("coin_range >=", value, "coinRange");
            return (Criteria) this;
        }

        public Criteria andCoinRangeLessThan(BigDecimal value) {
            addCriterion("coin_range <", value, "coinRange");
            return (Criteria) this;
        }

        public Criteria andCoinRangeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("coin_range <=", value, "coinRange");
            return (Criteria) this;
        }

        public Criteria andCoinRangeIn(List<BigDecimal> values) {
            addCriterion("coin_range in", values, "coinRange");
            return (Criteria) this;
        }

        public Criteria andCoinRangeNotIn(List<BigDecimal> values) {
            addCriterion("coin_range not in", values, "coinRange");
            return (Criteria) this;
        }

        public Criteria andCoinRangeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coin_range between", value1, value2, "coinRange");
            return (Criteria) this;
        }

        public Criteria andCoinRangeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coin_range not between", value1, value2, "coinRange");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}