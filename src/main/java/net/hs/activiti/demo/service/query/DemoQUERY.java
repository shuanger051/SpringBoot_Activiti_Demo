package net.hs.activiti.demo.service.query;

/**
 * Author: caijl
 * Package:net.hs.activiti.demo.service.query
 * Project:ActivitiDemo
 * Description:
 * Date: 2017/7/25
 * Time: 18:08
 * 系统版本:1.0.0
 */
public class DemoQUERY {

    private Long personId;

    private String personName;

    private Long compCompId;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Long getCompCompId() {
        return compCompId;
    }

    public void setCompCompId(Long compCompId) {
        this.compCompId = compCompId;
    }

    @Override
    public String toString() {
        return "DemoQUERY{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", compCompId=" + compCompId +
                '}';
    }
}
