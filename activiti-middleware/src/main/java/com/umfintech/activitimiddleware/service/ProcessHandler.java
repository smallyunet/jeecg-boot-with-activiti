/* CopyRight UMF */
package com.umfintech.activitimiddleware.service;

import org.activiti.engine.ActivitiObjectNotFoundException;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @description 流程控制
 * @author wangyu
 * @date 2019/11/1 13:46
 */
public class ProcessHandler {

    private Logger logger = LoggerFactory.getLogger(ProcessHandler.class);
    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    private RuntimeService runtimeService = processEngine.getRuntimeService();

    /**
     * @description 启动流程实例
     * @param name
     * @return
     */
    public boolean startProcessInstance(String name){
        ProcessInstance processInstance = null;
        try {
            //获取与正在执行的流程示例和执行对象相关的Service
            processInstance = runtimeService
                    //使用流程定义的key启动实例，key对应bpmn文件中id的属性值，默认按照最新版本流程启动
                    .startProcessInstanceByKey(name);
        } catch (ActivitiObjectNotFoundException e) {
            logger.error("[流程实例启动失败] " + e.getMessage());
            return false;
        }
        logger.info("[流程实例启动成功] 流程实例ID: " + processInstance.getId() + " 流程模板ID：" + processInstance.getProcessDefinitionId());
        return true;
    }

    /**
     * @description 查询所有流程实例
     * @return
     */
    public  List<ProcessInstance> getAllProcessInstance(){
        List<ProcessInstance> list = runtimeService//表示正在执行的流程实例和执行对象
                .createProcessInstanceQuery()//创建流程实例查询
                .list();
        logger.info("[查询全部流程] 共 " + list.size() + " 条记录");
        return list;
    }

    /**
     * @description 查询流程是否结束
     * @param processInstanceId
     * @return
     */
    public boolean isProcessInstanceEnd(String processInstanceId){
        ProcessInstance pi = runtimeService//表示正在执行的流程实例和执行对象
                .createProcessInstanceQuery()//创建流程实例查询
                .processInstanceId(processInstanceId)//使用流程实例ID查询
                .singleResult();
        if (pi == null){
            logger.info("[查询流程状态] [processInstanceId=" + processInstanceId + "] 流程已经结束，或者流程不存在");
            return true;
        } else {
            logger.info("[查询流程状态] [processInstanceId=" + processInstanceId + "] 流程未结束");
            return false;
        }
    }
}
