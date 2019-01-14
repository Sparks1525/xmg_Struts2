package mystruts2.many;

import com.opensymphony.xwork2.ActionSupport;

public class Employee extends ActionSupport {


    public String execute1() throws Exception {
        System.out.println("execute1");
        return "execute1";
    }


    public String execute2() throws Exception {
        System.out.println("execute2");
        return "execute2";
    }

    public String execute3() throws Exception {
        System.out.println("execute3");
        return "execute3";
    }

    public String execute4() throws Exception {
        System.out.println("execute4");
        return "execute4";
    }
}
