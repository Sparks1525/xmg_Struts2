package mystruts2.hello;

import com.opensymphony.xwork2.Action;

public class Hello4 implements Action {
    @Override
    public String execute() throws Exception {

        System.out.println("hello4");

        return SUCCESS;
    }
}
