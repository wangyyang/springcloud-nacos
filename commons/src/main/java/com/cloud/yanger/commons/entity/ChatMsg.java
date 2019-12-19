package com.cloud.yanger.commons.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "chat_msg")
public class ChatMsg {
    private String attach;
    private String body;
    private String convType;
    private String eventType;
    private String fromAccount;
    private String fromClientType;
    private String fromDeviceId;
    private String fromNick;
    private String msgTimestamp;
    private String msgType;
    private String msgidClient;
    private String msgidServer;
    private String resendFlag;
    private String to;
}
