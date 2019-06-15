package com.lhl.concurrency.demo.threadlocal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lihongli on 2019/5/22
 */
@RestController
@RequestMapping("threadLocal")
public class ThreadLocalController {

    @RequestMapping("/test")
    public Long test(){
        return RequestHolder.getId();
    }
}
