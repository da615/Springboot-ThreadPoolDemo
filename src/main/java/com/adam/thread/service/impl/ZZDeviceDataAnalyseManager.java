package com.adam.thread.service.impl;

import org.springframework.stereotype.Service;

/**
 * @description: 总装设备数据分析Service实现类
 * @author: YuXD
 * @create: 2020-06-18 22:56
 **/
@Service("ZZ")
public class ZZDeviceDataAnalyseManager extends AbstractDeviceDataAnalyseManager {

    @Override
    public String getDataType() {
        return "总装";
    }

}