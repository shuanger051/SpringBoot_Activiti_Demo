package net.hs.activiti.demo.domain.sqlprovider;

import net.hs.activiti.demo.core.BaseSqlProvider;
import net.hs.activiti.demo.domain.RulesDO;
import org.apache.ibatis.jdbc.SQL;

/**
 * Project ： net.hs.activiti.demo
 * PackageName ： net.hs.activiti.demo.domain.sqlprovider
 * Author ： caijl
 * Date ： 2017/8/15
 * Time ： 9:34
 * Description :
 * 系统版本 ： 1.0
 */
public class RulesProvider extends BaseSqlProvider {

    public static final String TABLE_ALIAS = "rules";
    public static final String[] Fields={"id","process_def_id","rule_info","node_id"};

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
    public String list(final RulesDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId() != null){
                    WHERE("id=#{id}");
                }
                if(bean.getProcessDefId() != null){
                    WHERE("process_def_id=#{processDefId}");
                }
                if(bean.getNodeId() != null){
                    WHERE("node_id=#{nodeId}");
                }
                if(bean.getRuleInfo() != null){
                    WHERE("rule_info=#{ruleInfo}");
                }
                if(bean.getSort() != null){
                    ORDER_BY(bean.getSort());
                }
            }
        }}.toString();
    }

    /**
     *  保存单个对象
     */
    public String save(final RulesDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getId() != null) {
                VALUES("id", "#{id}");
            }
            if (bean.getProcessDefId() != null) {
                VALUES("process_def_id", "#{processDefId}");
            }
            if (bean.getRuleInfo() != null) {
                VALUES("rule_info", "#{ruleInfo}");
            }
            if (bean.getNodeId() != null){
                VALUES("node_id","#{nodeId}");
            }
        }}.toString();
    }

    /**
     * 更新对象
     */
    public String update(final RulesDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getId() != null) {
                SET("id=#{id}");
            }
            if (bean.getProcessDefId() != null) {
                SET("process_def_id=#{processDefId}");
            }
            if (bean.getRuleInfo() != null) {
                SET("rule_info=#{ruleInfo}");
            }
            if (bean.getNodeId() != null){
                SET("node_id=#{nodeId}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }


    /**
     * 按条件移除对象
     */
    public String remove(final RulesDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId() != null){
                WHERE("id=#{id}");
            }
            if(bean.getProcessDefId() != null){
                WHERE("process_def_id=#{processDefId}");
            }
            if(bean.getRuleInfo()!=null){
                WHERE("rule_info=#{ruleInfo}");
            }
            if(bean.getNodeId() != null){
                WHERE("node_id=#{nodeId}");
            }
        }}.toString();
    }

    /**
     * 删除单个对象
     */
    public String delete(final Long personId){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            WHERE("id=#{id}");
        }}.toString();
    }

}
