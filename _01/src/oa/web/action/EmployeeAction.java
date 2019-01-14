package oa.web.action;

import core.web.ActionContext;

public class EmployeeAction {
    public String execute() throws Exception{
        System.out.println("员工列表");

        ActionContext context = ActionContext.getContext();
        String username = context.getRequest().getParameter("username");

        return "list";
    }
}
