package com.dhu.action;

import com.dhu.dao.BaseinformationDAO;
import com.dhu.pojo.Baseinformation;

import java.util.List;

public class BaseinformationAction {

    BaseinformationDAO pdao = new BaseinformationDAO();
     Baseinformation baseinformation;
     List<Baseinformation> baseinformations;

    public List<Baseinformation> getBaseinformations() {
        return baseinformations;
    }

    public void setBaseinformations(List<Baseinformation> Baseinformations) {
        this.baseinformations = baseinformations;
    }

    public Baseinformation getBaseinformation() {
        return baseinformation;
    }

    public void setBaseinformation(Baseinformation Baseinformation) {
        this.baseinformation = Baseinformation;
    }

    public String add() {
        pdao.add(baseinformation);
        return "list";
    }
    public String edit() {
        baseinformation =pdao.get(baseinformation.getId());
        return "edit";
    }
    public String delete() {
        pdao.delete(baseinformation.getId());
        return "list";
    }
    public String update() {
        pdao.update(baseinformation);
        return "list";
    }
    public String list() {
        baseinformations = pdao.listBaseinformation();
        return "listJsp";
    }

}
