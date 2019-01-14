package interceptor.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Arrays;
import java.util.List;

public class LoginInterceptor extends AbstractInterceptor {

    private List<String> excludeActionNames;

    public void setExcludeActionNames(String excludeActionNames){
        System.out.println(excludeActionNames);
        this.excludeActionNames = Arrays.asList(excludeActionNames
                .split(","));
    }

    public void setLoginInterceptorTest(String loginInterceptorTest){
        System.out.println(loginInterceptorTest);
    }


    @Override
    public String intercept(ActionInvocation invocation) throws Exception {


        String actionName = invocation.getProxy().getActionName();
        System.out.println("拦截......" + actionName);


        //检查session中是否有USER_IN_SESSION,如果有则放行,没有,跳转到登陆页面
        //如果当前名称为login时,应该放行
        Object user = invocation.getInvocationContext()
                .getSession().get("USER_IN_SESSION");
        if (user != null || this.excludeActionNames.contains(actionName)) {
           return invocation.invoke(); //放行
        }
        return Action.LOGIN;
    }
}
