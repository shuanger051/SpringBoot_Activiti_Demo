package net.hs.activiti.demo.domain;

import net.hs.activiti.demo.domain.sqlprovider.LeaveProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 * Project ： hs.net.activiti.demo
 * PackageName ： net.hs.activiti.demo.domain
 * Author ： caijl
 * Date ： 2017/7/28
 * Time ： 23:15
 * Description :
 * 系统版本 ： 1.0
 */
@Mapper
public interface LeaveMapper {

    @SelectProvider(type = LeaveProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "leaveUserName", column = "leave_user_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "leaveDays", column = "leave_days", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "beginDate", column = "begin_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "endDate", column = "end_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "createDate", column = "create_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    DemoDO get(Long id);

    @SelectProvider(type = LeaveProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "leaveUserName", column = "leave_user_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "leaveDays", column = "leave_days", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "beginDate", column = "begin_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "endDate", column = "end_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "createDate", column = "create_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    List<LeaveDO> list(LeaveDO bean);

    @SelectProvider(type = LeaveProvider.class, method = "queryLeaveInfos")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "leaveUserName", column = "leave_user_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "leaveDays", column = "leave_days", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "beginDate", column = "begin_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "endDate", column = "end_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class),
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "createDate", column = "create_date", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
    })
    List<LeaveDO> queryLeaveInfos();

    @InsertProvider(type = LeaveProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(LeaveDO bean);

    @UpdateProvider(type = LeaveProvider.class, method = "update")
    Integer update(LeaveDO bean);

    @DeleteProvider(type = LeaveProvider.class, method = "delete")
    Integer delete(Long id);

}
