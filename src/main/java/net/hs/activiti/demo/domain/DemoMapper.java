package net.hs.activiti.demo.domain;

import net.hs.activiti.demo.domain.sqlprovider.DemoProvider;
import net.hs.activiti.demo.service.dto.DemoDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Author: caijl
 * Package:net.hs.activiti.demo.domain
 * Project:ActivitiDemo
 * Description:
 * Date: 2017/7/25
 * Time: 18:04
 * 系统版本:1.0.0
 */
@Mapper
public interface DemoMapper {

    @SelectProvider(type = DemoProvider.class, method = "get")
    @Results(value = {
            @Result(property = "personId", column = "person_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "personName", column = "person_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "compCompId", column = "comp_comp_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "age", column = "age", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "gender", column = "gender", jdbcType = JdbcType.INTEGER, javaType = Integer.class)
    })
    DemoDO get(Long id);

    @SelectProvider(type = DemoProvider.class, method = "list")
    @Results(value= {
            @Result(property = "personId", column = "person_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "personName", column = "person_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "compCompId", column = "comp_comp_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "age", column = "age", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "gender", column = "gender", jdbcType = JdbcType.INTEGER, javaType = Integer.class)
    })
    List<DemoDO> list(DemoDO bean);

    @SelectProvider(type = DemoProvider.class, method = "queryPersonInfos")
    @Results(value= {
            @Result(property = "personId", column = "person_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "personName", column = "person_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "compCompId", column = "comp_comp_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "age", column = "age", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "gender", column = "gender", jdbcType = JdbcType.INTEGER, javaType = Integer.class)
    })
    List<DemoDO> queryPersonInfos();

    @SelectProvider(type = DemoProvider.class, method = "queryPersonInfosByAgeGreate30")
    @Results(value= {
            @Result(property = "personId", column = "person_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "personName", column = "person_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "compCompId", column = "comp_comp_id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "age", column = "age", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(property = "gender", column = "gender", jdbcType = JdbcType.INTEGER, javaType = Integer.class)
    })
    List<DemoDTO> queryPersonInfosByAgeGreate30();

    @InsertProvider(type = DemoProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(DemoDO bean);

    @UpdateProvider(type = DemoProvider.class, method = "update")
    Integer update(DemoDO bean);

    @DeleteProvider(type = DemoProvider.class, method = "remove")
    Integer remove(DemoDO bean);

    @DeleteProvider(type = DemoProvider.class, method = "delete")
    Integer delete(Long id);

}
