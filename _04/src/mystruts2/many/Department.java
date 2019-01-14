package mystruts2.many;

import com.opensymphony.xwork2.ActionSupport;

public class Department extends ActionSupport {
    @Override
    public String execute() throws Exception {
        System.out.println("Department");
        return SUCCESS;
    }
}
