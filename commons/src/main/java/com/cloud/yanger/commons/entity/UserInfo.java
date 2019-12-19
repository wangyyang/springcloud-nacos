package com.cloud.yanger.commons.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName = "user_request_info")
public class UserInfo {
    private String ipAddress; //IP地址
    private Integer remotePort;//客户端端口
    private String userId;//访问者id
    private String userHost;//客户端的主机名
    private String userAgent;
    private String remoteUser;
    private String version;
    private Date createTime;
}
