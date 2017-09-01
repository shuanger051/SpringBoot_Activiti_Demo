package net.hs.activiti.demo.domain.sqlprovider;

import net.hs.activiti.demo.core.BaseSqlProvider;
import net.hs.activiti.demo.domain.LeaveDO;
import org.apache.ibatis.jdbc.SQL;


/**
 * Author: caijl
 * Package:net.hs.activiti.demo.domain.sqlprovider
 * Project:ActivitiDemo
 * Description:
 * Date: 2017/7/25
 * Time: 18:05
 * 系统版本:1.0.0
 */
public class LeaveProvider extends BaseSqlProvider {

    public static final String TABLE_ALIAS = "leaves";
    public static final String[] Fields={"id","leave_user_name","leave_days","begin_date","end_date","remark","create_date"};

    /**
     * 获取单个结果集
     */
    public String get(final Long id){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("id=#{id}");
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String list(final LeaveDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId() != null){
                    WHERE("id=#{id}");
                }
                if(bean.getLeaveUserName() != null){
                    WHERE("leave_user_name=#{leaveUserName}");
                }
                if(bean.getLeaveDays() != null){
                    WHERE("leave_days=#{leaveDays}");
                }
                if(bean.getRemark() != null){
                    WHERE("remark=#{remark}");
                }
                if(bean.getBeginDate() != null){
                    WHERE("begin_date=#{beginDate}");
                }
                if(bean.getEndDate() != null){
                    WHERE("end_date=#{endDate}");
                }
                if(bean.getCreateDate() != null){
                    WHERE("create_date=#{createDate}");
                }
                if(bean.getSort() != null){
                    ORDER_BY(bean.getSort());
                }
            }
        }}.toString();
    }

    /**
     * 查询表内所有数据集合
     * @return
     */
    public String queryLeaveInfos(){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
        }}.toString();
    }

    /**
     *  保存单个对象
     */
    public String save(final LeaveDO bean){
        return new SQL() {{
            if (null != bean) {
                INSERT_INTO(TABLE_ALIAS);
                if (bean.getLeaveUserName() != null) {
                    VALUES("leave_user_name", "#{leaveUserName}");
                }
                if (bean.getLeaveDays() != null) {
                    VALUES("leave_days", "#{leaveDays}");
                }
                if (bean.getRemark() != null) {
                    VALUES("remark", "#{remark}");
                }
                if (bean.getBeginDate() != null) {
                    VALUES("begin_date", "#{beginDate}");
                }
                if (bean.getEndDate() != null) {
                    VALUES("end_date", "endDate");
                }
                if (bean.getCreateDate() != null) {
                    VALUES("create_date", "createDate");
                }
            }
        }}.toString();
    }

    /**
     * 更新对象
     */
    public String update(final LeaveDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getId() != null) {
                SET("id=#{id}");
            }
            if (bean.getLeaveUserName() != null) {
                SET("leave_user_name=#{leaveUserName}");
            }
            if (bean.getLeaveDays() != null) {
                SET("leave_days=#{leaveDays}");
            }
            if (bean.getRemark() !=  null){
                SET("remark=#{remark}");
            }
            if(bean.getBeginDate() != null){
                SET("begin_date=#{beginDate}");
            }
            if(bean.getEndDate() != null){
                SET("end_date=#{endDate}");
            }
            if(bean.getCreateDate() != null){
                SET("create_date=#{createDate}");
            }
            WHERE("person_id = #{personId}");
        }}.toString();
    }

    /**
     * 删除单个对象
     */
    public String delete(final Long id){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            WHERE("id=#{id}");
        }}.toString();
    }

}
