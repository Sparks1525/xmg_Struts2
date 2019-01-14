package interceptor.login;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import interceptor.domain.UserInfo;


public class LoginAction extends ActionSupport {
    private static final Long serialVersionUID = 1L;

    private UserInfo user;

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {

        System.out.println("登陆对象:"+user);
        //把数据存放到session作用域
        ActionContext.getContext().getSession().put("USER_IN_SESSION",user);

        return SUCCESS;
    }



}
