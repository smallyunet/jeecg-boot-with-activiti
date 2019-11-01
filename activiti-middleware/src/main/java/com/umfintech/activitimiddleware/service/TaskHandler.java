/* CopyRight UMF */
package com.umfintech.activitimiddleware.service;

import org.activiti.engine.ActivitiObjectNotFoundException;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @description 任务相关操作
 * @author wangyu
 * @date 2019/11/1 13:20
 */
public class TaskHandler {

    private Logger logger = LoggerFactory.getLogger(TaskHandler.class);
    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    private TaskService taskService = processEngine.getTaskService();

    /**
     * @description 获取全部任务
     * @return list
     */
    public List<Task> getAllTask() {
        List<Task> list = taskService
                .createTaskQuery()  //创建查询任务对象
                .list();
        logger.info("[查询任务列表] [全部] 共 " + list.size() + " 条记录");
        return list;
    }

    /**
     * @description 根据userID获取全部任务
     * @param userID
     * @return
     */
    public List<Task> getTaskByUserID(String userID) {
        List<Task> list = taskService
                .createTaskQuery()  //创建查询任务对象
                .taskAssignee(userID)
                .list();
        logger.info("[查询任务列表] [userID=" + userID + "] 共 " + list.size() + " 条记录");
        return list;
    }

    /**
     * @description 委派任务
     * @param taskID
     * @param userID
     * @return
     */
    public boolean taskAssignee(String taskID, String userID) {
        try {
            taskService.setAssignee(taskID, userID);
        } catch (ActivitiObjectNotFoundException e) {
            logger.error("[任务委派失败] " + e.getMessage());
            return false;
        }
        logger.info("[任务委派成功] 任务ID: " + taskID + ", 用户ID: " + userID);
        return true;
    }

    /**
     * @description 根据taskID完成任务
     * @param taskID
     */
    public boolean completeTaskByTaskID(String taskID){
        try {
            processEngine.getTaskService()
                    .complete(taskID);
        } catch (ActivitiObjectNotFoundException e) {
            logger.info("[任务完成操作失败] " + e.getMessage());
            return false;
        }
        logger.info("[任务完成操作成功] [taskID=" + taskID + "]");
        return true;
    }

    /**
     * @description 根据taskID删除任务
     * @param taskID
     */
    public boolean deleteTaskByTaskID(String taskID){
        try {
            processEngine.getTaskService()
                    .deleteTask(taskID, true);
        } catch (ActivitiObjectNotFoundException e) {
            logger.info("[任务删除操作失败] " + e.getMessage());
            return false;
        }
        logger.info("[任务删除操作成功] [taskID=" + taskID + "]");
        return true;
    }
}
