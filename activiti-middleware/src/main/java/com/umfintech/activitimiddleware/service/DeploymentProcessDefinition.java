/* CopyRight UMF */
package com.umfintech.activitimiddleware.service;

import org.activiti.engine.ActivitiIllegalArgumentException;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description 部署流程
 * @author wangyu
 * @date 2019/11/1 10:46
 */
public class DeploymentProcessDefinition {

    private Logger logger = LoggerFactory.getLogger(DeploymentProcessDefinition.class);
    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    public boolean deploymentProcessDefinition_classpath(String name){
        Deployment deployment = null;//完成部署
        try {
            deployment = processEngine.getRepositoryService()//与流程定义和部署对象相关的Service
                    .createDeployment()//创建一个部署对象
                    .name(name)//添加部署的名称
                    .addClasspathResource("diagrams/" + name + ".bpmn") //从classpath的资源中加载，一次只能加载一个文件
                    //.addClasspathResource("diagrams/" + name + ".png") //从classpath的资源中加载，一次只能加载一个文件
                    .deploy();
        } catch (ActivitiIllegalArgumentException e) {
            logger.error("[部署失败] " + e.getMessage());
            return false;
        }
        logger.info("[部署成功] ID：" + deployment.getId() + ", 名称：" + deployment.getName());
        return true;
    }
}
