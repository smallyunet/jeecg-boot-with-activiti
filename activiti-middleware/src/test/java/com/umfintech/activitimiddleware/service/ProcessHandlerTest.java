package com.umfintech.activitimiddleware.service;

import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProcessHandlerTest {
    private ProcessHandler ps = new ProcessHandler();

    @Test
    public void startProcessInstance() {
//        Assert.assertEquals(false, ps.startProcessInstance("aabbcc"));
        Assert.assertEquals(true, ps.startProcessInstance("myProcess_1"));
    }

    @Test
    public void getAllProcessInstance(){
        List<ProcessInstance> list = ps.getAllProcessInstance();
        for (ProcessInstance pi : list) {
            System.out.println(pi.toString());
        }
    }

    @Test
    public void isProcessInstanceEnd(){
        Assert.assertFalse(ps.isProcessInstanceEnd("17501"));
        Assert.assertFalse(ps.isProcessInstanceEnd("17501"));
        Assert.assertFalse(ps.isProcessInstanceEnd("10001"));
    }
}