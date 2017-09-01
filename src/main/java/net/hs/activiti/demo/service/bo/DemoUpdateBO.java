package net.hs.activiti.demo.service.bo;

/**
 * Author: caijl
 * Package:net.hs.activiti.demo.service.bo
 * Project:ActivitiDemo
 * Description:
 * Date: 2017/7/25
 * Time: 18:05
 * 系统版本:1.0.0
 */
public class DemoUpdateBO {

    private Long personId;

    private String personName;

    private Long compCompId;

    private Integer age;

    private Integer gender;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "DemoUpdateBO{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", compCompId=" + compCompId +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

}
