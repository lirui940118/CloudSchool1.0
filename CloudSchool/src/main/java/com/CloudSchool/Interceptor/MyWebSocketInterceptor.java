package com.CloudSchool.Interceptor;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import com.CloudSchool.domain.CqjUser;

public class MyWebSocketInterceptor implements HandshakeInterceptor {

	/**
	 * 定义用于注册在websocket中的规则
	 */
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		/**
		 * 将用户的编号作为唯一标识，用于区分哪个用户与用户之间通信
		 */
		ServletServerHttpRequest servletRequest = (ServletServerHttpRequest)request;
		HttpSession session = servletRequest.getServletRequest().getSession();
		CqjUser u = (CqjUser)session.getAttribute("user");
		System.out.println("进入intercepter:"+u.getUserid());
		if(session.getAttribute("user")!=null) {
			int uid = u.getUserid();
			attributes.put("uid", uid);
			return true;
		}
		return false;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		
	}



}
