package com.umfintech.activitimiddleware.service;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.*;

public class HistoryHandlerTest {
    private Logger logger = LoggerFactory.getLogger(HistoryHandlerTest.class);
    private HistoryHandler hh = new HistoryHandler();

    @Test
    public void getAllHistoryProcessInstance() {
        List<HistoricProcessInstance> list = hh.getAllHistoryProcessInstance();
        for (HistoricProcessInstance hpi : list) {
            logger.info("-----------------------");
            logger.info("ProcessInstance ID: " + hpi.getId());
            logger.info("ProcessDefinitionHandler ID: " + hpi.getProcessDefinitionId());
            logger.info("StartTime: " + hpi.getStartTime());
            logger.info("EndTime: " + hpi.getEndTime());
            logger.info("DurationInMillis: " + hpi.getDurationInMillis());
        }
    }

    @Test
    public void getHistoryProcessInstanceByProcessInstanceID() {
        HistoricProcessInstance hpi = hh.getHistoryProcessInstanceByProcessInstanceID("10001");
        logger.info("-----------------------");
        logger.info("ProcessInstance ID: " + hpi.getId());
        logger.info("ProcessDefinitionHandler ID: " + hpi.getProcessDefinitionId());
        logger.info("StartTime: " + hpi.getStartTime());
        logger.info("EndTime: " + hpi.getEndTime());
        logger.info("DurationInMillis: " + hpi.getDurationInMillis());
    }

    @Test
    public void getAllHistoryTask() {
        List<HistoricTaskInstance> list = hh.getAllHistoryTask();
        for (HistoricTaskInstance hti : list) {
            logger.info("-----------------------");
            logger.info("Task ID: " + hti.getId());
            logger.info("Task Name: " + hti.getName());
            logger.info("ProcessInstance ID: " + hti.getProcessInstanceId());
            logger.info("StartTime: " + hti.getStartTime());
            logger.info("EndTime: " + hti.getEndTime());
            logger.info("DurationInMillis: " + hti.getDurationInMillis());
        }
    }

    @Test
    public void getHistoryTaskByUserID() {
        List<HistoricTaskInstance> list = hh.getHistoryTaskByUserID("smallyu");
        for (HistoricTaskInstance hti : list) {
            logger.info("-----------------------");
            logger.info("Task ID: " + hti.getId());
            logger.info("Task Name: " + hti.getName());
            logger.info("ProcessInstance ID: " + hti.getProcessInstanceId());
            logger.info("StartTime: " + hti.getStartTime());
            logger.info("EndTime: " + hti.getEndTime());
            logger.info("DurationInMillis: " + hti.getDurationInMillis());
        }
    }
}