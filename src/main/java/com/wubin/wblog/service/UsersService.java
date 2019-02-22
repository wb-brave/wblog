package com.wubin.wblog.service;

import com.wubin.wblog.entity.Users;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wubin
 * @since 2019-02-17
 */
public interface UsersService extends IService<Users> {

    Users login(String username,String password);

    void doRegister(Users users);
}
