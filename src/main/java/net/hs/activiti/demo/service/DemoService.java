package net.hs.activiti.demo.service;

import net.hs.activiti.demo.service.dto.DemoDTO;

import java.util.List;

/**
 * Author: caijl
 * Package:net.hs.activiti.demo.service
 * Project:ActivitiDemo
 * Description:
 * Date: 2017/7/25
 * Time: 18:08
 * 系统版本:1.0.0
 */
public interface DemoService {

    List<DemoDTO> queryPersonInfos();

    List<DemoDTO> queryPersonInfosByAgeGreate30();

}
