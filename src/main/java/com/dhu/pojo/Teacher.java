package com.dhu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {
    private int id;
    private String goodSubject;
    private String freeTime;
    private String fromStudentInformation;
    private String state;
    private String honor;
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
    @Column(name = "goodSubject", nullable = true, length = 255)
    public String getGoodSubject() {
        return goodSubject;
    }

    public void setGoodSubject(String goodSubject) {
        this.goodSubject = goodSubject;
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
    @Column(name = "fromStudentInformation", nullable = true, length = 255)
    public String getFromStudentInformation() {
        return fromStudentInformation;
    }

    public void setFromStudentInformation(String fromStudentInformation) {
        this.fromStudentInformation = fromStudentInformation;
    }

    @Basic
    @Column(name = "state", nullable = true, length = 1)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "honor", nullable = true, length = 255)
    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
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

        Teacher teacher = (Teacher) o;

        if (id != teacher.id) return false;
        if (goodSubject != null ? !goodSubject.equals(teacher.goodSubject) : teacher.goodSubject != null) return false;
        if (freeTime != null ? !freeTime.equals(teacher.freeTime) : teacher.freeTime != null) return false;
        if (fromStudentInformation != null ? !fromStudentInformation.equals(teacher.fromStudentInformation) : teacher.fromStudentInformation != null)
            return false;
        if (state != null ? !state.equals(teacher.state) : teacher.state != null) return false;
        if (honor != null ? !honor.equals(teacher.honor) : teacher.honor != null) return false;
        if (remark != null ? !remark.equals(teacher.remark) : teacher.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (goodSubject != null ? goodSubject.hashCode() : 0);
        result = 31 * result + (freeTime != null ? freeTime.hashCode() : 0);
        result = 31 * result + (fromStudentInformation != null ? fromStudentInformation.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (honor != null ? honor.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
