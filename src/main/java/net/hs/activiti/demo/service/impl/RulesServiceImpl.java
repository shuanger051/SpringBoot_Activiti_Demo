package net.hs.activiti.demo.service.impl;

import net.hs.activiti.demo.domain.RulesDO;
import net.hs.activiti.demo.domain.RulesMapper;
import net.hs.activiti.demo.service.RulesService;
import net.hs.activiti.demo.service.dto.RulesDTO;
import net.hs.activiti.demo.utils.BeanPropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project ： net.hs.activiti.demo
 * PackageName ： net.hs.activiti.demo.service.impl
 * Author ： caijl
 * Date ： 2017/8/15
 * Time ： 9:56
 * Description :
 * 系统版本 ： 1.0
 */
@Service
public class RulesServiceImpl implements RulesService{

    @Autowired
    private RulesMapper rulesMapper;

    public List<RulesDTO> queryRulesInfoList(){
        return BeanPropertiesUtils.covert2List(rulesMapper.list(new RulesDO()),RulesDTO.class);
    }

}
