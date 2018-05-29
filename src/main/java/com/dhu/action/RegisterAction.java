package com.dhu.action;
import java.util.List;
import com.dhu.dao.BaseinformationDAO;

import com.dhu.pojo.Baseinformation;
import com.opensymphony.xwork2.ActionSupport;


    public class RegisterAction extends ActionSupport {

        private String userName;
        private String password1;
        private String password2;
        private String mess=ERROR;    //ERROR等同于"error"
        private int id;
        private long studentNumber;
        private String sex;
        private long phoneNumber;
        private String mailAccount;
        private String school;
        private String academy;

        private List list;

        public void setMess(String mess) {
            this.mess = mess;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setPhoneNumber(long phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setMailAccount(String mailAccount) {
            this.mailAccount = mailAccount;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public void setAcademy(String academy) {
            this.academy = academy;
        }

        public String getSex() {

            return sex;
        }

        public long getPhoneNumber() {
            return phoneNumber;
        }

        public String getMailAccount() {
            return mailAccount;
        }

        public String getSchool() {
            return school;
        }

        public String getAcademy() {
            return academy;
        }



        public String getUserName() {
            return userName;
        }
        public void setUserName(String userName) {
            this.userName = userName;
        }
        public String getPassword1() {
            return password1;
        }
        public void setPassword1(String password1) {
            this.password1 = password1;
        }
        public String getPassword2() {
            return password2;
        }
        public void setPassword2(String password2) {
            this.password2 = password2;
        }
        public void setId(int id){this.id =id; }
        public int getId() {return id;}
        public long getStudentNumber () {return studentNumber;}
        public void setStudentNumber(long studentNumber) {this.studentNumber=studentNumber;}


        public void validate(){
            if(this.getUserName()==null||this.getUserName().length()==0){
                addFieldError("userName", "用户名不能为空！");
            }else{
                BaseinformationDAO info= new BaseinformationDAO();
                list=info.queryInfo("userName", this.getUserName());
                Baseinformation ui=new Baseinformation();
                for(int i=0;i<list.size();i++){
                    ui=(Baseinformation) list.get(i);
                    if(ui.getName().equals(this.getUserName())){
                        addFieldError("userName", "用户名已存在！");
                    }
                }
            }
            if(this.getPassword1()==null||this.getPassword1().length()==0){
                addFieldError("password1", "登录密码不许为空！");
            }else if(this.getPassword2()==null||this.getPassword2().length()==0){
                addFieldError("password2", "重复密码不许为空！");
            }else if(!this.getPassword1().equals(this.getPassword2())){
                addFieldError("password2", "两次密码不一致！");
            }
        }

        public Baseinformation userInfo(){
            Baseinformation info=new Baseinformation();
            info.setName(this.getUserName());
            info.setPassword(this.getPassword1());
            info.setId(this.id);
            info.setAcademy(this.academy);
            info.setMailAccount(this.mailAccount);
            info.setPhoneNumber(this.phoneNumber);
            info.setStudentNumber(this.studentNumber);
            info.setSex(this.sex);
            info.setSchool(this.school);
            return info;
        }

        public String execute() throws Exception{
            BaseinformationDAO lr=new BaseinformationDAO();
            String ri=lr.saveInfo(userInfo());
            if(ri.equals("success")){
                mess=SUCCESS;
            }

            return mess;
        }




}
