package com.cloud.yanger.commons.api.wx.wxpay;


import com.github.wxpay.sdk.WXPayConfig;

import java.io.*;

public class WxpayConfig implements WXPayConfig {

    private byte[] certData = null;
    private String appId;
    private String mchId;
    private String secret;

    {
        File file = new File(WxpayConstants.CERT_PATH);
        try {
            InputStream certStream = new FileInputStream(file);
            certData = new byte[(int) file.length()];
            certStream.read(certData);
            certStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WxpayConfig(String appId, String mchId, String secret) {
        this.appId = appId;
        this.mchId = mchId;
        this.secret = secret;
    }

    @Override
    public String getAppID() {
        return appId;
    }

    @Override
    public String getMchID() {
        return mchId;
    }

    @Override
    public String getKey() {
        return secret;
    }

    @Override
    public InputStream getCertStream() {
        return new ByteArrayInputStream(certData);
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 2000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }
}
