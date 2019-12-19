package com.cloud.yanger.commons.api.sms;

import com.cloud.yanger.commons.util.HttpClient;
import org.springframework.beans.factory.annotation.Value;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HBSMSApi {

    //用户名
    @Value("${config.sms.haobo.userName}")
    private String un;
    //密码
    @Value("${config.sms.haobo.password}")
    private String pw;
    //地址
    @Value("${config.sms.haobo.host}")
    private String url;

    /**
     * 发送验证码
     * @param phone
     * @param code
     * @return
     */
    public void sendVerificationCode(String phone,String code) {
        String content = "您的验证码是" + code + "，5分钟内有效。若非本人操作可忽略该信息。";
        this.sendMessage(phone, content);
    }

    /**
     * 发送短信息
     * @param phone 手机号 单一内容时群发  将手机号用;隔开
     * @param content 内容
     * @return
     */
    public String sendMessage(String phone,String content) {
        try {
            content = "【环球直聘】" + content;
            String sm = URLEncoder.encode(content, "utf8");
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("un", un);
            paramMap.put("pw", pw);
            paramMap.put("da", phone);//单一内容时群发  将手机号用;隔开
            paramMap.put("sm", sm);
            paramMap.put("dc", "15"); //dc 数据类型
            paramMap.put("rf", "2"); //rf 响应格式
            paramMap.put("rd", "1"); //rd 是否需要状态报告 1需要
            paramMap.put("tf", "3");//tf 短信内容的传输编码
            String param = "";
            if (paramMap != null && paramMap.size() > 0) {
                Iterator<String> ite = paramMap.keySet().iterator();
                while (ite.hasNext()) {
                    String key = ite.next();// key
                    Object value = paramMap.get(key);
                    param += key + "=" + value + "&";
                }
                param = param.substring(0, param.length() - 1);
            }
            String result = HttpClient.getInstance().postForString(url, param,
                    "accept", "*/*", "connection", "Keep-Alive", "user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)",
                    "Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            return result;
        } catch (Exception e) {
            System.err.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        return "";
    }
}
