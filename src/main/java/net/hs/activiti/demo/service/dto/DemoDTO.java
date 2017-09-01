package net.hs.activiti.demo.service.dto;

/**
 * Author: caijl
 * Package:net.hs.activiti.demo.service.dto
 * Project:ActivitiDemo
 * Description:
 * Date: 2017/7/25
 * Time: 18:07
 * 系统版本:1.0.0
 */
public class DemoDTO {

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

    @SuppressWarnings("unchecked")
    public <T>T getAttr(String attr){
        if("personId".equals(attr)){
            return (T) new Long(personId);
        }else if("personName".equals(attr)){
            return (T) personName;
        }else if("compCompId".equals(attr)){
            return (T) new Long(compCompId);
        }else if("age".equals(attr)){
            return (T) new Integer(age);
        }else if("gender".equals(attr)){
            return (T) new Integer(gender);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public void setAttr(String attr,Object value){
        if("personId".equals(attr)){
            this.personId = (Long) value;
        }else if("personName".equals(attr)){
            this.personName = (String) value;
        }else if("compCompId".equals(attr)){
            this.compCompId = (Long) value;
        }else if("age".equals(attr)){
            this.age = (Integer) value;
        }else if("gender".equals(attr)){
            this.gender = (Integer)value;
        }
    }


    @Override
    public String toString() {
        return "DemoDTO{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", compCompId=" + compCompId +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

}
