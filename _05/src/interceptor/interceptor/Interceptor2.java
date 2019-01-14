package interceptor.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 方式2:直接继承于com.opensymphony.xwork2.interceptor.AbstractInterceptor(用的多).
 */
public class Interceptor2 extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        return null;
    }
}
