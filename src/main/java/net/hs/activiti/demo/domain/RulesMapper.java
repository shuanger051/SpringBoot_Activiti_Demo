package net.hs.activiti.demo.domain;

import net.hs.activiti.demo.domain.sqlprovider.RulesProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Project ： net.hs.activiti.demo
 * PackageName ： net.hs.activiti.demo.domain
 * Author ： caijl
 * Date ： 2017/8/15
 * Time ： 9:26
 * Description :
 * 系统版本 ： 1.0
 */
@Mapper
public interface RulesMapper {

    @SelectProvider(type = RulesProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "processDefId", column = "process_def_id", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "ruleInfo", column = "rule_info", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "nodeId", column = "node_id", jdbcType = JdbcType.VARCHAR, javaType = String.class)
    })
    RulesDO get(Long id);

    @SelectProvider(type = RulesProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "processDefId", column = "process_def_id", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "ruleInfo", column = "rule_info", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "nodeId", column = "node_id", jdbcType = JdbcType.VARCHAR, javaType = String.class)
    })
    List<RulesDO> list(RulesDO bean);


    @InsertProvider(type = RulesProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(RulesDO bean);

    @UpdateProvider(type = RulesProvider.class, method = "update")
    Integer update(RulesDO bean);

    @DeleteProvider(type = RulesProvider.class, method = "delete")
    Integer delete(Long id);

}
