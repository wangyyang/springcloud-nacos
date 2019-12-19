package com.cloud.yanger.commons.api.ue.upload;

import com.cloud.yanger.commons.api.ali.oss.OSSApi;
import com.cloud.yanger.commons.api.ue.define.AppInfo;
import com.cloud.yanger.commons.api.ue.define.BaseState;
import com.cloud.yanger.commons.api.ue.define.State;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

public class OSSUploader {

    public static State save(HttpServletRequest request,
                             Map<String, Object> conf, OSSApi ossApi) {
        boolean isAjaxUpload = request.getHeader("X_Requested_With") != null;


        if (!ServletFileUpload.isMultipartContent(request)) {
            return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
        }

        ServletFileUpload upload = new ServletFileUpload(
                new DiskFileItemFactory());

        if (isAjaxUpload) {
            upload.setHeaderEncoding("UTF-8");
        }

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession()
                .getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Iterator<String> it = multipartRequest.getFileNames();
            while (it.hasNext()) {
                MultipartFile file = multipartRequest.getFile(it.next());
                if (file != null) {
                    State storageState;
                    String originalFilename = file.getOriginalFilename();
                    String s = originalFilename.substring(originalFilename.lastIndexOf("."));
                    String fileName = conf.get("filePath").toString() + "/" + System.currentTimeMillis()+s;
                    InputStream is;
                    try {
                        is = file.getInputStream();
                        ossApi.putObject(fileName, is, file.getSize());
                        String url = conf.get("fileUrl") + "/" + fileName;
                        storageState = new BaseState(true);
                        storageState.putInfo("state", "SUCCESS");// UEDITOR的规则:不为SUCCESS则显示state的内容
                        //注意：下面的url是返回到前端访问文件的路径，请自行修改
                        storageState.putInfo("url", url);
                        storageState.putInfo("title", fileName);
                        storageState.putInfo("original", fileName);
                        return storageState;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return new BaseState(false, AppInfo.IO_ERROR);
    }
}
