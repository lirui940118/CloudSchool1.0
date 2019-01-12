package com.CloudSchool.service;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

public class imgcompressService {
	public static JSONObject ueEditorUpload(HttpServletRequest request) {
		String json="{[\"url\":\"http://xinrui.com/image/1.png\",\"state\":\"SUCCESS\"]}";
		return JSONObject.parseObject(json);
	}
}
