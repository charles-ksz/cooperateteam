package com.dhu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    private int id;
    private String badSubject;
    private String freeTime;
    private String fromTeacherInformation;
    private String remark;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "badSubject", nullable = true, length = 255)
    public String getBadSubject() {
        return badSubject;
    }

    public void setBadSubject(String badSubject) {
        this.badSubject = badSubject;
    }

    @Basic
    @Column(name = "freeTime", nullable = true, length = 255)
    public String getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(String freeTime) {
        this.freeTime = freeTime;
    }

    @Basic
    @Column(name = "fromTeacherInformation", nullable = true, length = 255)
    public String getFromTeacherInformation() {
        return fromTeacherInformation;
    }

    public void setFromTeacherInformation(String fromTeacherInformation) {
        this.fromTeacherInformation = fromTeacherInformation;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (badSubject != null ? !badSubject.equals(student.badSubject) : student.badSubject != null) return false;
        if (freeTime != null ? !freeTime.equals(student.freeTime) : student.freeTime != null) return false;
        if (fromTeacherInformation != null ? !fromTeacherInformation.equals(student.fromTeacherInformation) : student.fromTeacherInformation != null)
            return false;
        if (remark != null ? !remark.equals(student.remark) : student.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (badSubject != null ? badSubject.hashCode() : 0);
        result = 31 * result + (freeTime != null ? freeTime.hashCode() : 0);
        result = 31 * result + (fromTeacherInformation != null ? fromTeacherInformation.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
