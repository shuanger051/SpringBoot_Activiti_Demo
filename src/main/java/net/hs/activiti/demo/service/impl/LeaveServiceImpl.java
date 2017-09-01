package net.hs.activiti.demo.service.impl;

import net.hs.activiti.demo.domain.LeaveMapper;
import net.hs.activiti.demo.service.LeaveService;
import net.hs.activiti.demo.service.dto.LeaveDTO;
import net.hs.activiti.demo.utils.BeanPropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project ： hs.net.activiti.demo
 * PackageName ： net.hs.activiti.demo.service.impl
 * Author ： caijl
 * Date ： 2017/7/28
 * Time ： 23:52
 * Description :
 * 系统版本 ： 1.0
 */
@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveMapper leaveMapper;

    public List<LeaveDTO> queryLeaveInfos(){
       return BeanPropertiesUtils.covert2List(leaveMapper.queryLeaveInfos(),LeaveDTO.class);
    }

}
