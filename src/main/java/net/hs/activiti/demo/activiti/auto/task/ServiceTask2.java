package net.hs.activiti.demo.activiti.auto.task;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Project ： net.hs.activiti.demo
 * PackageName ： net.hs.activiti.demo.activiti.auto.task
 * Author ： caijl
 * Date ： 2017/8/14
 * Time ： 15:58
 * Description :
 * 系统版本 ： 1.0
 */
public class ServiceTask2 implements JavaDelegate {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(DelegateExecution arg0) throws Exception {
        logger.debug(" 我是 Task 2 ");
    }

}
