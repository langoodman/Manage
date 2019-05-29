package com.ctgu.lan.manage.aop;

import com.ctgu.lan.manage.model.Admin;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-05-29 17:09
 * @ClassName AdminInterceptor
 * @Version 1.0.0
 */
@Component
@Slf4j
public class AdminInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(StaticInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        logger.info(request.getRequestURI());
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        if( admin == null ){
            response.sendRedirect("/");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println(request.getContextPath());
//        request.setAttribute("pwd",request.getContextPath());
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
