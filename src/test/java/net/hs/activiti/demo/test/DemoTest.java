package net.hs.activiti.demo.test;

import net.hs.activiti.demo.Application;
import net.hs.activiti.demo.service.DemoService;
import net.hs.activiti.demo.service.dto.DemoDTO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Author: caijl
 * Package:net.hs.activiti.demo.test
 * Project:ActivitiDemo
 * Description:
 * Date: 2017/7/27
 * Time: 9:47
 * 系统版本:1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DemoTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DemoService demoService;

    @Test
    public void queryPersonInfos(){
        logger.info(" -- Junit 测试开始 -- ");
        List<DemoDTO> list = demoService.queryPersonInfos();
        if(null != list && list.size() != 0){
            for (DemoDTO demoDTO : list){
                logger.info("PersonId:=" + demoDTO.getPersonId());
            }
        }
    }

}
