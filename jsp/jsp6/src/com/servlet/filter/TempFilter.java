package com.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TempFilter implements Filter {
@Override
public void init(FilterConfig arg0) throws ServletException {
	System.out.println("--filter init()--");
}
@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
throws IOException, ServletException {
	System.out.println("--filter doFilter()--");
	
	//request filter
	req.setCharacterEncoding("UTF-8");
	chain.doFilter(req, res);
	
	//response filter
	
}
@Override
public void destroy() {
	System.out.println("--filter destroy()--");
}
}
