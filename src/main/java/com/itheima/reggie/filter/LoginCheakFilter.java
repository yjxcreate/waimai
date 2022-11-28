package com.itheima.reggie.filter;


import com.alibaba.fastjson.JSON;
import com.itheima.reggie.common.BaseContext;
import com.itheima.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 检查啊用户是否登录
 */
@WebFilter(filterName = "loginCheakFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheakFilter implements Filter {
        //路径匹配器,支持通配符
    public  static  final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest  request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        //1.获取本次请求uri
        String requestURI = request.getRequestURI();

        log.info("z这次的请求：{}",requestURI);
        //2.判断本次请求是否需要处理
        String [] urls  = new String[]{
             "/employee/login",
             "/employee/logout",
             "/backend/**",
             "/front/**",
             "/common/**",
             "/user/sendMsg",
             "/user/login"
        };
        boolean check = check(urls, requestURI);
        //3.如果不需要处理，放行
        if (check){
            log.info("本次请求不需要处理：{}",requestURI);
            filterChain.doFilter(request,servletResponse);
            return;
        }
        //4.判断登录状态
        if(request.getSession().getAttribute("employee")!= null){
            log.info("用户已登录，用户id为：{}",request.getSession().getAttribute("employee"));

            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);

//            long id = Thread.currentThread().getId();
//            log.info("线程id为: {}",id);

            filterChain.doFilter(request,servletResponse);
            return;
        }
        //4-2.判断登录状态
        if(request.getSession().getAttribute("user")!= null){
            log.info("用户已登录，用户id为：{}",request.getSession().getAttribute("user"));

            Long uesrId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(uesrId);

//            long id = Thread.currentThread().getId();
//            log.info("线程id为: {}",id);

            filterChain.doFilter(request,servletResponse);
            return;
        }

        log.info("用户未登录");
        //5.如果没有登录则返回尾灯李结果，通过输出流方式向客户端页面响应数据
         response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;

//        log.info("拦截到请求：{}",request.getRequestURI());
//
//        filterChain.doFilter(request,servletResponse);
    }

    /***
     * 路径匹配，检查本次请求是否放行
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls ,String requestURI){
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match)
                return true;
        }
        return false;

    }
}
