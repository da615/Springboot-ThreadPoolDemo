package com.adam.thread.controller;

import com.adam.thread.service.IStatusAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ThreadDemoController {

    @Autowired
    private List<IStatusAnalyseService> statusAnalyseServiceList;


    @GetMapping("/sayHelloAsync")
    public String sayHelloAsync() {
        for (IStatusAnalyseService statusAnalyseService : statusAnalyseServiceList) {
            // 采用自定义线程池
            statusAnalyseService.doStatusAnalyseHandle(null, null);
            // 采用默认线程池
            statusAnalyseService.doStatusAnalyseHandle(null);
        }
        return "Hello, Async!";
    }
}
