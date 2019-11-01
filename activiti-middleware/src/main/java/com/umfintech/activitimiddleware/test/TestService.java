/* CopyRight UMF */
package com.umfintech.activitimiddleware.test;

import org.activiti.engine.*;

/**
 * @description 测试程序有没有跑通
 * @author wangyu
 * @date 2019/10/31 17:36
 */
public class TestService {
    // 实例化引擎，访问数据库
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    //管理流程定义
    RepositoryService repositoryService = processEngine.getRepositoryService();
    //执行管理，包括启动、推进、删除流程实例等
    RuntimeService runtimeService = processEngine.getRuntimeService();
    //任务管理
    TaskService taskService = processEngine.getTaskService();
    //历史管理（执行完的数据的管理
    HistoryService historyService = processEngine.getHistoryService();
    //组织机构管理
    IdentityService identityService = processEngine.getIdentityService();
    //可选服务，任务表单管理
    FormService formService = processEngine.getFormService();
    // ...
    ManagementService managementService = processEngine.getManagementService();

    public String test() {
        System.out.println("enter test");
        System.out.println(repositoryService);
        System.out.println(runtimeService);
        System.out.println(taskService);
        System.out.println(historyService);
        System.out.println(identityService);
        System.out.println(formService);
        System.out.println(managementService);
        return "ok";
    }

    public static void main(String[] args) {
        new TestService().test();
    }
}
