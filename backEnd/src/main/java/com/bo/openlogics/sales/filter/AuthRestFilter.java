package com.bo.openlogics.sales.filter;


import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author flimachi
 */

// @WebFilter(filterName = "httpFilter",urlPatterns = {"/*"}/*,
// initParams = {
// @WebInitParam(name = "mood", value = "awake")}*/)
public class AuthRestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
            // CORS "pre-flight" request
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with, sid, mycustom, smuser");
            response.addHeader("Access-Control-Max-Age", "1800");//30 min
        }
        filterChain.doFilter(request, response);
    }
}
