package com.cloud.yanger.commons.api.ue.upload;

import com.cloud.yanger.commons.api.ali.oss.OSSApi;
import com.cloud.yanger.commons.api.ue.define.State;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Uploader {
	private HttpServletRequest request = null;
	private Map<String, Object> conf = null;
	private OSSApi ossApi;

	public Uploader(HttpServletRequest request, Map<String, Object> conf, OSSApi ossApi) {
		this.request = request;
		this.conf = conf;
		this.ossApi = ossApi;
	}

	public final State doExec() {
		String filedName = (String) this.conf.get("fieldName");
		State state = null;

		if ("true".equals(this.conf.get("isBase64"))) {
			state = Base64Uploader.save(this.request.getParameter(filedName),
					this.conf);
		} else {
			state = OSSUploader.save(this.request, this.conf, ossApi);
		}

		return state;
	}
}
