package com.oper.service.impl;

import com.oper.bean.ApiResultBean;
import com.oper.dao.UserDao;
import com.oper.entity.User;
import com.oper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yemingfeng
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  public ApiResultBean register(User user) {
    return ApiResultBean.succeed(userDao.save(user));
  }

  @Override
  public ApiResultBean login(User user) {
    return ApiResultBean.succeed(user);
  }

  @Override
  public ApiResultBean findAll() {
    return ApiResultBean.succeed(userDao.findAll());
  }
}