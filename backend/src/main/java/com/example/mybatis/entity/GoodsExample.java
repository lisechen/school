package com.example.mybatis.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNull() {
            addCriterion("goodsname is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNotNull() {
            addCriterion("goodsname is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameEqualTo(String value) {
            addCriterion("goodsname =", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotEqualTo(String value) {
            addCriterion("goodsname <>", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThan(String value) {
            addCriterion("goodsname >", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThanOrEqualTo(String value) {
            addCriterion("goodsname >=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThan(String value) {
            addCriterion("goodsname <", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThanOrEqualTo(String value) {
            addCriterion("goodsname <=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLike(String value) {
            addCriterion("goodsname like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotLike(String value) {
            addCriterion("goodsname not like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIn(List<String> values) {
            addCriterion("goodsname in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotIn(List<String> values) {
            addCriterion("goodsname not in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameBetween(String value1, String value2) {
            addCriterion("goodsname between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotBetween(String value1, String value2) {
            addCriterion("goodsname not between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andTextdescIsNull() {
            addCriterion("textdesc is null");
            return (Criteria) this;
        }

        public Criteria andTextdescIsNotNull() {
            addCriterion("textdesc is not null");
            return (Criteria) this;
        }

        public Criteria andTextdescEqualTo(String value) {
            addCriterion("textdesc =", value, "textdesc");
            return (Criteria) this;
        }

        public Criteria andTextdescNotEqualTo(String value) {
            addCriterion("textdesc <>", value, "textdesc");
            return (Criteria) this;
        }

        public Criteria andTextdescGreaterThan(String value) {
            addCriterion("textdesc >", value, "textdesc");
            return (Criteria) this;
        }

        public Criteria andTextdescGreaterThanOrEqualTo(String value) {
            addCriterion("textdesc >=", value, "textdesc");
            return (Criteria) this;
        }

        public Criteria andTextdescLessThan(String value) {
            addCriterion("textdesc <", value, "textdesc");
            return (Criteria) this;
        }

        public Criteria andTextdescLessThanOrEqualTo(String value) {
            addCriterion("textdesc <=", value, "textdesc");
            return (Criteria) this;
        }

        public Criteria andTextdescLike(String value) {
            addCriterion("textdesc like", value, "textdesc");
            return (Criteria) this;
        }

        public Criteria andTextdescNotLike(String value) {
            addCriterion("textdesc not like", value, "textdesc");
            return (Criteria) this;
        }

        public Criteria andTextdescIn(List<String> values) {
            addCriterion("textdesc in", values, "textdesc");
            return (Criteria) this;
        }

        public Criteria andTextdescNotIn(List<String> values) {
            addCriterion("textdesc not in", values, "textdesc");
            return (Criteria) this;
        }

        public Criteria andTextdescBetween(String value1, String value2) {
            addCriterion("textdesc between", value1, value2, "textdesc");
            return (Criteria) this;
        }

        public Criteria andTextdescNotBetween(String value1, String value2) {
            addCriterion("textdesc not between", value1, value2, "textdesc");
            return (Criteria) this;
        }

        public Criteria andGoodslmgIsNull() {
            addCriterion("goodsLmg is null");
            return (Criteria) this;
        }

        public Criteria andGoodslmgIsNotNull() {
            addCriterion("goodsLmg is not null");
            return (Criteria) this;
        }

        public Criteria andGoodslmgEqualTo(String value) {
            addCriterion("goodsLmg =", value, "goodslmg");
            return (Criteria) this;
        }

        public Criteria andGoodslmgNotEqualTo(String value) {
            addCriterion("goodsLmg <>", value, "goodslmg");
            return (Criteria) this;
        }

        public Criteria andGoodslmgGreaterThan(String value) {
            addCriterion("goodsLmg >", value, "goodslmg");
            return (Criteria) this;
        }

        public Criteria andGoodslmgGreaterThanOrEqualTo(String value) {
            addCriterion("goodsLmg >=", value, "goodslmg");
            return (Criteria) this;
        }

        public Criteria andGoodslmgLessThan(String value) {
            addCriterion("goodsLmg <", value, "goodslmg");
            return (Criteria) this;
        }

        public Criteria andGoodslmgLessThanOrEqualTo(String value) {
            addCriterion("goodsLmg <=", value, "goodslmg");
            return (Criteria) this;
        }

        public Criteria andGoodslmgLike(String value) {
            addCriterion("goodsLmg like", value, "goodslmg");
            return (Criteria) this;
        }

        public Criteria andGoodslmgNotLike(String value) {
            addCriterion("goodsLmg not like", value, "goodslmg");
            return (Criteria) this;
        }

        public Criteria andGoodslmgIn(List<String> values) {
            addCriterion("goodsLmg in", values, "goodslmg");
            return (Criteria) this;
        }

        public Criteria andGoodslmgNotIn(List<String> values) {
            addCriterion("goodsLmg not in", values, "goodslmg");
            return (Criteria) this;
        }

        public Criteria andGoodslmgBetween(String value1, String value2) {
            addCriterion("goodsLmg between", value1, value2, "goodslmg");
            return (Criteria) this;
        }

        public Criteria andGoodslmgNotBetween(String value1, String value2) {
            addCriterion("goodsLmg not between", value1, value2, "goodslmg");
            return (Criteria) this;
        }

        public Criteria andGoodspriceIsNull() {
            addCriterion("goodsPrice is null");
            return (Criteria) this;
        }

        public Criteria andGoodspriceIsNotNull() {
            addCriterion("goodsPrice is not null");
            return (Criteria) this;
        }

        public Criteria andGoodspriceEqualTo(BigDecimal value) {
            addCriterion("goodsPrice =", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceNotEqualTo(BigDecimal value) {
            addCriterion("goodsPrice <>", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceGreaterThan(BigDecimal value) {
            addCriterion("goodsPrice >", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goodsPrice >=", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceLessThan(BigDecimal value) {
            addCriterion("goodsPrice <", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goodsPrice <=", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceIn(List<BigDecimal> values) {
            addCriterion("goodsPrice in", values, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceNotIn(List<BigDecimal> values) {
            addCriterion("goodsPrice not in", values, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goodsPrice between", value1, value2, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goodsPrice not between", value1, value2, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodsstateIsNull() {
            addCriterion("goodsState is null");
            return (Criteria) this;
        }

        public Criteria andGoodsstateIsNotNull() {
            addCriterion("goodsState is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsstateEqualTo(String value) {
            addCriterion("goodsState =", value, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateNotEqualTo(String value) {
            addCriterion("goodsState <>", value, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateGreaterThan(String value) {
            addCriterion("goodsState >", value, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateGreaterThanOrEqualTo(String value) {
            addCriterion("goodsState >=", value, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateLessThan(String value) {
            addCriterion("goodsState <", value, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateLessThanOrEqualTo(String value) {
            addCriterion("goodsState <=", value, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateLike(String value) {
            addCriterion("goodsState like", value, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateNotLike(String value) {
            addCriterion("goodsState not like", value, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateIn(List<String> values) {
            addCriterion("goodsState in", values, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateNotIn(List<String> values) {
            addCriterion("goodsState not in", values, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateBetween(String value1, String value2) {
            addCriterion("goodsState between", value1, value2, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateNotBetween(String value1, String value2) {
            addCriterion("goodsState not between", value1, value2, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andMeansIsNull() {
            addCriterion("means is null");
            return (Criteria) this;
        }

        public Criteria andMeansIsNotNull() {
            addCriterion("means is not null");
            return (Criteria) this;
        }

        public Criteria andMeansEqualTo(String value) {
            addCriterion("means =", value, "means");
            return (Criteria) this;
        }

        public Criteria andMeansNotEqualTo(String value) {
            addCriterion("means <>", value, "means");
            return (Criteria) this;
        }

        public Criteria andMeansGreaterThan(String value) {
            addCriterion("means >", value, "means");
            return (Criteria) this;
        }

        public Criteria andMeansGreaterThanOrEqualTo(String value) {
            addCriterion("means >=", value, "means");
            return (Criteria) this;
        }

        public Criteria andMeansLessThan(String value) {
            addCriterion("means <", value, "means");
            return (Criteria) this;
        }

        public Criteria andMeansLessThanOrEqualTo(String value) {
            addCriterion("means <=", value, "means");
            return (Criteria) this;
        }

        public Criteria andMeansLike(String value) {
            addCriterion("means like", value, "means");
            return (Criteria) this;
        }

        public Criteria andMeansNotLike(String value) {
            addCriterion("means not like", value, "means");
            return (Criteria) this;
        }

        public Criteria andMeansIn(List<String> values) {
            addCriterion("means in", values, "means");
            return (Criteria) this;
        }

        public Criteria andMeansNotIn(List<String> values) {
            addCriterion("means not in", values, "means");
            return (Criteria) this;
        }

        public Criteria andMeansBetween(String value1, String value2) {
            addCriterion("means between", value1, value2, "means");
            return (Criteria) this;
        }

        public Criteria andMeansNotBetween(String value1, String value2) {
            addCriterion("means not between", value1, value2, "means");
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andGoodssortIsNull() {
            addCriterion("goodssort is null");
            return (Criteria) this;
        }

        public Criteria andGoodssortIsNotNull() {
            addCriterion("goodssort is not null");
            return (Criteria) this;
        }

        public Criteria andGoodssortEqualTo(String value) {
            addCriterion("goodssort =", value, "goodssort");
            return (Criteria) this;
        }

        public Criteria andGoodssortNotEqualTo(String value) {
            addCriterion("goodssort <>", value, "goodssort");
            return (Criteria) this;
        }

        public Criteria andGoodssortGreaterThan(String value) {
            addCriterion("goodssort >", value, "goodssort");
            return (Criteria) this;
        }

        public Criteria andGoodssortGreaterThanOrEqualTo(String value) {
            addCriterion("goodssort >=", value, "goodssort");
            return (Criteria) this;
        }

        public Criteria andGoodssortLessThan(String value) {
            addCriterion("goodssort <", value, "goodssort");
            return (Criteria) this;
        }

        public Criteria andGoodssortLessThanOrEqualTo(String value) {
            addCriterion("goodssort <=", value, "goodssort");
            return (Criteria) this;
        }

        public Criteria andGoodssortLike(String value) {
            addCriterion("goodssort like", value, "goodssort");
            return (Criteria) this;
        }

        public Criteria andGoodssortNotLike(String value) {
            addCriterion("goodssort not like", value, "goodssort");
            return (Criteria) this;
        }

        public Criteria andGoodssortIn(List<String> values) {
            addCriterion("goodssort in", values, "goodssort");
            return (Criteria) this;
        }

        public Criteria andGoodssortNotIn(List<String> values) {
            addCriterion("goodssort not in", values, "goodssort");
            return (Criteria) this;
        }

        public Criteria andGoodssortBetween(String value1, String value2) {
            addCriterion("goodssort between", value1, value2, "goodssort");
            return (Criteria) this;
        }

        public Criteria andGoodssortNotBetween(String value1, String value2) {
            addCriterion("goodssort not between", value1, value2, "goodssort");
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