package com.cloud.yanger.commons.entity.es;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "statistics_everyday_login")
public class EverydayLogin {

    private Integer userId;//用户id
    private Integer clientType;//客户端类型：0=PC，1=国际版小程序，2=Android，3=iOS
    private Long loginTime;//登录时间
}
