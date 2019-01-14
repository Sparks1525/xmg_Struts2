package paramAndScope.parameter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import paramAndScope.domain.User;


/**
 * 2.创建独立Model对象，页面通过OGNL表达式封装(属性注入).
 *
 * 此时的方式:
 * 优点:把多个参数信息封装到对象,很容易.
 * 缺点:JSP中,表单的参数名称,变得美工看不懂了.
 */
public class Parameter2 extends ActionSupport {

    private User user;

    /**
     * 通过getUser()获得user对象  若没有new UserInfo() 则通过setUser()创建user对象
     * 所以如果只有getUser() 则需要 UserInfo user = new UserInfo();
     * 如果只有setUser 则报错
     * @return
     */

    /**
     * 前端页面需要写成 user.xxx形式
     * 账号:<input type="text" name="user.username"/></br>
     * 密码:<input type="number" name="user.password"/></br>
     */

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("username=" + user.getUsername() + ",password=" + user.getPassword());
        ActionContext.getContext().put("username",user.getUsername());
        return LOGIN;
    }
}
