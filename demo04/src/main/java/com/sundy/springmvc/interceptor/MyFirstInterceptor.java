package com.sundy.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 自定义拦截器
 */
//@Component
public class MyFirstInterceptor implements HandlerInterceptor {
    /**
     * 1. 是在DispatcherServlet的939行   在请求处理方法之前执行
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("MyFirstInterceptor  preHandle");
        return true;
    }
    /**
     * 2. 在DispatcherServlet 959行   请求处理方法之后，视图处理之前执行。
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("MyFirstInterceptor postHandle");
    }
    /**
     * 3.
     * 	 [1].在DispatcherServlet的 1030行   视图处理之后执行.(转发/重定向后执行)
     * 	 [2].当某个拦截器的preHandle返回false后，也会执行当前拦截器之前拦截器的afterCompletion
     *   [3].
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("MyFirstInterceptor afterCompletion");
    }

}

