package net.hs.activiti.demo.service;

import net.hs.activiti.demo.service.dto.RulesDTO;

import java.util.List;

/**
 * Project ： net.hs.activiti.demo
 * PackageName ： net.hs.activiti.demo.service
 * Author ： caijl
 * Date ： 2017/8/15
 * Time ： 9:55
 * Description :
 * 系统版本 ： 1.0
 */
public interface RulesService {

    List<RulesDTO> queryRulesInfoList();

}
