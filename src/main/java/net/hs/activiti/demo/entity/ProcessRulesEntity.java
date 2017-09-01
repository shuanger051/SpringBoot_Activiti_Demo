package net.hs.activiti.demo.entity;

/**
 * Project ： net.hs.activiti.demo
 * PackageName ： net.hs.activiti.demo.entity
 * Author ： caijl
 * Date ： 2017/8/15
 * Time ： 10:07
 * Description :
 * 系统版本 ： 1.0
 */
public class ProcessRulesEntity {

    /**
     * 条件名称
     */
    private String key;

    /**
     * 条件类型
     */
    private String type;

    /**
     * 条件值
     */
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "ProcessRulesEntity{" +
                "key='" + key + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

}
