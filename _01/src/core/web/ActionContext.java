package core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionContext {
    private HttpServletRequest request;
    private HttpServletResponse response;

    //好比每一个线程都使用的是一个新的ActionContext对象
    private static ThreadLocal<ActionContext> threadLocal = new ThreadLocal<>();

    private  static ActionContext mContext;
    public ActionContext(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public static void setContext(ActionContext actionContext){
        threadLocal.set(actionContext);
    }

    public static ActionContext getContext() {
        return threadLocal.get();
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }
}
