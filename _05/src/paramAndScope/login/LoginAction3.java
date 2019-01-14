package paramAndScope.login;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;


/**
 * 3.通过ActionContext类.
 * ActionContext类,表示Action的上下文,每一次请求都是一个新的Action对象,可以先简单的理解为:ActionContext就封装了这一次请求所有相关的数据.
 *
 * 创建ActionContext对象:
 *    ActionContext  ctx = ActionContext.getContext();
 *
 * 常用的方法:
 *   操作request作用域:
 *     void  put(String key,Object value):把共享数据存放在request中.好比:request.setAttribute(String key,Object value);
 *     Object get(String key):从request中取出共享数据.              好比:Object value = request.getAttribute(String key);
 *   操作session作用域:
 *     先获取Session的Map对象:Map<String,Object> getSession();接下来的操作就是操作Map集合.
 *   操作application作用域:
 *     先获取application的Map对象:Map<String,Object> getApplication();接下来的操作就是操作Map集合.
 *   获取请求参数:
 *     先获取参数的Map集合,再从Map中取出每一个参数.
 *    Map<String,Object>  ActionContext.getContext().getParameters();
 *
 */
public class LoginAction3 extends ActionSupport {



    @Override
    public String execute() throws Exception {

        ActionContext ctx = ActionContext.getContext();


        String username = ((String[]) ctx.getParameters().get("username"))[0];
        Integer password = Integer.valueOf(((String[]) ctx.getParameters().get("password"))[0]);
        System.out.println("username=" + username + ",password=" + password);


        ctx.getContext().get("");
        ctx.put("","");

        Map<String,Object> session = ctx.getContext().getSession();
        Map<String,Object> application = ctx.getContext().getApplication();
        Map<String,Object> parameters = ctx.getContext().getParameters();

        return SUCCESS;
    }
}
