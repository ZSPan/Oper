package com.oper.test.service;

import com.oper.OperApplication;
import com.oper.entity.User;
import com.oper.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author yemingfeng
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OperApplication.class)
@WebAppConfiguration
public class UserServiceTest {

  @Autowired
  private UserService userService;

  @Test
  public void testLogin() {
    User user = new User();
    user.setPassword("123456");
    user.setEmail("393162333@qq.com");
    userService.login(user);
  }
}