package com.wubin.wblog.service;

import com.wubin.wblog.entity.Logs;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wubin
 * @since 2019-02-17
 */
public interface LogsService extends IService<Logs> {

    void insertLog(String action, String data, String ip, Integer authorId);
}
