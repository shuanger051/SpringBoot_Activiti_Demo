package net.hs.activiti.demo.service.impl;

import net.hs.activiti.demo.domain.DemoDO;
import net.hs.activiti.demo.domain.DemoMapper;
import net.hs.activiti.demo.service.DemoService;
import net.hs.activiti.demo.service.dto.DemoDTO;
import net.hs.activiti.demo.utils.BeanPropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: caijl
 * Package:net.hs.activiti.demo.service.impl
 * Project:ActivitiDemo
 * Description:
 * Date: 2017/7/25
 * Time: 18:08
 * 系统版本:1.0.0
 */

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    public List<DemoDTO> queryPersonInfos(){
        return BeanPropertiesUtils.covert2List(demoMapper.queryPersonInfos(),DemoDTO.class);
    }

    public List<DemoDTO> queryPersonInfosByAgeGreate30(){
        return BeanPropertiesUtils.covert2List(demoMapper.queryPersonInfosByAgeGreate30(),DemoDTO.class);
    }

}
