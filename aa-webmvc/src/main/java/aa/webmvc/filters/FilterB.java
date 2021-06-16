package aa.webmvc.filters;

import javax.servlet.*;
import java.io.IOException;

public class FilterB implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filterB init ...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filterB doFilter ...");
		// 转交给下一个过滤器
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("filterB init ...");
	}
}
