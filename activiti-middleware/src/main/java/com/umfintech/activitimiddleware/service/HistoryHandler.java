/* CopyRight UMF */
package com.umfintech.activitimiddleware.service;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author wangyu
 * @date 2019/11/1 14:58
 */
public class HistoryHandler {

    private Logger logger = LoggerFactory.getLogger(HistoryHandler.class);
    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    private HistoryService historyService = processEngine.getHistoryService();

    /**
     * @description 查询所有流程实例
     * @return
     */
    public List<HistoricProcessInstance> getAllHistoryProcessInstance(){
        List<HistoricProcessInstance> list = historyService//与历史数据（历史表）相关的Service
                .createHistoricProcessInstanceQuery()//创建历史流程实例查询
                .list();
        logger.info("[查询历史全部流程实例] 共 " + list.size() + " 条记录");
        return list;
    }

    /**
     * @description 根据processInstanceID查询流程实例
     * @param processInstanceID
     * @return
     */
    public HistoricProcessInstance getHistoryProcessInstanceByProcessInstanceID(String processInstanceID){
        HistoricProcessInstance hpi = historyService//与历史数据（历史表）相关的Service
                .createHistoricProcessInstanceQuery()//创建历史流程实例查询
                .processInstanceId(processInstanceID)//使用流程实例ID查询
                .singleResult();
        logger.info("[查询历史流程实例] [processInstanceID=" + processInstanceID + "]");
        return hpi;
    }

    /**
     * @description 查询所有历史任务
     * @return
     */
    public List<HistoricTaskInstance> getAllHistoryTask(){
        List<HistoricTaskInstance> list = processEngine.getHistoryService()//与历史数据（历史表）相关的Service
                .createHistoricTaskInstanceQuery()//创建历史任务实例查询
                .list();
        logger.info("[查询历史全部任务] 共 " + list.size() + " 条记录");
        return list;
    }

    /**
     * @description 根据userID查询所有历史任务
     * @param userID
     * @return
     */
    public List<HistoricTaskInstance> getHistoryTaskByUserID(String userID){
        List<HistoricTaskInstance> list = processEngine.getHistoryService()//与历史数据（历史表）相关的Service
                .createHistoricTaskInstanceQuery()//创建历史任务实例查询
                .taskAssignee(userID)//指定历史任务的办理人
                .list();
        logger.info("[查询历史任务] [userID=" + userID + "] 共 " + list.size() + " 条记录");
        return list;
    }
}
