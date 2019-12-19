package com.cloud.yanger.commons.model;

import lombok.Data;

@Data
public class PushMessage {
    private Integer model;//模式 ；1
    private String sevCId; //个推需要的cid
    private String title;//推送的标题
    private String content;//推送的主体内容
    private String iconUrl;//推送时显示的网络icon
    private Integer msgId;//消息Id，可用于覆盖消息
    private String intent;//透传内容
    private String goUrl;//link模式下，需要跳转的网址
}
