package com.app.activities.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilterConfiguration implements Filter {

	public CORSFilterConfiguration() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
		response.setHeader("Access-Control-Max-Age", "4200");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, x-auth-token, origin, content-type, accept");

		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			filterChain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Override
	public void destroy() {
	}
}