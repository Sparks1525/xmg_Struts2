package mystruts2.manyact;

import com.opensymphony.xwork2.ActionSupport;

public class Employee extends ActionSupport {
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String edit(){
        return "edit";
    }

    public String list(){
        return "list";
    }
}
