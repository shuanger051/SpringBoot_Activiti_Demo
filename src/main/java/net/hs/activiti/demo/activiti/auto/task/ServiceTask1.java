package net.hs.activiti.demo.activiti.auto.task;

import com.alibaba.fastjson.JSON;
import net.hs.activiti.demo.config.SpringContextHolder;
import net.hs.activiti.demo.entity.ProcessRulesEntity;
import net.hs.activiti.demo.service.RulesService;
import net.hs.activiti.demo.service.dto.DemoDTO;
import net.hs.activiti.demo.service.dto.RulesDTO;
import net.hs.activiti.demo.utils.RulesResUtils;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Project ： net.hs.activiti.demo
 * PackageName ： net.hs.activiti.demo.activiti.auto.task
 * Author ： caijl
 * Date ： 2017/8/14
 * Time ： 15:57
 * Description :
 * 系统版本 ： 1.0
 */
@Component
public class ServiceTask1 implements JavaDelegate {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        /*logger.debug("获取人员表中年龄大于30的集合列表");
        List<DemoDTO> demoDTOList = SpringContextHolder.getBean(DemoService.class).queryPersonInfosByAgeGreate30();
        if(null != demoDTOList && demoDTOList.size() != 0){
            for(DemoDTO demoDTO : demoDTOList){
                logger.debug("获取到人员信息:" + demoDTO.getPersonName() + "  年龄为：" + demoDTO.getAge());
            }
        }*/

        //设定用户信息
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setAge(31);
        demoDTO.setCompCompId(333L);
        demoDTO.setGender(1);

        List<RulesDTO> rulesDTOList = SpringContextHolder.getBean(RulesService.class).queryRulesInfoList();
        if(null != rulesDTOList && rulesDTOList.size() != 0){
            RulesDTO rulesDTO = rulesDTOList.get(0);
            //解析规则
            List<ProcessRulesEntity> processRulesEntities = JSON.parseArray(rulesDTO.getRuleInfo(), ProcessRulesEntity.class);

            if(null != processRulesEntities && processRulesEntities.size() != 0){
                boolean checkFlag = true;
                for(ProcessRulesEntity processRulesEntity : processRulesEntities){
                    if(!RulesResUtils.compareRealValAndRuleVal(demoDTO.getAttr(processRulesEntity.getKey()).toString(), processRulesEntity.getType(),processRulesEntity.getValue())){
                        checkFlag = false;
                        break;
                    }
                }
                if(checkFlag){
                    execution.setVariable("gender", 1);
                    logger.debug("Is Saying Hello To ServiceTask2 !");
                }else {
                    execution.setVariable("gender", 0);
                    logger.debug("Is Saying Hello To ServiceTask3 !");
                }
            }
        }else{
            execution.setVariable("gender", 0);
            logger.debug("Is Saying Hello To ServiceTask3 !");
        }
    }

}
