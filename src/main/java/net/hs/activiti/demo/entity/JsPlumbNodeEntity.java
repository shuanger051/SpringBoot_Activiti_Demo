package net.hs.activiti.demo.entity;

/**
 * Project ： net.hs.activiti.demo
 * PackageName ： net.hs.activiti.demo.entity
 * Author ： caijl
 * Date ： 2017/8/3
 * Time ： 14:40
 * Description :
 * 系统版本 ： 1.0
 */
public class JsPlumbNodeEntity {

    /**
     * 绘画节点ID
     */
    private String id;

    /**
     * 事件类型
     */
    private String type;

    /**
     * 节点名称
     */
    private String text;

    /**
     * 距离左侧边距
     */
    private Integer left;

    /**
     * 距离顶部边距
     */
    private Integer top;

    /**
     * 流程节点ID
     */
    private String resourceId;

    /**
     * 参数数据
     */
    private String data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsPlumbNodeEntity{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", text='" + text + '\'' +
                ", left=" + left +
                ", top=" + top +
                ", resourceId='" + resourceId + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

}
