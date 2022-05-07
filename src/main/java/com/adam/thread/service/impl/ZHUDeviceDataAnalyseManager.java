package com.adam.thread.service.impl;

import org.springframework.stereotype.Service;

/**
 * @description: 铸造设备数据分析Service实现类
 * @author: YuXD
 * @create: 2020-06-18 22:56
 **/
@Service("ZHU")
public class ZHUDeviceDataAnalyseManager extends AbstractDeviceDataAnalyseManager {

    @Override
    public String getDataType() {
        return "铸造";
    }

}