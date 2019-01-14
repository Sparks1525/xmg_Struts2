package login;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("登陆用户:"+user);
        ActionContext.getContext().getSession().put("USER_IN_SESSION",user);
        return SUCCESS;
    }
}
