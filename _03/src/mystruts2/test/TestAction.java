package mystruts2.test;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

    public String test() {

        System.out.println("hello");
        return SUCCESS;
    }
}
