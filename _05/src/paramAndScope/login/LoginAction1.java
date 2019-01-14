package paramAndScope.login;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * 1.通过实现感知接口
 *
 * 需要访问/操作哪一个Servlet的API,就只需要让Action实现对应的感知接口.
 *    HttpServletRequest                      ServletRequestAware
 *    HttpServletResponse                     ServletResponseAware
 *    ServletContext                          ServletContextAware
 *
 *    实现感知接口的方式来访问Servlet的API:
 *   1):确实很简单.
 *   2):此时Action和Servlet的API严重耦合在一起.
 *     也就是说,使用Strtus2必须依赖Servlet的相关的jar包.
 *    解决方案:参照方式2.
 */
public class LoginAction1 extends ActionSupport implements
        ServletRequestAware,
        ServletResponseAware,
        SessionAware {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private Map<String, Object> session;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    @Override
    public String input() throws Exception {
        return INPUT;
    }
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
