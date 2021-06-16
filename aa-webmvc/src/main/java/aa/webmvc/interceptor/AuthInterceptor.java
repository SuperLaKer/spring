package aa.webmvc.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (!ObjectUtils.isEmpty(request.getSession().getAttribute("username"))) {
			return true;
		}
		print(response, "您没有权限访问！请先登录.");
		return false;
	}

	private void print(HttpServletResponse response, String message) throws Exception {
		response.setHeader("Content-Type", "application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(message);
	}
}
