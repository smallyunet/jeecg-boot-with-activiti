/* CopyRight UMF */
package org.jeecg.modules.flow.controller;

import cn.hutool.json.JSONArray;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umfintech.activitimiddleware.service.TaskHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.task.Task;
import org.jeecg.common.api.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangyu
 * @date 2019/11/1 15:34
 */
@Slf4j
@RestController
@RequestMapping("/flow/task")
@Api(tags="工作流任务")
public class TaskController {

    private TaskHandler ts = new TaskHandler();

    @ApiOperation("查询全部")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Result<JSONArray> all() {
        List<Task> list = ts.getAllTask();
        Result<JSONArray> result = new Result<JSONArray>();
        JSONArray jsonArray = new JSONArray(list);
        result.setResult(jsonArray);
        return result;
    }
}
