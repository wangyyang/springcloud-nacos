package com.cloud.yanger.commons.api.wx.wxpay;

import com.cloud.yanger.commons.exceptions.BusException;
import com.cloud.yanger.commons.util.EncryptUtils;
import com.cloud.yanger.commons.util.UUIDGeneratorUtils;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@Slf4j
public class WxpayApi {
    //APP
    @Value("${wechat.app.appid}")
    private String appId;
    @Value("${wechat.app.secret}")
    private String appSecret;
    //小程序
    @Value("${wechat.miniapp.appid}")
    private String miniAppId;
    @Value("${wechat.miniapp.secret}")
    private String miniSecret;
    //商户
    @Value("${wechat.miniapp.mchid}")
    private String mchId;
    @Value("${wechat.miniapp.mchsecret}")
    private String apiKey;
    @Value("${wechat.notifyUrl}")
    private String notifyUrl;
    private WXPayConfig appConfig;
    private WXPayConfig miniConfig;

    @PostConstruct
    public void init() {
        appConfig = new WxpayConfig(appId, mchId, apiKey);
        miniConfig = new WxpayConfig(miniAppId, mchId, apiKey);
    }

    private String getAppIdByType(int type) {
        switch (type) {
            case WxpayConstants.MINIAPP_TYPE: return miniAppId;
            case WxpayConstants.APP_TYPE: return appId;
        }
        throw new BusException("错误的类型");
    }

    private WXPayConfig getConfigByType(int type) {
        switch (type) {
            case WxpayConstants.MINIAPP_TYPE: return miniConfig;
            case WxpayConstants.APP_TYPE: return appConfig;
        }
        throw new BusException("错误的类型");
    }

    /**
     * 微信统一下单
     * @param tradeNo 订单号
     * @param totalFee 金额
     */
    public Map<String, String> unifiedOrder(int type, String tradeNo, int totalFee, String body, String ip, String tradeType, String openid) {
        SortedMap<String, String> params = new TreeMap<>();
        params.put("appid", getAppIdByType(type));
        params.put("mch_id", mchId);
        params.put("nonce_str", UUIDGeneratorUtils.get32UUID());
        params.put("body", body);
        params.put("out_trade_no", tradeNo);
        params.put("total_fee", String.valueOf(totalFee));
        params.put("spbill_create_ip", ip);
        params.put("notify_url", notifyUrl);
        params.put("trade_type", tradeType);
        if (type == 0)
            params.put("openid", openid);
        try {
            String sign = WXPayUtil.generateSignature(params, apiKey);
            params.put("sign", sign);
            WXPay wxPay = new WXPay(getConfigByType(type));
            log.debug("params:" + params);
            return wxPay.unifiedOrder(params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }


    /**
     * 微信提现到零钱
     * @param tradeNo 订单号
     * @param openId 商户appid下，某用户的openid
     * @param amount 金额
     * @param desc 备注
     */
    public boolean withdrawMoney(String tradeNo, int type, String openId, double amount, String desc, String ip) {
        String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
        SortedMap<String, String> params = new TreeMap<>();
        params.put("mch_appid", getAppIdByType(type));
        params.put("mchid", mchId);
        params.put("nonce_str", UUIDGeneratorUtils.get32UUID());
        params.put("partner_trade_no", tradeNo);
        params.put("openid", openId);
        params.put("check_name", "NO_CHECK");
        params.put("amount", String.valueOf((int) amount));
        params.put("desc", desc);
        params.put("spbill_create_ip", ip);
        try {
            String sign = WXPayUtil.generateSignature(params, apiKey);
            params.put("sign", sign);
            WXPayConfig wxPayConfig = getConfigByType(type);
            WXPay wxPay = new WXPay(wxPayConfig);
            log.debug("params: "+params);
            String respXml = wxPay.requestWithCert(url, params, wxPayConfig.getHttpConnectTimeoutMs(), wxPayConfig.getHttpConnectTimeoutMs());
            Map<String, String> result = WXPayUtil.xmlToMap(respXml);
            if ("SUCCESS".equals(result.get("return_code")) && "SUCCESS".equals(result.get("result_code"))) {
                return true;
            } else {
                log.error("微信提现失败：" + result);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 微信退款到原处
     * @param tradeNo 商家订单号
     * @param type 0 小程序 1 app
     * @param refundNo 退款订单号
     * @param refundAmount 退款金额
     * @param refundReason 退款原因
     */
    public boolean refund(String tradeNo, int type, String refundNo, String refundAmount, String refundReason) {
        String url = "https://api.mch.weixin.qq.com/secapi/pay/refund";
        SortedMap<String, String> params = new TreeMap<>();
        params.put("appid", getAppIdByType(type));
        params.put("mch_id", mchId);
        params.put("nonce_str", UUIDGeneratorUtils.get32UUID());
        params.put("out_trade_no", tradeNo);
        params.put("total_fee", refundAmount);
        params.put("refund_fee", refundAmount);
        params.put("out_refund_no", refundNo);
        params.put("refund_desc", refundReason);
        try {
            String sign = WXPayUtil.generateSignature(params, apiKey);
            params.put("sign", sign);
            WXPayConfig wxPayConfig = getConfigByType(type);
            WXPay wxPay = new WXPay(wxPayConfig);
            log.debug("params: "+params);
            String respXml = wxPay.requestWithCert(url, params, wxPayConfig.getHttpConnectTimeoutMs(), wxPayConfig.getHttpConnectTimeoutMs());
            Map<String, String> result = WXPayUtil.xmlToMap(respXml);
            if ("SUCCESS".equals(result.get("return_code")) && "SUCCESS".equals(result.get("result_code"))) {
                return true;
            } else {
                log.error("微信提现失败：" + result);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 调起支付页面需要的签名
     */
    public String paySign(String appId, String nonceStr, String prepayId, String timestamp) {
        String str = "appId=" + appId + "&nonceStr=" + nonceStr +
                "&package=prepay_id=" + prepayId +
                "&signType=MD5&timeStamp=" + timestamp +
                "&key=" + apiKey;
        return EncryptUtils.MD5(str);
    }

    public boolean signValid(Map<String, String> data) throws Exception {
        WXPay wxPay = new WXPay(new WxpayConfig(data.get("appid"), mchId, apiKey));
        return wxPay.isPayResultNotifySignatureValid(data);
    }

    public String getResult(boolean success) {
        if (success)
            return "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
        return "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[ERROR]]></return_msg></xml>";
    }

    public String sign(SortedMap<String, String> params) {
        try {
            return WXPayUtil.generateSignature(params, apiKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
