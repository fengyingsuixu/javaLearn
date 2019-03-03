package com.lyh.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
 pre：路由之前
 routing：路由之时
 post： 路由之后
 error：发送错误调用
 filterOrder：过滤的顺序
 shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
 run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
 * Created by lvyanghui
 * 2019/3/3 13:51
 */
@Component
public class AuthFilter extends ZuulFilter{
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        System.out.println("方法" + request.getMethod() + "请求地址" + request.getRequestURI());
        String token = request.getParameter("token");
        if(null == token){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);

            try {
                context.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {

            }
        }
        return null;
    }
}
