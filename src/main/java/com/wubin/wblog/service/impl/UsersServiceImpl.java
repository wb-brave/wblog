package com.wubin.wblog.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wubin.wblog.entity.Users;
import com.wubin.wblog.dao.UsersMapper;
import com.wubin.wblog.exception.WblogException;
import com.wubin.wblog.service.UsersService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wubin.wblog.utils.WBlogUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wubin
 * @since 2019-02-17
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    @Resource
    private UsersMapper usersMapper;

    @Override
    public Users login(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new WblogException("用户名或密码不能为空！");
        }
        EntityWrapper<Users> ew = new EntityWrapper<>();
        Map<String, String> params = new HashMap<>();
        /**
         * 使用MD5加密后的密码
         */
        String md5pw = WBlogUtils.MD5encode(password);
        params.put("username", username);
        params.put("password", md5pw);
        //根据用户名和密码查询数据
        // List<Users> usersList = usersMapper.selectLists(params);
        List<Users> usersList = usersMapper.selectList(ew.eq("username",username).eq("password",md5pw));
        if (usersList.size() == 1) {
            return usersList.get(0);
        } else {
            throw new WblogException("用户名或密码错误");
        }
    }

    @Override
    public void doRegister(Users users) {

    }
}
