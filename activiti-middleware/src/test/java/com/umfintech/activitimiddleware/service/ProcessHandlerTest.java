package com.umfintech.activitimiddleware.service;

import org.junit.Assert;
import org.junit.Test;

public class ProcessHandlerTest {
    private ProcessHandler ps = new ProcessHandler();

    @Test
    public void startProcessInstance() {
        Assert.assertEquals(false, ps.startProcessInstance("aabbcc"));
//        Assert.assertEquals(true, ps.startProcessInstance("myProcess_1"));
    }

    @Test
    public void isProcessEnd(){
        Assert.assertTrue(ps.isProcessEnd("6666"));
        Assert.assertFalse(ps.isProcessEnd("10001"));
    }
}