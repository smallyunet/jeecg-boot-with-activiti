package com.umfintech.activitimiddleware.service;

import org.junit.Assert;
import org.junit.Test;

public class ProcessHandlerTest {

    @Test
    public void startProcessInstance() {
        ProcessHandler ps = new ProcessHandler();
        Assert.assertEquals(false, ps.startProcessInstance("aabbcc"));
//        Assert.assertEquals(true, ps.startProcessInstance("myProcess_1"));
    }
}