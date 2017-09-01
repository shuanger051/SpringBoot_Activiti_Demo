package net.hs.activiti.demo.entity;

/**
 * Project ： net.hs.activiti.demo
 * PackageName ： net.hs.activiti.demo.entity
 * Author ： caijl
 * Date ： 2017/8/3
 * Time ： 15:02
 * Description :
 * 系统版本 ： 1.0
 */
public class JsPlumbConnEntity {

    /**
     * 绘画起始节点ID
     */
    private String source;

    /**
     * 绘画结束节点ID
     */
    private String target;

    /**
     * 连接线ID
     */
    private String resourceId;

    /**
     * 流程起始ID
     */
    private String sourceId;

    /**
     * 流程结束ID
     */
    private String targetId;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    @Override
    public String toString() {
        return "JsPlumbConnEntity{" +
                "source='" + source + '\'' +
                ", target='" + target + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", targetId='" + targetId + '\'' +
                '}';
    }

}
