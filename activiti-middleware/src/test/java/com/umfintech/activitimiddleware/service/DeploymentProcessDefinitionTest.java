/* CopyRight UMF */
package com.umfintech.activitimiddleware.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wangyu
 * @date 2019/11/1 13:29
 */
public class DeploymentProcessDefinitionTest {

    @Test
    public void deploymentProcessDefinition_classpath(){
        DeploymentProcessDefinition dpf = new DeploymentProcessDefinition();
        Assert.assertEquals(false, dpf.deploymentProcessDefinition_classpath("aabbcc"));
    }
}
