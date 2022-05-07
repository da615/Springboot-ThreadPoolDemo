package com.adam.thread.service.impl;

import com.adam.thread.service.IStatusAnalyseService;
import org.springframework.scheduling.annotation.Async;

import java.util.Random;

/**
 * 抽象的设备数据分析Manager
 *
 * @author YuXD
 * @since 2020-06-18 22:47
 */
public abstract class AbstractDeviceDataAnalyseManager implements IStatusAnalyseService {

    @Async("customizeThreadPool")
    @Override
    public void doStatusAnalyseHandle(String start, String end) {
        int sleepSeconds = new Random().nextInt(3) + 1;
        try {
            Thread.sleep(sleepSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getDataType() + "在自定义线程" + Thread.currentThread().getName() + "执行了" + sleepSeconds + "秒");
    }

    @Async
    @Override
    public void doStatusAnalyseHandle(String end) {
        int sleepSeconds = new Random().nextInt(3) + 1;
        try {
            Thread.sleep(sleepSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getDataType() + "在默认线程" + Thread.currentThread().getName() + "执行了" + sleepSeconds + "秒");
    }
}
