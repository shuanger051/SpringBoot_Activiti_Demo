package net.hs.activiti.demo.domain;

import net.hs.activiti.demo.core.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * Project ： hs.net.activiti.demo
 * PackageName ： net.hs.activiti.demo.domain
 * Author ： caijl
 * Date ： 2017/7/28
 * Time ： 23:09
 * Description :
 * 系统版本 ： 1.0
 */
public class LeaveDO extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -2563235228611475311L;

    private String leaveUserName;

    private Integer leaveDays;

    private Date beginDate;

    private Date endDate;

    private String remark;

    private Date createDate;

    public String getLeaveUserName() {
        return leaveUserName;
    }

    public void setLeaveUserName(String leaveUserName) {
        this.leaveUserName = leaveUserName;
    }

    public Integer getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(Integer leaveDays) {
        this.leaveDays = leaveDays;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "LeaveDO{" +
                ", leaveUserName='" + leaveUserName + '\'' +
                ", leaveDays=" + leaveDays +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", remark='" + remark + '\'' +
                ", createDate=" + createDate +
                '}';
    }

}
