package com.cloud.yanger.commons.cors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessCtlUtils {

    public static void accessCtl(HttpServletRequest req, HttpServletResponse res) {
        res.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,OPTIONS,DELETE");
        res.setHeader("Access-Control-Allow-Headers", "content-type,token,userId,userName,version");
        res.setHeader("Access-Control-Expose-Headers", "*");
    }
}
