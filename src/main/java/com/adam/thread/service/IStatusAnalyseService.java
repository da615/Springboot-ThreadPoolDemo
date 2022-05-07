package com.adam.thread.service;

/**
 * 参数分析基础Service,所有需要进行参数分析的都需要实现该接口
 *
 * @author YuXD
 */
public interface IStatusAnalyseService {

    /**
     * 设备状态解析处理
     *
     * @param start 开始时间
     * @param end  截止时间
     */
    void doStatusAnalyseHandle(String start, String end);

    /**
     * 设备状态解析处理
     *
     * @param end 截止时间
     */
    void doStatusAnalyseHandle(String end);

    /**
     * 获取数据类别
     *
     * @return
     */
    String getDataType();

}
