package paramAndScope.parameter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import paramAndScope.domain.User;

/**
 * 3.Action实现ModelDriven接口，对请求数据进行封装(模型驱动)
 *
 * 该方式:
 * 优点:JSP表单干净,也抽取了Model对象,Action也比较简单.
 * 缺点:一个Action只能把请求的参数封装到一种类型的对象中去.
 *
 */
public class Parameter3 extends ActionSupport implements ModelDriven<User> {

    /**
     *  没有 new UserInfo() 会有空指针异常
     *  private UserInfo user;
     *
     * java.lang.NullPointerException
     */
    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("username=" + user.getUsername() + ",password=" + user.getPassword());
        ActionContext.getContext().put("username",user.getUsername());
        return LOGIN;
    }

}
