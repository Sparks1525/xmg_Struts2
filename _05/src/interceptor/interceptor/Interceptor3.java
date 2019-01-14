package interceptor.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import java.util.Set;

/**
 * 方式3:直接继承于com.opensymphony.xwork2.interceptor.MethodFilterInterceptor.
 */
public class Interceptor3 extends MethodFilterInterceptor {
    @Override
    public void setExcludeMethods(String excludeMethods) {
        super.setExcludeMethods(excludeMethods);
    }

    @Override
    public Set<String> getExcludeMethodsSet() {
        return super.getExcludeMethodsSet();
    }

    @Override
    public void setIncludeMethods(String includeMethods) {
        super.setIncludeMethods(includeMethods);
    }

    @Override
    public Set<String> getIncludeMethodsSet() {
        return super.getIncludeMethodsSet();
    }

    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {



        return null;
    }
}
