package login;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

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


        /**
         * 5:Action如何往ValueStack中存储数据,JSP如何从ValueStack中取出数据.
         * 1).把数据放入root中:(栈,ArrayList.每次都要压在栈顶)
         *      方式1:ValueStack对象.getRoot().add(0, Obejct val);//把数据压入栈顶
         *      方式2:ValueStack对象.getRoot().push(Object val):等价于valueStack对象.getRoot().add(0, Obejct val);
         *      方式3:ValueStack对象.set(String propertyName,Object value);
         *      方式4.在Action中提供一个可访问的属性(getter方法).
         *      一般的,把单个对象可放入root中,就在栈顶.
         * ------------------------------------------------------------------
         * 2).把数据放入context中:
         *     方式1:ValueStack对象.getContext().put(String key,Object value); 太长了.
         *     方式2:ActionContext对象.put(String key,Object value);
         *      一般的:把集合中的数据放入context中.
         * -------------------------------------------------------------------
         * 如何从JSP中取出ValueStack中的数据:
         * 此时必须使用Struts的标签.--->先引入Struts2标签
         * <%@ taglib uri="/struts-tags" prefix="s"%>
         * Struts2的调试标签:<s:debug/> :主要用来观察数据在哪一个空间(root,context).
         * 访问方式:<s:property value="OGNL表达式"/>
         * 1).获取root中数据:
         *    若:放入root中的数据,没有属性名:<s:property value="[0].top"/>
         *    若:放入root中的数据有属性名:   <s:property value="属性名"/>
         * 2).把context中数据:
         *    <s:property value="#key"/>
         * ------------------------------------------------------------------
         * EL可以访问ValueStack中的数据:
         *    不建议这么做:
         *    为什么可以呢: Struts2重新包装而来请求对象.${msg}---><%=pageContext.findAttribute("msg")  %>
         *    StrutsRequestWrapper:先从ValueStack中取出数据,再放入request中.
         */



        ServletActionContext.getRequest();
        ActionContext.getContext().getApplication().get("");

        // 1.root
        ValueStack vs = (ValueStack)ServletActionContext.getRequest()
                .getAttribute("struts.valueStack");

        ValueStack vs2 = (ValueStack)ServletActionContext.getRequest()
                .getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);

        vs.getRoot().add(0,"VS_Add");

        ActionContext.getContext().getValueStack().getRoot().push("VS_Push");

        vs.set("VS_Set","VS_Set");


        // 2.context
        vs.getContext().put("VS_getContext_Put","VS_getContext_Put");
        ActionContext.getContext().put("VS_ActionContext_getContext_Put","VS_ActionContext_getContext_Put");

        System.out.println("登陆用户:"+user);
        ActionContext.getContext().getSession().put("USER_IN_SESSION",user);
        return SUCCESS;
    }

    // 跳过验证
    @SkipValidation
    public void temp1(){

    }


    // 编写校验规则
    @Override
    public void validate() {
       // ...... 同validateUser()
    }

    /**
     *  自定义校验方法 public void validateXxx(){}:Xxx表示被校验的方法.
     *  修改默认的结果视图----?校验失败跳到"edit"视图
     *  必须贴在被校验的方法之上,而不是贴在validate上.
     */
    @InputConfig(resultName="edit")
    public void validateUser(){
        if(user.getUsername().length() < 6){
            super.addFieldError("username","长度不能少于6位");
        }

        if(user.getPassword() != null){
            super.addFieldError("password","密码不能为空");
        }
    }
}
