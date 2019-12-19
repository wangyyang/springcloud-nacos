package com.cloud.yanger.commons.api.wx.wechat;

import com.cloud.yanger.commons.model.JsCode2SessionResponse;
import com.cloud.yanger.commons.util.DateUtils;
import com.cloud.yanger.commons.util.HttpClient;
import com.cloud.yanger.commons.util.JSONUtils;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RefreshScope
public class WeChatApi {

    //小程序ID
    @Value("${wechat.miniapp.appid}")
    private String appId;
    //小程序的秘钥
    @Value("${wechat.miniapp.secret}")
    private String appSecret;
    //商户号
    @Value("${wechat.miniapp.mchid}")
    private String mchId;
    //商户号secret
    @Value("${wechat.miniapp.mchsecret}")
    private String mchSecret;

    //获取openID的json的接口
    private static final String WEB_ACCESS_TO_KEN_HTTPS = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    //获取菊花码生成access_token生成接口
    private static final String WX_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    //获取菊花码本人用的是B,传值(数量无限制）
    private static final String WX_CODE = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=%s";

    private String token;

    private Date expires = new Date();


    /**
     * 获取用户openid
     */
    public JsCode2SessionResponse getWebAccess(String code, Integer type) {
        String url = "";
        switch (type) {
            case 0:
                url = String.format(WeChatApi.WEB_ACCESS_TO_KEN_HTTPS, appId, appSecret, code);
                break;
        }
        String response = HttpClient.getInstance()
                .get(url, null);
        try {
            return JSONUtils.toObject(response, JsCode2SessionResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private synchronized String token() {
        if (new Date().getTime() < expires.getTime()) {
            return token;
        }
        String url = String.format(WX_ACCESS_TOKEN, appId, appSecret);
        String response = HttpClient.getInstance()
                .get(url, null);
        try {
            Map<String, Object> result = JSONUtils.toObject(response, Map.class);
            if (StringUtils.isNotBlank(result.get("access_token").toString())) {
                token = result.get("access_token").toString();
                expires = DateUtils.addSeconds(new Date(), Integer.parseInt(result.get("expires_in").toString()));
                return token;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取菊花码
     */
    public InputStream getQRCode(CreateQrCode cqc) {
        String url = String.format(WX_CODE, token());
        Map<String,Object> param = new HashMap<>();
        param.put("scene", cqc.getScene());
        param.put("page", cqc.getPage());
        param.put("width", cqc.getWidth());
        param.put("auto_color", false);
        Map<String,Object> line_color = new HashMap<>();
        line_color.put("r", 0);
        line_color.put("g", 0);
        line_color.put("b", 0);
        param.put("line_color", line_color);
        Response response = HttpClient.getInstance()
                .postForObject(url, param);
        InputStream inputStream  = response.body().byteStream();
        try {
            return inputStream;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
