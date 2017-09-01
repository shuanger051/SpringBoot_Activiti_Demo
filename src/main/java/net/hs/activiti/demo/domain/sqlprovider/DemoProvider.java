package net.hs.activiti.demo.domain.sqlprovider;

import net.hs.activiti.demo.core.BaseSqlProvider;
import net.hs.activiti.demo.domain.DemoDO;
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
public class DemoProvider extends BaseSqlProvider {

    public static final String TABLE_ALIAS = "person";
    public static final String[] Fields={"person_id","person_name","comp_comp_id","age","gender"};

    /**
     * 获取单个结果集
     */
    public String get(final Long personId){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("person_id=#{personId}");
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String list(final DemoDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getPersonId() != null){
                    WHERE("person_id=#{personId}");
                }
                if(bean.getPersonName() != null){
                    WHERE("person_name=#{personName}");
                }
                if(bean.getCompCompId() != null){
                    WHERE("comp_comp_id=#{compCompId}");
                }
                if(bean.getAge() != null){
                    WHERE("age=#{age}");
                }
                if(bean.getGender() != null){
                    WHERE("gender=#{gender}");
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
    public String queryPersonInfos(){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
        }}.toString();
    }

    public String queryPersonInfosByAgeGreate30(){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE(" age > 30 ");
        }}.toString();
    }

    /**
     *  保存单个对象
     */
    public String save(final DemoDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getPersonId() != null) {
                VALUES("person_id", "#{personId}");
            }
            if (bean.getPersonName() != null) {
                VALUES("person_name", "#{personName}");
            }
            if (bean.getCompCompId() != null) {
                VALUES("comp_comp_id", "#{compCompId}");
            }
            if (bean.getGender() != null){
                VALUES("gender","#{gender}");
            }
            if(bean.getAge() != null){
                VALUES("age","#{age}");
            }
        }}.toString();
    }

    /**
     * 更新对象
     */
    public String update(final DemoDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getPersonId() != null) {
                SET("person_id=#{personId}");
            }
            if (bean.getPersonName() != null) {
                SET("person_name=#{personName}");
            }
            if (bean.getCompCompId() != null) {
                SET("comp_comp_id=#{compCompId}");
            }
            if (bean.getGender() != null){
                SET("gender=#{gender}");
            }
            if(bean.getAge() != null){
                SET("age=#{age}");
            }
            WHERE("person_id = #{personId}");
        }}.toString();
    }


    /**
     * 按条件移除对象
     */
    public String remove(final DemoDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getPersonId() != null){
                WHERE("person_id=#{personId}");
            }
            if(bean.getPersonName() != null){
                WHERE("person_name=#{personName}");
            }
            if(bean.getCompCompId()!=null){
                WHERE("comp_comp_id=#{compCompId}");
            }
            if(bean.getAge() != null){
                WHERE("age=#{age}");
            }
            if(bean.getGender() != null){
                WHERE("gender=#{gender}");
            }
        }}.toString();
    }

    /**
     * 删除单个对象
     */
    public String delete(final Long personId){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            WHERE("person_id=#{personId}");
        }}.toString();
    }

}
