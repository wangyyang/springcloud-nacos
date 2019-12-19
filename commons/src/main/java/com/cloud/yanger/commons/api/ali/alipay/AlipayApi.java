package com.cloud.yanger.commons.api.ali.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.cloud.yanger.commons.exceptions.BusException;
import com.cloud.yanger.commons.util.JSONUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.Map;

@Data
@Slf4j
public class AlipayApi {

    //支付宝APPID
    @Value("${config.aliPay.appId}")
    private String appid;
    //privateKey
    @Value("${config.aliPay.privateKey}")
    private String privateKey;
    //publicKey
    @Value("${config.aliPay.publicKey}")
    private String publicKey;
    @Value("${config.aliPay.notifyUrl}")
    private String notifyUrl;

    private CertAlipayRequest certAlipayRequest;

    @PostConstruct
    void init() {
        certAlipayRequest = new CertAlipayRequest();
        //设置网关地址
        certAlipayRequest.setServerUrl(SERVER_URL);
        //设置应用Id
        certAlipayRequest.setAppId(appid);
        //设置应用私钥
        certAlipayRequest.setPrivateKey(privateKey);
        //设置请求格式，固定值json
        certAlipayRequest.setFormat("json");
        //设置字符集
        certAlipayRequest.setCharset("UTF-8");
        //设置签名类型
        certAlipayRequest.setSignType("RSA2");
        //设置应用公钥证书路径
        certAlipayRequest.setCertPath(CERT_PATH);
        //设置支付宝公钥证书路径
        certAlipayRequest.setAlipayPublicCertPath(ALIPAY_PUBLIC_CERT_PATH);
        //设置支付宝根证书路径
        certAlipayRequest.setRootCertPath(ROOT_CERT_PATH);
    }

    //支付链接
    private static final String SERVER_URL = "https://openapi.alipay.com/gateway.do";
    private static final String CERT_PATH = "/mnt/configurations/certificate/appCertPublicKey_2019111169046517.crt";
    private static final String ALIPAY_PUBLIC_CERT_PATH = "/mnt/configurations/certificate/alipayCertPublicKey_RSA2.crt";
    private static final String ROOT_CERT_PATH = "/mnt/configurations/certificate/alipayRootCert.crt";
    /**
     * 支付宝页面支付
     * @param tradeNo 订单号
     * @param totalAmount 金额
     */
    public String tradePagePay(String tradeNo, double totalAmount, String subject, String returnUrl,String fqNum) {
        AlipayClient alipayClient = new DefaultAlipayClient(SERVER_URL, appid, privateKey, "json", "UTF-8", publicKey, "RSA2");
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setBizContent("{\"out_trade_no\":\"" + tradeNo + "\"," + "\"total_amount\":\"" + totalAmount + "\","
                + "\"subject\":\"" + subject + "\"," + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"" +
                "\"extend_params\":{" +
                "\"hb_fq_num\":\"" + fqNum + "\"," +
                "\"hb_fq_seller_percent\":\"100\"," +
                "\"card_type\":\"S0JP0000\"" +
                "    }" +
                "}");
        request.setReturnUrl(returnUrl);
        request.setNotifyUrl(notifyUrl);
        try {
            AlipayTradePagePayResponse response = alipayClient.pageExecute(request);
            if (response.isSuccess()) {
                return response.getBody();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 支付宝提现
     * @param type 0 user 1 logonid
     * @param payeeAccount 支付宝账号或登录号
     * @param tradeNo 交易订单号
     * @param amount 金额
     */
    public boolean withdrawMoney(int type, String payeeAccount,String tradeNo,Double amount) {
        try {
            AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
            AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
            String payeeType = type == 1 ? "ALIPAY_LOGONID" : "ALIPAY_USERID";
            request.setBizContent("{" +
                    "\"out_biz_no\":\"" + tradeNo + "\"," +
                    "\"payee_type\":\"" + payeeType + "\"," +
                    "\"payee_account\":\"" + payeeAccount + "\"," +
                    "\"amount\":\"" + amount + "\"," +
                    "\"payer_show_name\":\"智沃科技\"," +
                    "\"remark\":\"提现\"" +
                    "}");
            AlipayFundTransToaccountTransferResponse response = alipayClient.certificateExecute(request);
            if (response.isSuccess())
                return true;
            throw new BusException(JSONUtils.toJson(response));
        } catch (AlipayApiException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    public boolean rsaCheckV1(Map<String, String> params) {
        try {
            return AlipaySignature.rsaCheckV1(params, publicKey, "UTF-8", "RSA2");
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 支付宝App下单
     * @param tradeNo 商户订单号
     * @param totalAmount 金额
     * @param subject 主题
     * @param hbFqNum 花呗
     */
    public String tradeAppPay(String tradeNo, double totalAmount, String subject,String hbFqNum) {
        try {
            //实例化客户端
            AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
            //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
            AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
            //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
            model.setOutTradeNo(tradeNo);
            model.setTimeoutExpress("30m");
            model.setTotalAmount("" + totalAmount);
            model.setProductCode("QUICK_MSECURITY_PAY");
            model.setSubject(subject);
            if (StringUtils.isNotBlank(hbFqNum)) {
                ExtendParams params = new ExtendParams();
                params.setHbFqNum(hbFqNum);
                params.setHbFqSellerPercent("100");
                model.setExtendParams(params);
            }
            request.setBizModel(model);
            request.setNotifyUrl(notifyUrl);
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            //就是orderString 可以直接给客户端请求，无需再做处理。
            return response.getBody();
        } catch (AlipayApiException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 支付宝退款
     * @param tradeNo 商户订单号
     * @param refundAmount 退款金额
     * @param refundReason 退款原因
     */
    public boolean refund(String tradeNo, double refundAmount, String refundReason) {
        try {
            AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
            AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
            AlipayTradeRefundModel model = new AlipayTradeRefundModel();
            model.setOutTradeNo(tradeNo);
            model.setRefundAmount(""+refundAmount);
            model.setRefundReason(refundReason);
            request.setBizModel(model);
            AlipayTradeRefundResponse response = alipayClient.certificateExecute(request);
            if (response.isSuccess())
                return true;
            throw new BusException(JSONUtils.toJson(response));
        } catch (AlipayApiException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }
}
