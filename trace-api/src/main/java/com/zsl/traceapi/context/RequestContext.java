package com.zsl.traceapi.context;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestContext {

	/**
	 * 请求对象
	 */
	private HttpServletRequest request;

	/**
	 * 响应对象
	 */
	private HttpServletResponse response;

	/**
	 * jsonObject
	 */
	private JSONObject jsonObject;

	public RequestContext(HttpServletRequest request,HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	
	
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
}

