/* CopyRight UMF */
package com.umfintech.activitimiddleware.service;

import org.activiti.engine.ActivitiObjectNotFoundException;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description 流程控制
 * @author wangyu
 * @date 2019/11/1 13:46
 */
public class ProcessHandler {

    private Logger logger = LoggerFactory.getLogger(ProcessHandler.class);
    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    public boolean startProcessInstance(String name){
        ProcessInstance processInstance = null;
        try {
            //获取与正在执行的流程示例和执行对象相关的Service
            processInstance = processEngine.getRuntimeService()
                    //使用流程定义的key启动实例，key对应bpmn文件中id的属性值，默认按照最新版本流程启动
                    .startProcessInstanceByKey(name);
        } catch (ActivitiObjectNotFoundException e) {
            logger.error("[流程实例启动失败] " + e.getMessage());
            return false;
        }
        logger.info("[流程实例启动成功] 流程实例ID: " + processInstance.getId() + "流程模板ID：" + processInstance.getProcessDefinitionId());
        return true;
    }
}
