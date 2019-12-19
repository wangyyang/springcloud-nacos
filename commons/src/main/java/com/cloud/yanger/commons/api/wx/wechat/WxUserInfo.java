package com.cloud.yanger.commons.api.wx.wechat;

import lombok.Data;

@Data
public class WxUserInfo {

    private String openId;
    private String nickName;
    private String gender;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private String unionId;
    private Watermark watermark;
    private String uid;
    private String userToken;
    private String phoneNumber;
    private String purePhoneNumber;
    private String countryCode;

    @Data
    public static class Watermark {
        private String timestamp;
        private String appid;

    }
}
