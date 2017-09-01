package net.hs.activiti.demo.service;

import net.hs.activiti.demo.service.dto.LeaveDTO;

import java.util.List;

/**
 * Project ： hs.net.activiti.demo
 * PackageName ： net.hs.activiti.demo.service
 * Author ： caijl
 * Date ： 2017/7/28
 * Time ： 23:51
 * Description :
 * 系统版本 ： 1.0
 */
public interface LeaveService {

    /**
     * 查询表内所有数据,数据初始化测试用
     * @return
     */
    List<LeaveDTO> queryLeaveInfos();

}
