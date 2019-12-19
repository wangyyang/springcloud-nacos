package com.cloud.yanger.commons.api.ali.oss;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RefreshScope
public class OSSApi {
    @Value("${config.ossServiceEndpoint}")
    private String endpoint;
    @Value("${config.ossServiceAccessKey}")
    private String accesskey;
    @Value("${config.ossServiceAccesskeySecret}")
    private String secret;
    @Value("${config.ossResBucketName}")
    private String bucketName;

    public boolean putObject( String filename, InputStream is, long length) {
        //客户端使用使用url签名字串发送请求
        OSS client = new OSSClientBuilder().build(endpoint, accesskey, secret);
        Date expiration = new Date(new Date().getTime() + 3600 * 1000);
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, filename, HttpMethod.PUT);
        //设置过期时间
        request.setExpiration(expiration);
        //设置Content-Type
        request.setContentType("application/octet-stream");
        // 添加user meta
        request.addUserMetadata("author", "zwkj");
        // 生成URL签名(HTTP PUT请求)
        URL signedUrl = client.generatePresignedUrl(request);
        // 添加PutObject请求头
        Map<String, String> customHeaders = new HashMap<>();
        customHeaders.put("Content-Type", "application/octet-stream");
        // 添加user meta
        customHeaders.put("x-oss-meta-author", "zwkj");
        PutObjectResult result = client.putObject(signedUrl, is, length, customHeaders);
        client.shutdown();
        return result != null && StringUtils.isNotBlank(result.getETag());
    }
}
