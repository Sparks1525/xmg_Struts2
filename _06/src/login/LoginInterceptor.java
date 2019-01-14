package login;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Arrays;
import java.util.List;

public class LoginInterceptor extends AbstractInterceptor {

    private String excludeActionNames;

    public void setExcludeActionNames(String excludeActionNames) {
        this.excludeActionNames = excludeActionNames;
        System.out.println(excludeActionNames);
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

        String actionName = actionInvocation.getProxy().getActionName();
        Object user = actionInvocation.getInvocationContext().getSession().get("USER_IN_SESSION");


        List<String> excNames = Arrays.asList(excludeActionNames.split(","));

        System.out.println("actionName:" + actionName);

        if(user != null || excNames.contains(actionName)){
            actionInvocation.invoke();
        }
        return Action.LOGIN;
    }
}
