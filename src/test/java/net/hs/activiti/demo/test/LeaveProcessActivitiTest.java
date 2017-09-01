package net.hs.activiti.demo.test;

import net.hs.activiti.demo.service.LeaveService;
import net.hs.activiti.demo.service.dto.LeaveDTO;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: caijl
 * Package:net.hs.activiti.demo.test
 * Project:ActivitiDemo
 * Description:
 * Date: 2017/7/28
 * Time: 13:14
 * 系统版本:1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class LeaveProcessActivitiTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LeaveService leaveService;

    @Autowired
    ProcessEngine processEngine;

    /**测试数据库连接*/
    @Test
    public void queryLeaveInfos(){
        logger.debug(" -- Junit 测试开始 -- ");
        List<LeaveDTO> list = leaveService.queryLeaveInfos();
        if(null != list && list.size() != 0){
            for (LeaveDTO leaveDTO : list){
                logger.debug("请假人:=" + leaveDTO.getLeaveUserName());
            }
        }
    }

    /**发布流程部署*/
    @Test
    public void createDeployment(){
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment().addClasspathResource("processes/hhh.bpmn").deploy();
        logger.debug("Number of process definitions -- " + repositoryService.createProcessDefinitionQuery().count());
    }

    /**启动流程实例*/
    @Test
    public void startProcessInstance(){
        //流程定义的key
        String processDefinitionKey = "test1";
        /**启动流程实例的同时，设置流程变量，使用流程变量用来指定任务的办理人*/
//        Map<String, Object> variables = new HashMap<String, Object>();
//        variables.put("userID", "周芷若");
        //使用流程定义的key启动流程实例，key对应helloworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
        ProcessInstance pi = processEngine.getRuntimeService().startProcessInstanceByKey(processDefinitionKey);
        logger.debug("流程实例ID:"+pi.getId());// 对应ACT_RU_EXECUTION表 ID
        logger.debug("流程定义ID:"+pi.getProcessDefinitionId());//对应ACT_RE_PROCDEF表 ID
    }


    /**指定当前任务办理人*/
    @Test
    public void setAssigneeForCurrentTask(){
        //任务ID
        String taskId = "25004";
        //指定的办理人
        String userId = "张无忌";
        processEngine.getTaskService().setAssignee(taskId, userId);
    }

    /**查询当前人的个人任务*/
    @Test
    public void findMyPersonalTask(){
        String assignee = "王小二";
        //对应ACT_RE_PROCDEF 表中class路径下ID
        String processDefinitionId = "test1:1:6";
        //与正在执行的任务管理相关的Service,创建任务查询对象
        List<Task> list = processEngine.getTaskService().createTaskQuery()
                /**查询条件（where部分）*/
//                .taskAssignee(assignee)//指定个人任务查询，指定办理人
//						.taskCandidateUser(candidateUser)//组任务的办理人查询
						.processDefinitionId(processDefinitionId)//使用流程定义ID查询
//						.processInstanceId(processInstanceId)//使用流程实例ID查询
//						.executionId(executionId)//使用执行对象ID查询
                /**排序*/
                .orderByTaskCreateTime().asc()//使用创建时间的升序排列
                /**返回结果集*/
//						.singleResult()//返回惟一结果集
//						.count()//返回结果集的数量
//						.listPage(firstResult, maxResults);//分页查询
                .list();//返回列表
        if(list!=null && list.size()>0){
            for(Task task:list){
                logger.debug("任务ID:"+task.getId());
                logger.debug("任务名称:"+task.getName());
                logger.debug("任务的创建时间:"+task.getCreateTime());
                logger.debug("任务的办理人:"+task.getAssignee());
                logger.debug("流程实例ID："+task.getProcessInstanceId());
                logger.debug("执行对象ID:"+task.getExecutionId());
                logger.debug("流程定义ID:"+task.getProcessDefinitionId());
            }
        }else{
            logger.debug("未查询到任何任务");
        }

    }


    /**完成当前任务,并进入排他网关下一节点*/
    @Test
    public void completeMyPersonalTask(){
        //任务ID
        String taskId = "25004";
        //完成任务的同时，设置流程变量，使用流程变量用来指定完成任务后并进入下一个连线
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("days", 7);
        processEngine.getTaskService().complete(taskId,variables);
        logger.debug("完成任务：任务ID："+taskId);
    }

    /**结束工作流*/
    @Test
    public void completeAllProcess(){
        String taskId = "30004";
        processEngine.getTaskService().complete(taskId,null);
    }


    /**查询流程状态（判断流程正在执行，还是结束）*/
    @Test
    public void queryProcessStatus(){
        String processInstanceId = "42501";
        //表示正在执行的流程实例和执行对象,创建流程实例查询,使用流程实例ID查询
        ProcessInstance pi = processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        if(pi==null){
            logger.debug("流程已经结束");
        }
        else{
            logger.debug("流程没有结束");
        }
    }

    /**查询流程当前节点及下一节点*/
    @Test
    public void queryCurrentProcessPoint(){
        String procInstanceId = "42501";
        List<Task> tasks = processEngine.getTaskService().createTaskQuery().processInstanceId(procInstanceId).list();
        if(tasks != null && tasks.size() != 0){
            Task task = tasks.get(0);
            logger.debug("当前任务办理人： " + task.getAssignee());
            logger.debug("流程实例定义ID： " + task.getProcessDefinitionId());
            logger.debug("流程实例ID： "+task.getProcessInstanceId());
            logger.debug("父节点任务ID： "+task.getParentTaskId());
            logger.debug("任务所有者： "+task.getOwner());
            logger.debug("当前任务ID： "+task.getId());
            //然后根据当前任务获取当前流程的流程定义，然后根据流程定义获得所有的节点：
            ProcessDefinitionEntity def = (ProcessDefinitionEntity) ((RepositoryServiceImpl)processEngine.getRepositoryService()).getDeployedProcessDefinition(task.getProcessDefinitionId());
            List<ActivityImpl> activitiList = def.getActivities();  //rs是指RepositoryService的实例
            //根据任务获取当前流程执行ID，执行实例以及当前流程节点的ID：
            String excId = task.getExecutionId();
            ExecutionEntity execution = (ExecutionEntity) processEngine.getRuntimeService().createExecutionQuery().executionId(excId).singleResult();
            String activitiId = execution.getActivityId();
            //然后循环activitiList 并判断出当前流程所处节点，然后得到当前节点实例，根据节点实例获取所有从当前节点出发的路径，然后根据路径获得下一个节点实例：
            for(ActivityImpl activityImpl:activitiList){
                String id = activityImpl.getId();
                if(activitiId.equals(id)){
                    logger.debug("当前任务定义名称： "+activityImpl.getProperty("name")); //输出某个节点的某种属性
                    logger.debug("当前流程节点ID： "+activityImpl.getId());
                    logger.debug("当前流程节点类型： "+activityImpl.getProperty("type"));
                    List<PvmTransition> outTransitions = activityImpl.getOutgoingTransitions();//获取从某个节点出来的所有线路
                    for(PvmTransition tr:outTransitions){
                        PvmActivity ac = tr.getDestination(); //获取线路的终点节点
                        logger.debug("下一步任务任务定义名称："+ac.getProperty("name"));
                    }
                    break;
                }
            }
        }else{
            logger.debug("没有任何流程信息");
        }

    }

    /**查询个人历史任务 对应 ACT_HI_TASKINST 表 */
    @Test
    public void findHistoryTaskForPerson(){
        String taskAssignee = "张无忌";
        //与历史数据（历史表）相关的Service,创建历史任务实例查询,指定历史任务的办理人
        List<HistoricTaskInstance> list = processEngine.getHistoryService().createHistoricTaskInstanceQuery().taskAssignee(taskAssignee).list();
        if(list!=null && list.size()>0){
            for(HistoricTaskInstance hti:list){
                logger.debug(hti.getId()+"    "+hti.getName()+"    "+hti.getProcessInstanceId()+"   "+hti.getStartTime()+"   "+hti.getEndTime()+"   "+hti.getDurationInMillis());
                logger.debug("################################");
            }
        }
    }

    /**查询历史流程实例 对应 ACT_HI_PROCINST 表*/
    @Test
    public void findHistoryProcessInstance(){
        String processInstanceId = "15005";
        //与历史数据（历史表）相关的Service,创建历史流程实例查询,使用流程实例ID查询
        HistoricProcessInstance hpi = processEngine.getHistoryService().createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        logger.debug("流程实例ID：" + hpi.getId());
    }

    /** 查询历史流程实例 对应 ACT_HI_PROCINST 表*/
    @Test
    public void queryHistoricInstance() {
        List<HistoricProcessInstance> list = processEngine.getHistoryService().createHistoricProcessInstanceQuery().orderByProcessInstanceStartTime().asc().list();
        if (list != null && list.size() > 0) {
            for (HistoricProcessInstance hpi : list) {
                logger.debug("流程定义ID：" + hpi.getProcessDefinitionId());
                logger.debug("流程实例ID：" + hpi.getId());
                logger.debug("开始时间：" + hpi.getStartTime());
                logger.debug("结束时间：" + hpi.getEndTime());
                logger.debug("流程持续时间：" + hpi.getDurationInMillis());
                logger.debug("##########################################");
            }
        } else {
            logger.debug("无流程实例");
        }
    }


    /**查询历史活动 对应 ACT_HI_DETAIL 表*/
    @Test
    public void findHistoryActiviti(){
        String processInstanceId = "15005";
        //创建历史活动实例的查询,
        List<HistoricActivityInstance> list = processEngine.getHistoryService()
                .createHistoricActivityInstanceQuery()
                .processInstanceId(processInstanceId)
                .orderByHistoricActivityInstanceStartTime().asc()
                .list();
        if(list!=null && list.size()>0){
            for(HistoricActivityInstance hai:list){
                logger.debug(hai.getId()+"   "+hai.getProcessInstanceId()+"   "+hai.getActivityType()+"  "+hai.getStartTime()+"   "+hai.getEndTime()+"   "+hai.getDurationInMillis());
                logger.debug("#####################");
            }
        }else{
            logger.debug("没有查询到任何历史活动信息");
        }
    }

    /**查询历史任务 对应 ACT_HI_TASKINST 表*/
    @Test
    public void findHistoryTask(){
        String processInstanceId = "15005";
        List<HistoricTaskInstance> list = processEngine.getHistoryService()//与历史数据（历史表）相关的Service
                .createHistoricTaskInstanceQuery()//创建历史任务实例查询
                .processInstanceId(processInstanceId)//
                .orderByHistoricTaskInstanceStartTime().asc()
                .list();
        if(list!=null && list.size()>0){
            for(HistoricTaskInstance hti:list){
                logger.debug(hti.getId()+"    "+hti.getName()+"    "+hti.getProcessInstanceId()+"   "+hti.getStartTime()+"   "+hti.getEndTime()+"   "+hti.getDurationInMillis());
                logger.debug("################################");
            }
        }else{
            logger.debug("没有查询到任何历史任务信息");
        }
    }

    /**查询历史流程变量 对应ACT_HI_VARINST 表*/
    @Test
    public void findHistoryProcessVariables(){
        String processInstanceId = "15005";
        //创建一个历史的流程变量查询对象
        List<HistoricVariableInstance> list = processEngine.getHistoryService()
                .createHistoricVariableInstanceQuery()
                .processInstanceId(processInstanceId)
                .list();
        if(list!=null && list.size()>0){
            for(HistoricVariableInstance hvi:list){
                logger.debug(hvi.getId()+"   "+hvi.getProcessInstanceId()+"   "+hvi.getVariableName()+"   "+hvi.getVariableTypeName()+"    "+hvi.getValue());
                logger.debug("###############################################");
            }
        }else{
            logger.debug("没有查询到任何历史流程变量");
        }
    }


    /** 删除流程数据*/
    @Test
    public void deleteProcessDataByProcessKey(){
        boolean isProcessEnd = false;
        String processInstanceId = "42501";
        //表示正在执行的流程实例和执行对象,创建流程实例查询,使用流程实例ID查询
        ProcessInstance pi = processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        if(pi==null){
            logger.debug("流程已经结束");
            isProcessEnd = true;
        }
        else{
            logger.debug("流程没有结束");
        }

        if (isProcessEnd) {
            // 删除历史流程
            processEngine.getHistoryService().deleteHistoricProcessInstance(processInstanceId);
        } else {
            processEngine.getRuntimeService().deleteProcessInstance(processInstanceId, null);
        }
    }




}
