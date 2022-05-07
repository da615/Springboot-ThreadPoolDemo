package com.adam.thread.service.impl;

import org.springframework.stereotype.Service;

/**
 * @description: 机加设备数据分析Service实现类
 * @author: YuXD
 * @create: 2021-03-15 20:17
 **/
@Service("JJ")
public class JJDeviceDataAnalyseManager extends AbstractDeviceDataAnalyseManager {

    @Override
    public String getDataType() {
        return "机加";
    }

}