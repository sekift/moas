package com.moas.crawler.model;

import java.util.ArrayList;
import java.util.List;

public class TopNewsUrlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TopNewsUrlExample() {
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

        public Criteria andNewsidIsNull() {
            addCriterion("newsid is null");
            return (Criteria) this;
        }

        public Criteria andNewsidIsNotNull() {
            addCriterion("newsid is not null");
            return (Criteria) this;
        }

        public Criteria andNewsidEqualTo(Integer value) {
            addCriterion("newsid =", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotEqualTo(Integer value) {
            addCriterion("newsid <>", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidGreaterThan(Integer value) {
            addCriterion("newsid >", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("newsid >=", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidLessThan(Integer value) {
            addCriterion("newsid <", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidLessThanOrEqualTo(Integer value) {
            addCriterion("newsid <=", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidIn(List<Integer> values) {
            addCriterion("newsid in", values, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotIn(List<Integer> values) {
            addCriterion("newsid not in", values, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidBetween(Integer value1, Integer value2) {
            addCriterion("newsid between", value1, value2, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotBetween(Integer value1, Integer value2) {
            addCriterion("newsid not between", value1, value2, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsnameIsNull() {
            addCriterion("newsname is null");
            return (Criteria) this;
        }

        public Criteria andNewsnameIsNotNull() {
            addCriterion("newsname is not null");
            return (Criteria) this;
        }

        public Criteria andNewsnameEqualTo(String value) {
            addCriterion("newsname =", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameNotEqualTo(String value) {
            addCriterion("newsname <>", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameGreaterThan(String value) {
            addCriterion("newsname >", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameGreaterThanOrEqualTo(String value) {
            addCriterion("newsname >=", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameLessThan(String value) {
            addCriterion("newsname <", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameLessThanOrEqualTo(String value) {
            addCriterion("newsname <=", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameLike(String value) {
            addCriterion("newsname like", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameNotLike(String value) {
            addCriterion("newsname not like", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameIn(List<String> values) {
            addCriterion("newsname in", values, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameNotIn(List<String> values) {
            addCriterion("newsname not in", values, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameBetween(String value1, String value2) {
            addCriterion("newsname between", value1, value2, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameNotBetween(String value1, String value2) {
            addCriterion("newsname not between", value1, value2, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsurlIsNull() {
            addCriterion("newsurl is null");
            return (Criteria) this;
        }

        public Criteria andNewsurlIsNotNull() {
            addCriterion("newsurl is not null");
            return (Criteria) this;
        }

        public Criteria andNewsurlEqualTo(String value) {
            addCriterion("newsurl =", value, "newsurl");
            return (Criteria) this;
        }

        public Criteria andNewsurlNotEqualTo(String value) {
            addCriterion("newsurl <>", value, "newsurl");
            return (Criteria) this;
        }

        public Criteria andNewsurlGreaterThan(String value) {
            addCriterion("newsurl >", value, "newsurl");
            return (Criteria) this;
        }

        public Criteria andNewsurlGreaterThanOrEqualTo(String value) {
            addCriterion("newsurl >=", value, "newsurl");
            return (Criteria) this;
        }

        public Criteria andNewsurlLessThan(String value) {
            addCriterion("newsurl <", value, "newsurl");
            return (Criteria) this;
        }

        public Criteria andNewsurlLessThanOrEqualTo(String value) {
            addCriterion("newsurl <=", value, "newsurl");
            return (Criteria) this;
        }

        public Criteria andNewsurlLike(String value) {
            addCriterion("newsurl like", value, "newsurl");
            return (Criteria) this;
        }

        public Criteria andNewsurlNotLike(String value) {
            addCriterion("newsurl not like", value, "newsurl");
            return (Criteria) this;
        }

        public Criteria andNewsurlIn(List<String> values) {
            addCriterion("newsurl in", values, "newsurl");
            return (Criteria) this;
        }

        public Criteria andNewsurlNotIn(List<String> values) {
            addCriterion("newsurl not in", values, "newsurl");
            return (Criteria) this;
        }

        public Criteria andNewsurlBetween(String value1, String value2) {
            addCriterion("newsurl between", value1, value2, "newsurl");
            return (Criteria) this;
        }

        public Criteria andNewsurlNotBetween(String value1, String value2) {
            addCriterion("newsurl not between", value1, value2, "newsurl");
            return (Criteria) this;
        }

        public Criteria andNewsproductIsNull() {
            addCriterion("newsproduct is null");
            return (Criteria) this;
        }

        public Criteria andNewsproductIsNotNull() {
            addCriterion("newsproduct is not null");
            return (Criteria) this;
        }

        public Criteria andNewsproductEqualTo(String value) {
            addCriterion("newsproduct =", value, "newsproduct");
            return (Criteria) this;
        }

        public Criteria andNewsproductNotEqualTo(String value) {
            addCriterion("newsproduct <>", value, "newsproduct");
            return (Criteria) this;
        }

        public Criteria andNewsproductGreaterThan(String value) {
            addCriterion("newsproduct >", value, "newsproduct");
            return (Criteria) this;
        }

        public Criteria andNewsproductGreaterThanOrEqualTo(String value) {
            addCriterion("newsproduct >=", value, "newsproduct");
            return (Criteria) this;
        }

        public Criteria andNewsproductLessThan(String value) {
            addCriterion("newsproduct <", value, "newsproduct");
            return (Criteria) this;
        }

        public Criteria andNewsproductLessThanOrEqualTo(String value) {
            addCriterion("newsproduct <=", value, "newsproduct");
            return (Criteria) this;
        }

        public Criteria andNewsproductLike(String value) {
            addCriterion("newsproduct like", value, "newsproduct");
            return (Criteria) this;
        }

        public Criteria andNewsproductNotLike(String value) {
            addCriterion("newsproduct not like", value, "newsproduct");
            return (Criteria) this;
        }

        public Criteria andNewsproductIn(List<String> values) {
            addCriterion("newsproduct in", values, "newsproduct");
            return (Criteria) this;
        }

        public Criteria andNewsproductNotIn(List<String> values) {
            addCriterion("newsproduct not in", values, "newsproduct");
            return (Criteria) this;
        }

        public Criteria andNewsproductBetween(String value1, String value2) {
            addCriterion("newsproduct between", value1, value2, "newsproduct");
            return (Criteria) this;
        }

        public Criteria andNewsproductNotBetween(String value1, String value2) {
            addCriterion("newsproduct not between", value1, value2, "newsproduct");
            return (Criteria) this;
        }

        public Criteria andNewstypeIsNull() {
            addCriterion("newstype is null");
            return (Criteria) this;
        }

        public Criteria andNewstypeIsNotNull() {
            addCriterion("newstype is not null");
            return (Criteria) this;
        }

        public Criteria andNewstypeEqualTo(Byte value) {
            addCriterion("newstype =", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeNotEqualTo(Byte value) {
            addCriterion("newstype <>", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeGreaterThan(Byte value) {
            addCriterion("newstype >", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("newstype >=", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeLessThan(Byte value) {
            addCriterion("newstype <", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeLessThanOrEqualTo(Byte value) {
            addCriterion("newstype <=", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeIn(List<Byte> values) {
            addCriterion("newstype in", values, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeNotIn(List<Byte> values) {
            addCriterion("newstype not in", values, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeBetween(Byte value1, Byte value2) {
            addCriterion("newstype between", value1, value2, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeNotBetween(Byte value1, Byte value2) {
            addCriterion("newstype not between", value1, value2, "newstype");
            return (Criteria) this;
        }

        public Criteria andCronIsNull() {
            addCriterion("cron is null");
            return (Criteria) this;
        }

        public Criteria andCronIsNotNull() {
            addCriterion("cron is not null");
            return (Criteria) this;
        }

        public Criteria andCronEqualTo(String value) {
            addCriterion("cron =", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotEqualTo(String value) {
            addCriterion("cron <>", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronGreaterThan(String value) {
            addCriterion("cron >", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronGreaterThanOrEqualTo(String value) {
            addCriterion("cron >=", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronLessThan(String value) {
            addCriterion("cron <", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronLessThanOrEqualTo(String value) {
            addCriterion("cron <=", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronLike(String value) {
            addCriterion("cron like", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotLike(String value) {
            addCriterion("cron not like", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronIn(List<String> values) {
            addCriterion("cron in", values, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotIn(List<String> values) {
            addCriterion("cron not in", values, "cron");
            return (Criteria) this;
        }

        public Criteria andCronBetween(String value1, String value2) {
            addCriterion("cron between", value1, value2, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotBetween(String value1, String value2) {
            addCriterion("cron not between", value1, value2, "cron");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCookieIsNull() {
            addCriterion("cookie is null");
            return (Criteria) this;
        }

        public Criteria andCookieIsNotNull() {
            addCriterion("cookie is not null");
            return (Criteria) this;
        }

        public Criteria andCookieEqualTo(String value) {
            addCriterion("cookie =", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotEqualTo(String value) {
            addCriterion("cookie <>", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieGreaterThan(String value) {
            addCriterion("cookie >", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieGreaterThanOrEqualTo(String value) {
            addCriterion("cookie >=", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLessThan(String value) {
            addCriterion("cookie <", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLessThanOrEqualTo(String value) {
            addCriterion("cookie <=", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLike(String value) {
            addCriterion("cookie like", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotLike(String value) {
            addCriterion("cookie not like", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieIn(List<String> values) {
            addCriterion("cookie in", values, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotIn(List<String> values) {
            addCriterion("cookie not in", values, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieBetween(String value1, String value2) {
            addCriterion("cookie between", value1, value2, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotBetween(String value1, String value2) {
            addCriterion("cookie not between", value1, value2, "cookie");
            return (Criteria) this;
        }

        public Criteria andHeaderIsNull() {
            addCriterion("header is null");
            return (Criteria) this;
        }

        public Criteria andHeaderIsNotNull() {
            addCriterion("header is not null");
            return (Criteria) this;
        }

        public Criteria andHeaderEqualTo(String value) {
            addCriterion("header =", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotEqualTo(String value) {
            addCriterion("header <>", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderGreaterThan(String value) {
            addCriterion("header >", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderGreaterThanOrEqualTo(String value) {
            addCriterion("header >=", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderLessThan(String value) {
            addCriterion("header <", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderLessThanOrEqualTo(String value) {
            addCriterion("header <=", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderLike(String value) {
            addCriterion("header like", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotLike(String value) {
            addCriterion("header not like", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderIn(List<String> values) {
            addCriterion("header in", values, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotIn(List<String> values) {
            addCriterion("header not in", values, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderBetween(String value1, String value2) {
            addCriterion("header between", value1, value2, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotBetween(String value1, String value2) {
            addCriterion("header not between", value1, value2, "header");
            return (Criteria) this;
        }

        public Criteria andParamIsNull() {
            addCriterion("param is null");
            return (Criteria) this;
        }

        public Criteria andParamIsNotNull() {
            addCriterion("param is not null");
            return (Criteria) this;
        }

        public Criteria andParamEqualTo(String value) {
            addCriterion("param =", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotEqualTo(String value) {
            addCriterion("param <>", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamGreaterThan(String value) {
            addCriterion("param >", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamGreaterThanOrEqualTo(String value) {
            addCriterion("param >=", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLessThan(String value) {
            addCriterion("param <", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLessThanOrEqualTo(String value) {
            addCriterion("param <=", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLike(String value) {
            addCriterion("param like", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotLike(String value) {
            addCriterion("param not like", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamIn(List<String> values) {
            addCriterion("param in", values, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotIn(List<String> values) {
            addCriterion("param not in", values, "param");
            return (Criteria) this;
        }

        public Criteria andParamBetween(String value1, String value2) {
            addCriterion("param between", value1, value2, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotBetween(String value1, String value2) {
            addCriterion("param not between", value1, value2, "param");
            return (Criteria) this;
        }

        public Criteria andRequesttypeIsNull() {
            addCriterion("requesttype is null");
            return (Criteria) this;
        }

        public Criteria andRequesttypeIsNotNull() {
            addCriterion("requesttype is not null");
            return (Criteria) this;
        }

        public Criteria andRequesttypeEqualTo(Byte value) {
            addCriterion("requesttype =", value, "requesttype");
            return (Criteria) this;
        }

        public Criteria andRequesttypeNotEqualTo(Byte value) {
            addCriterion("requesttype <>", value, "requesttype");
            return (Criteria) this;
        }

        public Criteria andRequesttypeGreaterThan(Byte value) {
            addCriterion("requesttype >", value, "requesttype");
            return (Criteria) this;
        }

        public Criteria andRequesttypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("requesttype >=", value, "requesttype");
            return (Criteria) this;
        }

        public Criteria andRequesttypeLessThan(Byte value) {
            addCriterion("requesttype <", value, "requesttype");
            return (Criteria) this;
        }

        public Criteria andRequesttypeLessThanOrEqualTo(Byte value) {
            addCriterion("requesttype <=", value, "requesttype");
            return (Criteria) this;
        }

        public Criteria andRequesttypeIn(List<Byte> values) {
            addCriterion("requesttype in", values, "requesttype");
            return (Criteria) this;
        }

        public Criteria andRequesttypeNotIn(List<Byte> values) {
            addCriterion("requesttype not in", values, "requesttype");
            return (Criteria) this;
        }

        public Criteria andRequesttypeBetween(Byte value1, Byte value2) {
            addCriterion("requesttype between", value1, value2, "requesttype");
            return (Criteria) this;
        }

        public Criteria andRequesttypeNotBetween(Byte value1, Byte value2) {
            addCriterion("requesttype not between", value1, value2, "requesttype");
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