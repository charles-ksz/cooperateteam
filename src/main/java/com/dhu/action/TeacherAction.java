package com.dhu.action;

import com.dhu.dao.TeacherDAO;
import com.dhu.pojo.Teacher;

import java.util.List;

public class TeacherAction {

    TeacherDAO pdao = new TeacherDAO();
    Teacher Teacher;
    List<Teacher> Teachers;

    public List<Teacher> getTeachers() {
        return Teachers;
    }

    public void setTeachers(List<Teacher> Teachers) {
        this.Teachers = Teachers;
    }

    public Teacher getTeacher() {
        return Teacher;
    }

    public void setTeacher(Teacher Teacher) {
        this.Teacher = Teacher;
    }

    public String add() {
        pdao.add(Teacher);
        return "list";
    }
    public String edit() {
        Teacher =pdao.get(Teacher.getId());
        return "edit";
    }
    public String delete() {
        pdao.delete(Teacher.getId());
        return "list";
    }
    public String update() {
        pdao.update(Teacher);
        return "list";
    }
    public String list() {
        Teachers = pdao.listTeacher();
        return "listJsp";
    }

}
