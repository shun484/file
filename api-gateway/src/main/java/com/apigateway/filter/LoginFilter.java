package com.apigateway.filter;

import com.apigateway.utils.TokenUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 过滤器类型  前置过滤器
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤器越小，优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 4;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {

        RequestContext currentContext = RequestContext.getCurrentContext();

        HttpServletRequest request = currentContext.getRequest();

        // true拦截   false不拦截
        if("/login/index".equalsIgnoreCase(request.getRequestURI())) {
            return false;
        }
        return true;
    }

    /**
     * 业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();

        HttpServletRequest request = requestContext.getRequest();

        // 获取token
        String token = request.getHeader("token");

        if (StringUtils.isEmpty((token))){
           token =  request.getParameter("token");
        }
        // 效验token是否存在
        if (StringUtils.isEmpty(token)) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        }

        // 效验token
        try{
            if (!TokenUtil.verifyJWT(token)) {
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            }
        }catch (Exception e){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        }
        return null;
    }
}
