package com.cloud.yanger.commons.model;

import com.cloud.yanger.commons.constants.ResultCodeConstants;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ApiResult {
    private Integer code;
    private String msg;
    private Object data;

    public static ApiResult success() {
        return new ApiResult().setCode(ResultCodeConstants.SUCCESS_CODE).setMsg("成功");
    }

    public static ApiResult success(String msg) {
        return new ApiResult().setCode(ResultCodeConstants.SUCCESS_CODE).setMsg(msg);
    }

    public static ApiResult error() {
        return new ApiResult().setCode(ResultCodeConstants.ERROR_CODE).setMsg("失败");
    }

    public static ApiResult error(String msg) {
        return new ApiResult().setCode(ResultCodeConstants.ERROR_CODE).setMsg(msg);
    }

    public static ApiResult other(Integer code,String msg){
        return new ApiResult().setCode(code).setMsg(msg);
    }
}
