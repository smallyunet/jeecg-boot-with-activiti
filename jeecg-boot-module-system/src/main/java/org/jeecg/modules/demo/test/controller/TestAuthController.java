/* CopyRight UMF */
package org.jeecg.modules.demo.test.controller;

import com.umfintech.activitimiddleware.test.TestService;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyu
 * @date 2019/10/31 13:48
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestAuthController {

    @GetMapping("/auth")
    public Result<?> test() {
        String res = new TestService().test();
        return Result.ok(res);
    }

}
