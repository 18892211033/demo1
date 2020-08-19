package com.isoft.demo.service.impl;

import com.isoft.demo.dao.UserDao;
import com.isoft.demo.entity.User;
import com.isoft.demo.service.UserService;
import com.isoft.demo.util.MD5Util;
import com.isoft.demo.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean updatePhoto(User user) {
        if (null == user || user.getUserId() == null || user.getUserId() < 1 || StringUtil.isEmpty(user.getUserPhotoUrl())){
            return false;
        }
        return userDao.update(user) > 0;
    }

    @Override
    public int updatePass(Integer id , String oldPass , String newPass) {
        if (null == id || id < 1 || StringUtil.isEmpty(oldPass) || StringUtil.isEmpty(newPass)){
            return 2;
        }
        if (userDao.getPassCounts(id , MD5Util.MD5(oldPass)) < 1 ){
            return 1;
        }
        User u = new User();
        u.setUserId(id);
        u.setUserPass(MD5Util.MD5(newPass));
        return userDao.update(u) >0 ? 0 : 2 ;
    }

}
