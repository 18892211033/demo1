package com.isoft.demo.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.isoft.demo.entity.User;
import com.isoft.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class UserDao{
    @Autowired
    UserMapper userMapper;
    QueryWrapper<User> queryWrapper = new QueryWrapper<>() ;
    public int getPassCounts(Integer userId, String userPass){
        int i = userMapper.getPassCounts(userId,userPass);
        return i < 1  ? 0 : 1 ;
    }
    public int update(User user){
        int i = userMapper.update(user);
        return i < 1  ? 0 : 1 ;
    }

}
