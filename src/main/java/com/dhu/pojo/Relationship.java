package com.dhu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Relationship {
    private int id;
    private Integer chooseid;
    private Integer statu;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "chooseid", nullable = true)
    public Integer getChooseid() {
        return chooseid;
    }

    public void setChooseid(Integer chooseid) {
        this.chooseid = chooseid;
    }

    @Basic
    @Column(name = "statu", nullable = true)
    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Relationship that = (Relationship) o;

        if (id != that.id) return false;
        if (chooseid != null ? !chooseid.equals(that.chooseid) : that.chooseid != null) return false;
        if (statu != null ? !statu.equals(that.statu) : that.statu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (chooseid != null ? chooseid.hashCode() : 0);
        result = 31 * result + (statu != null ? statu.hashCode() : 0);
        return result;
    }
}
