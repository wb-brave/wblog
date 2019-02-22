package com.wubin.wblog.dao;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.wubin.wblog.entity.Users;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wubin
 * @since 2019-02-17
 */
public interface UsersMapper extends BaseMapper<Users> {

    List<Users> selectLists(Map param);
}
