package com.cloud.yanger.orders.model;

import lombok.Data;

import java.util.Date;

@Data
public class QueryStat {

    private int pageNum=1; //页数
    private int pageSize=10; //条数
    private Boolean sort = true;//排序 false：正序，true：倒序
    private String sortField;//排序字段 如：时间、年龄等

    private Integer id;
    private Integer userId;
    private Integer facUserId;
    private Integer jobId;
    private Integer facId;
    private Integer orderId;
    private Integer targetId;
    private Integer status; //状态
    private Integer type; //类别
    private Integer userType; //用户类别 0用户1企业
    private String searchType;//搜索选项
    private String search;//搜索内容
    private String startTime, endTime;//提交时间
    private Integer startWorkExp,endWorkExp;//工作经验

    private String visaType;
    private Integer education;
    private Integer region;//地区
    private Integer positionSecond;
    private Integer positionThird;
    private Integer wageMin;//最低薪资
    private Integer wageMax;//最高薪资
    private String matchType;//匹配类型
    private String matchPositionThird;//匹配职位类型
    private String matchCountries;//国家
    private Integer languageId;//语言id
    private Integer abilityGradeId;//语言能力等级id

    private String orderNumber;//订单号
    private Integer several;//计数 几次
    private String uploadImages;
    private Date date;

    private Integer jobSeekStatus;
    private String from, to;
    private Integer busType;
    private String imUserId, imFacId;
}
