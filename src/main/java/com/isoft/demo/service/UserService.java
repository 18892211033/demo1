package com.isoft.demo.service;

import com.isoft.demo.entity.User;

import java.util.Map;

public interface UserService {

    boolean updatePhoto(User users);

    int updatePass(Integer id , String oldPass , String newPass);

}
