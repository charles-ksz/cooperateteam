package com.dhu.action;

import com.dhu.dao.BaseinformationDAO;
import com.dhu.pojo.Baseinformation;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class LoginAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String message = "error";
    private List list;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // password的getter和setter方法
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void validate() {
        if (this.getUsername() == null || this.getUsername().equals(" ")) {
            addFieldError("username", "用户名字不能为空！");
        } else {
            BaseinformationDAO bd = new BaseinformationDAO();
            list = bd.queryInfo("username", this.getUsername());
            if (list.size() == 0) {
                addFieldError("username", "该用户尚未注册");
            } else {
                Baseinformation ui = new Baseinformation();
                for (int i = 0; i < list.size(); i++) {
                    ui = (Baseinformation) list.get(i);
                    if (this.getUsername().equals(ui.getName())) {
                        if (ui.getPassword().equals(this.getPassword())) {
                            message = SUCCESS;
                        } else {
                            addFieldError("password", "登录密码不正确");
                        }
                    }

                }
            }
        }
    }

        public String execute() throws Exception{
            return message;
        }

}
