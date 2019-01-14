package mystruts2.hello;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {


    public String sayHello() {

        System.out.println("hello");
        return SUCCESS;
    }
}
