package com.isoft.demo;

import com.isoft.demo.controller.UserController;
import com.isoft.demo.dao.UserDao;
import com.isoft.demo.entity.User;
import com.isoft.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;
    @Autowired
    UserController userController;
    @Test
    void contextLoads() {
//        int i =userDao.getPassCounts(1,"123123");
//        System.out.println(i);
//        User user = new User(1,"王思桐","123456","18892211033","361687699@qq.com",new Date(),"1","333.png");
//        System.out.println(userDao.update(user));
//        System.out.println(userService.updatePass(1,"123456","123123"));
//        Map map = new HashMap();
//        map.put("id",1);
//        map.put("oldpass","123123");
//        map.put("newpass","123123");
//        System.out.println(userController.updatePassword(map));
    }

}
