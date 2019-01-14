package interceptor.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


/**
 * 方式1:直接实现于com.opensymphony.xwork2.interceptor.Interceptor接口(太弱了).
 */
public class Interceptor1 implements Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        return null;
    }
}
