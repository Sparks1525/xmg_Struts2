package mystruts2.hello;

import com.opensymphony.xwork2.ActionSupport;

public class Hello3 extends ActionSupport {


    @Override
    public String execute() throws Exception {
        System.out.println("hello3");
        return SUCCESS;
    }
}
