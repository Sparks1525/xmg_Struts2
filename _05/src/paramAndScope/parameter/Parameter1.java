package paramAndScope.parameter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 1.Action本身作为Model对象，通过setter方法封装(属性注入)
 * 此时Action只需要提供参数同名的属性(setter方法,只需要给Action设置值.)
 *
 * 优点:简单,直观.
 * 缺点:如果参数比较多,此时Action就的提供N个setter方法,感觉很繁琐.
 * ------------------------------------
 * 在这里偷偷把参数传递给Action的是拦截器:
 * 在这里,也感受了,Struts2内置的类型转换器.
 * 在Struts2中,每一次请求都是一个新的Action对象,在Action中的成员变量是线程安全的.
 */
public class Parameter1 extends ActionSupport {


    String usernameXX;
    Integer passwordXX;

    public void setUsername(String username) {
        this.usernameXX = username;
    }

    public void setPassword(Integer password) {
        this.passwordXX = password;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("username=" + usernameXX + ",password=" + passwordXX);
        ActionContext.getContext().put("username",usernameXX);
        return LOGIN;
    }
}
