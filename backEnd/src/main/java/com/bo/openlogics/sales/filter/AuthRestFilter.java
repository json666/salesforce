package com.bo.openlogics.sales.filter;


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
public class AuthRestFilter implements Filter {


    public AuthRestFilter() { }

    public void init(FilterConfig fConfig) throws ServletException { }

    public void destroy() {	}

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        System.out.println("ENTRO FILTRO*********");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        /*if (request.getRequestURI().startsWith(request.getContextPath() + "/rest/uploadFiles")
                || request.getRequestURI().startsWith(request.getContextPath() + "/rest/login")
                || request.getRequestURI().startsWith(request.getContextPath() + "/rest/unidad_medida")
                || request.getRequestURI().startsWith(request.getContextPath() + "/rest/marca_producto")
                || request.getRequestURI().startsWith(request.getContextPath() + "/rest/categoria")
                || request.getRequestURI().startsWith(request.getContextPath() + "/rest/articulosHabilitados")){
            System.out.println("si existe*********");
            //((HttpServletResponse)response).addHeader(
            //        "Access-Control-Allow-Origin", "*"
            //);
            chain.doFilter(request, response);
        } else {
            //Status code (401) indicating that the request requires HTTP authentication.
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "usuario no autenticado");
            //response.sendRedirect("http://www.google.com");
            System.out.println("no se puede mostrar los datos no existe*********");

        }*/
        if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())//){
                ||request.getRequestURI().startsWith(request.getContextPath() + "/rest/uploadFiles")) {
            // CORS "pre-flight" request
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with, sid, mycustom, smuser");
            response.addHeader("Access-Control-Max-Age", "1800");//30 min
        }
        chain.doFilter(request, response);

        //chain.doFilter(request, response);
    }
}
