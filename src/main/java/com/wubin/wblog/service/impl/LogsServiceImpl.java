package com.wubin.wblog.service.impl;

import com.wubin.wblog.entity.Logs;
import com.wubin.wblog.dao.LogsMapper;
import com.wubin.wblog.service.LogsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wubin.wblog.utils.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wubin
 * @since 2019-02-17
 */
@Service
public class LogsServiceImpl extends ServiceImpl<LogsMapper, Logs> implements LogsService {

    @Autowired
    private LogsMapper logsMapper;
    @Override
    public void insertLog(String action, String data, String ip, Integer authorId) {
        Logs logs = new Logs();
        logs.setAction(action);
        logs.setData(data);
        logs.setIp(ip);
        logs.setAuthorId(authorId);
        logs.setCreated(DateKit.getCurrentUnixTime());
        logsMapper.insert(logs);
    }
}
