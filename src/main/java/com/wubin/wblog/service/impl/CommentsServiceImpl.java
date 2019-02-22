package com.wubin.wblog.service.impl;

import com.wubin.wblog.entity.Comments;
import com.wubin.wblog.dao.CommentsMapper;
import com.wubin.wblog.service.CommentsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

}
