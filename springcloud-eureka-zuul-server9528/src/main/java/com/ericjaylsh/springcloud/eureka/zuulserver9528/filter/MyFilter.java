package com.ericjaylsh.springcloud.eureka.zuulserver9528.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @Description :
 * @Author: EricJayLsh
 * @Date 2021/1/6 21:16
 */
@Component
public class MyFilter extends ZuulFilter {

    // 返回过滤器类型 这里是前置过滤器
    @Override
    public String filterType() {

       /* pre：路由之前
        routing：路由之时
        post： 路由之后
        error：发送错误调用
        filterOrder：过滤的顺序
        shouldFilter：这里可以写逻辑判断，是否要开启过滤
        run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。*/
        return FilterConstants.PRE_TYPE;
    }


    // 指定过滤顺序 越小越先执行，这里第一个执行
    // 当然不是只真正第一个 在Zuul内置中有其他过滤器会先执行
    // 那是写死的 比如 SERVLET_DETECTION_FILTER_ORDER = -3
    @Override
    public int filterOrder() {
        return 0;
    }


    // 什么时候该进行过滤
    // 这里我们可以进行一些判断，这样我们就可以过滤掉一些不符合规定的请求等等
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /**
     * 描述:  如果过滤器允许通过则怎么进行处理
     * @param
     * @author EricJayLsh
     * @date 2021/1/6 22:57
     */
    @Override
    public Object run() throws ZuulException {
        // 这里我设置了全局的RequestContext并记录了请求开始时间
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set("startTime", System.currentTimeMillis());
        return null;
    }
}
