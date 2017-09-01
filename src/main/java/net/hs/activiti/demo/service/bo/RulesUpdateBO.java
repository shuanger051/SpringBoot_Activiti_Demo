package net.hs.activiti.demo.service.bo;

/**
 * Project ： net.hs.activiti.demo
 * PackageName ： net.hs.activiti.demo.service.bo
 * Author ： caijl
 * Date ： 2017/8/15
 * Time ： 9:25
 * Description :
 * 系统版本 ： 1.0
 */
public class RulesUpdateBO {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 流程定义ID
     */
    private String processDefId;

    /**
     * 规则信息
     */
    private String ruleInfo;

    /**
     * 节点ID
     */
    private String nodeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcessDefId() {
        return processDefId;
    }

    public void setProcessDefId(String processDefId) {
        this.processDefId = processDefId;
    }

    public String getRuleInfo() {
        return ruleInfo;
    }

    public void setRuleInfo(String ruleInfo) {
        this.ruleInfo = ruleInfo;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    @Override
    public String toString() {
        return "RulesDTO{" +
                "id=" + id +
                ", processDefId='" + processDefId + '\'' +
                ", ruleInfo='" + ruleInfo + '\'' +
                ", nodeId='" + nodeId + '\'' +
                '}';
    }

}
