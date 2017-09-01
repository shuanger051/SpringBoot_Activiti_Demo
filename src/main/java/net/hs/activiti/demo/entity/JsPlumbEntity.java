package net.hs.activiti.demo.entity;

import java.util.List;

/**
 * Project ： net.hs.activiti.demo
 * PackageName ： net.hs.activiti.demo.entity
 * Author ： caijl
 * Date ： 2017/8/3
 * Time ： 15:06
 * Description :
 * 系统版本 ： 1.0
 */
public class JsPlumbEntity {

    private List<JsPlumbNodeEntity> nodeEntityList;

    private List<JsPlumbConnEntity> connEntityList;

    public List<JsPlumbNodeEntity> getNodeEntityList() {
        return nodeEntityList;
    }

    public void setNodeEntityList(List<JsPlumbNodeEntity> nodeEntityList) {
        this.nodeEntityList = nodeEntityList;
    }

    public List<JsPlumbConnEntity> getConnEntityList() {
        return connEntityList;
    }

    public void setConnEntityList(List<JsPlumbConnEntity> connEntityList) {
        this.connEntityList = connEntityList;
    }

    @Override
    public String toString() {
        return "JsPlumbEntity{" +
                "nodeEntityList=" + nodeEntityList +
                ", connEntityList=" + connEntityList +
                '}';
    }

}
