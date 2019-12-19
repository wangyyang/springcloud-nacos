package com.cloud.yanger.commons.api.nim;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;

/**
 * 云信基础API
 */
@Slf4j
public class NimApi {
    //云信APPKEY
    @Value("${config.im.appKey}")
    private String appKey;
    //APPSecret
    @Value("${config.im.appSecret}")
    private String appSecret;

    private static RestTemplate restTemplate = new RestTemplate();

    //创建账号URL
    private static final String CREATE_URL = "https://api.netease.im/nimserver/user/create.action";
    //更新账号URL
    private static final String UPDATE_URL = "https://api.netease.im/nimserver/user/update.action";
    //更新并获取新token
    private static final String REFRESH_TOKEN_URL = "https://api.netease.im/nimserver/user/refreshToken.action";
    //发送消息
    private static final String SEND_MSG_URL = "https://api.netease.im/nimserver/msg/sendMsg.action";
    //更新并获取新token
    private static final String GET_UINFOS_URL = "https://api.netease.im/nimserver/user/getUinfos.action";
    //更新用户基本信息
    private static final String UPDATE_UINFO_URL = "https://api.netease.im/nimserver/user/updateUinfo.action";
    //批量发送点对点自定义系统通知
    private static final String SEND_BATCH_MSG_URL = "https://api.netease.im/nimserver/msg/sendBatchAttachMsg.action";
    //创建好友关系
    private static final String CREATE_BUDDY_URL = "https://api.netease.im/nimserver/friend/add.action";

    /**
     * 创建云信账号
     */
    public Map create(String accid, String token,String name,String icon) {
        String nonce = RandomStringUtils.randomNumeric(10);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);//参考 计算CheckSum的java代码

        HttpHeaders headers = new HttpHeaders();
        headers.add("AppKey", appKey);
        headers.add("Nonce", nonce);
        headers.add("CurTime", curTime);
        headers.add("CheckSum", checkSum);
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("accid", accid);
        postParameters.add("token", token);
        if (StringUtils.isNotBlank(name)) {
            postParameters.add("name", name);
        }else {
            postParameters.add("name", "直聘学员");
        }
        if (StringUtils.isNotBlank(icon)) {
            postParameters.add("icon", icon);
        }
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(postParameters, headers);

        Map result = null;
        try {
            result = restTemplate.postForObject(CREATE_URL, requestEntity, Map.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 网易云通信ID更新
     */
    public Map update(String accid, String token) {
        String nonce = RandomStringUtils.randomNumeric(10);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);//参考 计算CheckSum的java代码

        HttpHeaders headers = new HttpHeaders();
        headers.add("AppKey", appKey);
        headers.add("Nonce", nonce);
        headers.add("CurTime", curTime);
        headers.add("CheckSum", checkSum);
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("accid", accid);
        if (StringUtils.isNotBlank(token)) {
            postParameters.add("token", token);
        }
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(postParameters, headers);

        Map result = null;
        try {
            result = restTemplate.postForObject(UPDATE_URL, requestEntity, Map.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新并获取新token
     *
     * @param accid 云信账号
     */
    public Map refreshToken(String accid) {
        String nonce = RandomStringUtils.randomNumeric(10);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);//参考 计算CheckSum的java代码

        HttpHeaders headers = new HttpHeaders();
        headers.add("AppKey", appKey);
        headers.add("Nonce", nonce);
        headers.add("CurTime", curTime);
        headers.add("CheckSum", checkSum);
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("accid", accid);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(postParameters, headers);

        Map result = null;
        try {
            result = restTemplate.postForObject(REFRESH_TOKEN_URL, requestEntity, Map.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发消息 默认点对点文本消息
     *
     * @param from    消息发送账户
     * @param to      消息接收账户
     * @param message 消息
     */
    public Map sendMesage(String from, String to, String message) {
        String nonce = RandomStringUtils.randomNumeric(10);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);//参考 计算CheckSum的java代码

        HttpHeaders headers = new HttpHeaders();
        headers.add("AppKey", appKey);
        headers.add("Nonce", nonce);
        headers.add("CurTime", curTime);
        headers.add("CheckSum", checkSum);
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("from", from);
        postParameters.add("ope", "0");//0：点对点个人消息，1：群消息（高级群）
        postParameters.add("to", to);
        postParameters.add("type", "0");//0 表示文本消息,1 表示图片，2 表示语音，3 表示视频，4 表示地理位置信息，6 表示文件
        postParameters.add("body", "{\"msg\":\"" + message + "\"}");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(postParameters, headers);

        Map result = null;
        try {
            result = restTemplate.postForObject(SEND_MSG_URL, requestEntity, Map.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 批量发消息 默认点对点文本消息
     *
     * @param fromAccid 消息发送账户
     * @param toAccids  消息接收账户
     * @param message   消息
     */
    public Map sendBatchMsg(String fromAccid, String[] toAccids, String message) {
        String nonce = RandomStringUtils.randomNumeric(10);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);//参考 计算CheckSum的java代码

        HttpHeaders headers = new HttpHeaders();
        headers.add("AppKey", appKey);
        headers.add("Nonce", nonce);
        headers.add("CurTime", curTime);
        headers.add("CheckSum", checkSum);
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<String, Object>();
        postParameters.add("fromAccid", fromAccid);
        postParameters.add("ope", "0");//0：点对点个人消息，1：群消息（高级群）
        postParameters.add("toAccids", toAccids);//['aaa','bbb']（JSONArray对应的accid，如果解析出错，会报414错误），最大限500人
        postParameters.add("type", "0");//0 表示文本消息,1 表示图片，2 表示语音，3 表示视频，4 表示地理位置信息，6 表示文件
        postParameters.add("body", "{\"msg\":\"" + message + "\"}");
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(postParameters, headers);

        Map result = null;
        try {
            result = restTemplate.postForObject(SEND_BATCH_MSG_URL, requestEntity, Map.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取云信信息
     *
     * @param accid 云信账号
     */
    public Map getUinfos(String accid) {
        String nonce = RandomStringUtils.randomNumeric(10);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);//参考 计算CheckSum的java代码
        HttpHeaders headers = new HttpHeaders();
        headers.add("AppKey", appKey);
        headers.add("Nonce", nonce);
        headers.add("CurTime", curTime);
        headers.add("CheckSum", checkSum);
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("accids", "['" + accid + "']");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(postParameters, headers);
        Map result = null;
        try {
            result = restTemplate.postForObject(GET_UINFOS_URL, requestEntity, Map.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新云信用户基本信息
     *
     * @param accid 云信账号
     * @param name  姓名
     * @param icon  头像
     */
    public Map updateUinfo(String accid, String name, String icon) {
        String nonce = RandomStringUtils.randomNumeric(10);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);//参考 计算CheckSum的java代码

        HttpHeaders headers = new HttpHeaders();
        headers.add("AppKey", appKey);
        headers.add("Nonce", nonce);
        headers.add("CurTime", curTime);
        headers.add("CheckSum", checkSum);
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("accid", accid);
        postParameters.add("name", name);
        if (StringUtils.isNotBlank(icon)) {
            postParameters.add("icon", icon);
        }
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(postParameters, headers);

        Map result = null;
        try {
            result = restTemplate.postForObject(UPDATE_UINFO_URL, requestEntity, Map.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 创建好友关系
     *
     * @param accid 加好友发起者accid
     * @param faccid  加好友接收者accid
     * @param type  1直接加好友，2请求加好友，3同意加好友，4拒绝加好友
     */
    public Map createBuddy(String accid, String faccid, Integer type) {
        String nonce = RandomStringUtils.randomNumeric(10);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);//参考 计算CheckSum的java代码

        HttpHeaders headers = new HttpHeaders();
        headers.add("AppKey", appKey);
        headers.add("Nonce", nonce);
        headers.add("CurTime", curTime);
        headers.add("CheckSum", checkSum);
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("accid", accid);
        postParameters.add("faccid", faccid);
        postParameters.add("type", type.toString());

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(postParameters, headers);

        Map result = null;
        try {
            result = restTemplate.postForObject(CREATE_BUDDY_URL, requestEntity, Map.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getVerifyChecksum(String body, String curTime) {
        String verifyMD5 = CheckSumBuilder.getMD5(body);
        String verifyChecksum = CheckSumBuilder.getCheckSum(appSecret, verifyMD5, curTime);
        log.debug("verifyMD5 = {}, verifyChecksum = {}", verifyMD5, verifyChecksum);
        return verifyChecksum;
    }

}
