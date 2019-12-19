package com.cloud.yanger.commons.model;

import lombok.Data;

@Data
public class IDCardOCRModel {
    private String code;
    private String msg;
    private Details result;

    @Data
    public static class Details {
        //正面信息
        private String address;
        private String birthday;
        private String name;
        private String code;
        private String sex;
        private String nation;
        //反面信息
        private String issue;/* 签发机关 */
        private String issueDate; /* 签发日期 */
        private String expiryDate; /* 失效日期 */
    }
}
