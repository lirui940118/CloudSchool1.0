package com.CloudSchool.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.servlet.HandlerInterceptor;

import com.CloudSchool.domain.CqjUser;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//ServletServerHttpRequest servletRequest = (ServletServerHttpRequest)request;
		//HttpSession session = servletRequest.getServletRequest().getSession();

		/*HttpSession session = request.getSession();
		CqjUser user=(CqjUser)session.getAttribute("user");
		System.out.println(0);
		if(user==null) {
			System.out.println(1);
            response.sendRedirect("/user/goLogin");
			return false;
		}
		System.out.println(2);*/
		return true;
	}
}
