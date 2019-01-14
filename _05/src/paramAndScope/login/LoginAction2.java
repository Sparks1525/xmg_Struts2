package paramAndScope.login;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 2.通过ServletActionContext工具类
 * ServletActionContext工具类,封装了获取request和response的静态方法.
 *   常用方法:
 *   static HttpServletRequest getRequest():获取请求对象
 *   static HttpServletResponse getResponse():获取响应对象
 *
 *   通过ServletActionContext工具类.
 *   1):也很简单也很直观.
 *   2):也存在Action和ServletAPI耦合的问题.
 *   3):但是在开发中很多人依然使用这种方式.
 *
 *   如果我想完全让Action和ServletAPI解除耦合,方式3
 */

public class LoginAction2 extends ActionSupport {



    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        ServletContext context = ServletActionContext.getServletContext();
        return SUCCESS;
    }
}
