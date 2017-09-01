package net.hs.activiti.demo.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * Project ： hs.net.activiti.demo
 * PackageName ： net.hs.activiti.demo.listener
 * Author ： caijl
 * Date ： 2017/7/31
 * Time ： 13:45
 * Description :
 * 系统版本 ： 1.0
 */
public class TaskListenerImpl implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask){
        //此处可以从数据库查询指定任务办理人
        delegateTask.setAssignee("王小二");
    }

}
