package com.CloudSchool.Interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.CloudSchool.domain.CqjModule;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.service.CqjMoudelService;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	CqjMoudelService cms;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*String requestURI=request.getRequestURI();  
		System.out.println("requestURI:"+requestURI+"<br>");  
		HttpSession session = request.getSession();
		CqjUser user=(CqjUser)session.getAttribute("user");
		Boolean isE=false;
		if(user==null) {
            response.sendRedirect("/user/goLogin");
			return false;
		}
		List<CqjModule> mlist=cms.queryByRoleidandPositionid(user.getRoleid(),user.getPositionid());
		for (CqjModule m : mlist) {
			if(m.getModuleurl()!=null) {
				if(m.getModuleurl().equals(requestURI)) {
					isE=true;
				}
			}
		}
		if(!isE) {
			response.getWriter().println("404");
			return false;
		}*/
		return true;
	}
}
