package com.fc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andEidIsNull() {
            addCriterion("eid is null");
            return (Criteria) this;
        }

        public Criteria andEidIsNotNull() {
            addCriterion("eid is not null");
            return (Criteria) this;
        }

        public Criteria andEidEqualTo(Integer value) {
            addCriterion("eid =", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotEqualTo(Integer value) {
            addCriterion("eid <>", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThan(Integer value) {
            addCriterion("eid >", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThanOrEqualTo(Integer value) {
            addCriterion("eid >=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThan(Integer value) {
            addCriterion("eid <", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThanOrEqualTo(Integer value) {
            addCriterion("eid <=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidIn(List<Integer> values) {
            addCriterion("eid in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotIn(List<Integer> values) {
            addCriterion("eid not in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidBetween(Integer value1, Integer value2) {
            addCriterion("eid between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotBetween(Integer value1, Integer value2) {
            addCriterion("eid not between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andPnameIsNull() {
            addCriterion("pname is null");
            return (Criteria) this;
        }

        public Criteria andPnameIsNotNull() {
            addCriterion("pname is not null");
            return (Criteria) this;
        }

        public Criteria andPnameEqualTo(String value) {
            addCriterion("pname =", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotEqualTo(String value) {
            addCriterion("pname <>", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThan(String value) {
            addCriterion("pname >", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThanOrEqualTo(String value) {
            addCriterion("pname >=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThan(String value) {
            addCriterion("pname <", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThanOrEqualTo(String value) {
            addCriterion("pname <=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLike(String value) {
            addCriterion("pname like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotLike(String value) {
            addCriterion("pname not like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameIn(List<String> values) {
            addCriterion("pname in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotIn(List<String> values) {
            addCriterion("pname not in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameBetween(String value1, String value2) {
            addCriterion("pname between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotBetween(String value1, String value2) {
            addCriterion("pname not between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andCnoIsNull() {
            addCriterion("cno is null");
            return (Criteria) this;
        }

        public Criteria andCnoIsNotNull() {
            addCriterion("cno is not null");
            return (Criteria) this;
        }

        public Criteria andCnoEqualTo(Integer value) {
            addCriterion("cno =", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotEqualTo(Integer value) {
            addCriterion("cno <>", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoGreaterThan(Integer value) {
            addCriterion("cno >", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("cno >=", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoLessThan(Integer value) {
            addCriterion("cno <", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoLessThanOrEqualTo(Integer value) {
            addCriterion("cno <=", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoIn(List<Integer> values) {
            addCriterion("cno in", values, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotIn(List<Integer> values) {
            addCriterion("cno not in", values, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoBetween(Integer value1, Integer value2) {
            addCriterion("cno between", value1, value2, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotBetween(Integer value1, Integer value2) {
            addCriterion("cno not between", value1, value2, "cno");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andClassidIsNull() {
            addCriterion("classid is null");
            return (Criteria) this;
        }

        public Criteria andClassidIsNotNull() {
            addCriterion("classid is not null");
            return (Criteria) this;
        }

        public Criteria andClassidEqualTo(Integer value) {
            addCriterion("classid =", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotEqualTo(Integer value) {
            addCriterion("classid <>", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThan(Integer value) {
            addCriterion("classid >", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThanOrEqualTo(Integer value) {
            addCriterion("classid >=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThan(Integer value) {
            addCriterion("classid <", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThanOrEqualTo(Integer value) {
            addCriterion("classid <=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidIn(List<Integer> values) {
            addCriterion("classid in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotIn(List<Integer> values) {
            addCriterion("classid not in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidBetween(Integer value1, Integer value2) {
            addCriterion("classid between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotBetween(Integer value1, Integer value2) {
            addCriterion("classid not between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andSinglenumberIsNull() {
            addCriterion("singlenumber is null");
            return (Criteria) this;
        }

        public Criteria andSinglenumberIsNotNull() {
            addCriterion("singlenumber is not null");
            return (Criteria) this;
        }

        public Criteria andSinglenumberEqualTo(Integer value) {
            addCriterion("singlenumber =", value, "singlenumber");
            return (Criteria) this;
        }

        public Criteria andSinglenumberNotEqualTo(Integer value) {
            addCriterion("singlenumber <>", value, "singlenumber");
            return (Criteria) this;
        }

        public Criteria andSinglenumberGreaterThan(Integer value) {
            addCriterion("singlenumber >", value, "singlenumber");
            return (Criteria) this;
        }

        public Criteria andSinglenumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("singlenumber >=", value, "singlenumber");
            return (Criteria) this;
        }

        public Criteria andSinglenumberLessThan(Integer value) {
            addCriterion("singlenumber <", value, "singlenumber");
            return (Criteria) this;
        }

        public Criteria andSinglenumberLessThanOrEqualTo(Integer value) {
            addCriterion("singlenumber <=", value, "singlenumber");
            return (Criteria) this;
        }

        public Criteria andSinglenumberIn(List<Integer> values) {
            addCriterion("singlenumber in", values, "singlenumber");
            return (Criteria) this;
        }

        public Criteria andSinglenumberNotIn(List<Integer> values) {
            addCriterion("singlenumber not in", values, "singlenumber");
            return (Criteria) this;
        }

        public Criteria andSinglenumberBetween(Integer value1, Integer value2) {
            addCriterion("singlenumber between", value1, value2, "singlenumber");
            return (Criteria) this;
        }

        public Criteria andSinglenumberNotBetween(Integer value1, Integer value2) {
            addCriterion("singlenumber not between", value1, value2, "singlenumber");
            return (Criteria) this;
        }

        public Criteria andSinglecoreIsNull() {
            addCriterion("singlecore is null");
            return (Criteria) this;
        }

        public Criteria andSinglecoreIsNotNull() {
            addCriterion("singlecore is not null");
            return (Criteria) this;
        }

        public Criteria andSinglecoreEqualTo(Integer value) {
            addCriterion("singlecore =", value, "singlecore");
            return (Criteria) this;
        }

        public Criteria andSinglecoreNotEqualTo(Integer value) {
            addCriterion("singlecore <>", value, "singlecore");
            return (Criteria) this;
        }

        public Criteria andSinglecoreGreaterThan(Integer value) {
            addCriterion("singlecore >", value, "singlecore");
            return (Criteria) this;
        }

        public Criteria andSinglecoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("singlecore >=", value, "singlecore");
            return (Criteria) this;
        }

        public Criteria andSinglecoreLessThan(Integer value) {
            addCriterion("singlecore <", value, "singlecore");
            return (Criteria) this;
        }

        public Criteria andSinglecoreLessThanOrEqualTo(Integer value) {
            addCriterion("singlecore <=", value, "singlecore");
            return (Criteria) this;
        }

        public Criteria andSinglecoreIn(List<Integer> values) {
            addCriterion("singlecore in", values, "singlecore");
            return (Criteria) this;
        }

        public Criteria andSinglecoreNotIn(List<Integer> values) {
            addCriterion("singlecore not in", values, "singlecore");
            return (Criteria) this;
        }

        public Criteria andSinglecoreBetween(Integer value1, Integer value2) {
            addCriterion("singlecore between", value1, value2, "singlecore");
            return (Criteria) this;
        }

        public Criteria andSinglecoreNotBetween(Integer value1, Integer value2) {
            addCriterion("singlecore not between", value1, value2, "singlecore");
            return (Criteria) this;
        }

        public Criteria andMultiplenumberIsNull() {
            addCriterion("multiplenumber is null");
            return (Criteria) this;
        }

        public Criteria andMultiplenumberIsNotNull() {
            addCriterion("multiplenumber is not null");
            return (Criteria) this;
        }

        public Criteria andMultiplenumberEqualTo(Integer value) {
            addCriterion("multiplenumber =", value, "multiplenumber");
            return (Criteria) this;
        }

        public Criteria andMultiplenumberNotEqualTo(Integer value) {
            addCriterion("multiplenumber <>", value, "multiplenumber");
            return (Criteria) this;
        }

        public Criteria andMultiplenumberGreaterThan(Integer value) {
            addCriterion("multiplenumber >", value, "multiplenumber");
            return (Criteria) this;
        }

        public Criteria andMultiplenumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("multiplenumber >=", value, "multiplenumber");
            return (Criteria) this;
        }

        public Criteria andMultiplenumberLessThan(Integer value) {
            addCriterion("multiplenumber <", value, "multiplenumber");
            return (Criteria) this;
        }

        public Criteria andMultiplenumberLessThanOrEqualTo(Integer value) {
            addCriterion("multiplenumber <=", value, "multiplenumber");
            return (Criteria) this;
        }

        public Criteria andMultiplenumberIn(List<Integer> values) {
            addCriterion("multiplenumber in", values, "multiplenumber");
            return (Criteria) this;
        }

        public Criteria andMultiplenumberNotIn(List<Integer> values) {
            addCriterion("multiplenumber not in", values, "multiplenumber");
            return (Criteria) this;
        }

        public Criteria andMultiplenumberBetween(Integer value1, Integer value2) {
            addCriterion("multiplenumber between", value1, value2, "multiplenumber");
            return (Criteria) this;
        }

        public Criteria andMultiplenumberNotBetween(Integer value1, Integer value2) {
            addCriterion("multiplenumber not between", value1, value2, "multiplenumber");
            return (Criteria) this;
        }

        public Criteria andMultiplecoreIsNull() {
            addCriterion("multiplecore is null");
            return (Criteria) this;
        }

        public Criteria andMultiplecoreIsNotNull() {
            addCriterion("multiplecore is not null");
            return (Criteria) this;
        }

        public Criteria andMultiplecoreEqualTo(Integer value) {
            addCriterion("multiplecore =", value, "multiplecore");
            return (Criteria) this;
        }

        public Criteria andMultiplecoreNotEqualTo(Integer value) {
            addCriterion("multiplecore <>", value, "multiplecore");
            return (Criteria) this;
        }

        public Criteria andMultiplecoreGreaterThan(Integer value) {
            addCriterion("multiplecore >", value, "multiplecore");
            return (Criteria) this;
        }

        public Criteria andMultiplecoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("multiplecore >=", value, "multiplecore");
            return (Criteria) this;
        }

        public Criteria andMultiplecoreLessThan(Integer value) {
            addCriterion("multiplecore <", value, "multiplecore");
            return (Criteria) this;
        }

        public Criteria andMultiplecoreLessThanOrEqualTo(Integer value) {
            addCriterion("multiplecore <=", value, "multiplecore");
            return (Criteria) this;
        }

        public Criteria andMultiplecoreIn(List<Integer> values) {
            addCriterion("multiplecore in", values, "multiplecore");
            return (Criteria) this;
        }

        public Criteria andMultiplecoreNotIn(List<Integer> values) {
            addCriterion("multiplecore not in", values, "multiplecore");
            return (Criteria) this;
        }

        public Criteria andMultiplecoreBetween(Integer value1, Integer value2) {
            addCriterion("multiplecore between", value1, value2, "multiplecore");
            return (Criteria) this;
        }

        public Criteria andMultiplecoreNotBetween(Integer value1, Integer value2) {
            addCriterion("multiplecore not between", value1, value2, "multiplecore");
            return (Criteria) this;
        }

        public Criteria andExamdateIsNull() {
            addCriterion("examdate is null");
            return (Criteria) this;
        }

        public Criteria andExamdateIsNotNull() {
            addCriterion("examdate is not null");
            return (Criteria) this;
        }

        public Criteria andExamdateEqualTo(Date value) {
            addCriterionForJDBCDate("examdate =", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("examdate <>", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateGreaterThan(Date value) {
            addCriterionForJDBCDate("examdate >", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("examdate >=", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateLessThan(Date value) {
            addCriterionForJDBCDate("examdate <", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("examdate <=", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateIn(List<Date> values) {
            addCriterionForJDBCDate("examdate in", values, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("examdate not in", values, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("examdate between", value1, value2, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("examdate not between", value1, value2, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamtimeIsNull() {
            addCriterion("examtime is null");
            return (Criteria) this;
        }

        public Criteria andExamtimeIsNotNull() {
            addCriterion("examtime is not null");
            return (Criteria) this;
        }

        public Criteria andExamtimeEqualTo(Date value) {
            addCriterionForJDBCDate("examtime =", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("examtime <>", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("examtime >", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("examtime >=", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeLessThan(Date value) {
            addCriterionForJDBCDate("examtime <", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("examtime <=", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeIn(List<Date> values) {
            addCriterionForJDBCDate("examtime in", values, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("examtime not in", values, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("examtime between", value1, value2, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("examtime not between", value1, value2, "examtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeIsNull() {
            addCriterion("testtime is null");
            return (Criteria) this;
        }

        public Criteria andTesttimeIsNotNull() {
            addCriterion("testtime is not null");
            return (Criteria) this;
        }

        public Criteria andTesttimeEqualTo(Integer value) {
            addCriterion("testtime =", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeNotEqualTo(Integer value) {
            addCriterion("testtime <>", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeGreaterThan(Integer value) {
            addCriterion("testtime >", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("testtime >=", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeLessThan(Integer value) {
            addCriterion("testtime <", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeLessThanOrEqualTo(Integer value) {
            addCriterion("testtime <=", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeIn(List<Integer> values) {
            addCriterion("testtime in", values, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeNotIn(List<Integer> values) {
            addCriterion("testtime not in", values, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeBetween(Integer value1, Integer value2) {
            addCriterion("testtime between", value1, value2, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("testtime not between", value1, value2, "testtime");
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