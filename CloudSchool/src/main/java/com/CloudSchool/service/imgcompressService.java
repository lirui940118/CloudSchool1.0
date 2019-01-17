package com.CloudSchool.service;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

public class imgcompressService {
	public static JSONObject ueEditorUpload(HttpServletRequest request) {
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("url", "http://127.0.0.1:8080/static/image/1.png\",\"state\":\"SUCCESS");
		String json="{[\"url\":\"http://27.0.0.1:8080/static/image/1.png\",\"state\":\"SUCCESS\"]}";
		return JSONObject.parseObject(json);
	}
}
