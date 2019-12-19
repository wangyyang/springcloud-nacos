package com.cloud.yanger.commons.util;

import com.cloud.yanger.commons.model.IDCardOCRModel;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class IdCardUtils {

    private static final String IDCARD_HOST = "https://idcert.market.alicloudapi.com/idcard";

    private static final String OCR_HOST = "https://ocridcard.market.alicloudapi.com/idimages";

    /**
     * 实名认证
     */
    public static Map realName(String cardNo, String name,String idCardCode) {
        Map<String, String> params = new HashMap<>();
        params.put("idCard", cardNo);
        params.put("name", name);
        try {
            String body = HttpClient.getInstance().get(IDCARD_HOST, params, "Authorization", "APPCODE " + idCardCode);
            return JSONUtils.toObject(body, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * OCR识别
     */
    public static IDCardOCRModel ocrIdCard(String idCardImg, String aLiCloudAppCode, boolean positive) {
        String imgThumbnail = idCardImg + "?x-oss-process=image/resize,m_mfit,h_450,w_450";
        Map<String, String> params = new HashMap<>();
        params.put("image", imgThumbnail);
        if (positive)
            params.put("idCardSide", "front");
        else
            params.put("idCardSide", "back");
        try {
            String results = HttpClient.getInstance().post(OCR_HOST, params,
                    "Authorization", "APPCODE " + aLiCloudAppCode,"Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            if (StringUtils.isNotBlank(results)) {
                IDCardOCRModel ocr = JSONUtils.toObject(results, IDCardOCRModel.class);
                return ocr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
