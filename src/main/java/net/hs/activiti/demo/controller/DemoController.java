package net.hs.activiti.demo.controller;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: caijl
 * Package:net.hs.activiti.demo.controller
 * Project:ActivitiDemo
 * Description:
 * Date: 2017/7/25
 * Time: 18:01
 * 系统版本:1.0.0
 */
@RestController
public class DemoController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProcessEngine processEngine;

    @RequestMapping("/test")
    public String queryLeaveInfos(){
        System.out.println("我曹");
        return "ok";
    }

    @RequestMapping("/startProcess")
    public void startProcess(){
        String processDefinitionKey = "autoProcess";
        ProcessInstance pi = processEngine.getRuntimeService().startProcessInstanceByKey(processDefinitionKey);
        logger.debug("流程实例ID:"+pi.getId());
        logger.debug("流程定义ID:"+pi.getProcessDefinitionId());
    }

}
