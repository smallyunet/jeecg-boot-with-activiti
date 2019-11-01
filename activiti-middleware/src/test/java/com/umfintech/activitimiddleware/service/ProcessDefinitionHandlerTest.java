/* CopyRight UMF */
package com.umfintech.activitimiddleware.service;

import org.activiti.engine.repository.ProcessDefinition;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author wangyu
 * @date 2019/11/1 13:29
 */
public class ProcessDefinitionHandlerTest {
    private Logger logger = LoggerFactory.getLogger(ProcessDefinitionHandlerTest.class);
    ProcessDefinitionHandler dpf = new ProcessDefinitionHandler();

    @Test
    public void deploymentProcessDefinition_classpath(){
        Assert.assertEquals(false, dpf.deploymentProcessDefinition_classpath("aabbcc"));
    }

    @Test
    public void getHistoryTaskByUserID(){
        List<ProcessDefinition> list = dpf.getAllProcessDefinition();
        for(ProcessDefinition pd:list){
            logger.info("-------------------------");
            logger.info("流程定义ID: "+pd.getId());//流程定义的key+版本+随机生成数
            logger.info("流程定义的名称: "+pd.getName());//对应helloworld.bpmn文件中的name属性值
            logger.info("流程定义的key: "+pd.getKey());//对应helloworld.bpmn文件中的id属性值
            logger.info("流程定义的版本: "+pd.getVersion());//当流程定义的key值相同的相同下，版本升级，默认1
            logger.info("资源名称bpmn文件: "+pd.getResourceName());
            logger.info("资源名称png文件: "+pd.getDiagramResourceName());
            logger.info("部署对象ID: "+pd.getDeploymentId());
        }
    }
}
