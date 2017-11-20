package com.oper.service.impl;

import com.oper.bean.ApiResultBean;
import com.oper.dao.UserDao;
import com.oper.entity.Token;
import com.oper.entity.User;
import com.oper.exception.UnAuthorizedException;
import com.oper.helper.CoderHelper;
import com.oper.service.TokenService;
import com.oper.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yemingfeng
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Autowired
  private TokenService tokenService;

  @Override
  public ApiResultBean register(User user) {
    return ApiResultBean.succeed(userDao.save(user));
  }

  @Override
  public ApiResultBean login(User user) {
    User dbUser = userDao.getByEmail(user.getEmail());
    if (dbUser == null) {
      throw new UnAuthorizedException();
    } else if (!StringUtils.equals(CoderHelper.md5(user.getPassword()), dbUser.getPassword())) {
      throw new UnAuthorizedException();
    }

    Token token = tokenService.generateToken(user);
    tokenService.save(token);

    return ApiResultBean.succeed(token);
  }

  @Override
  public ApiResultBean findAll() {
    return ApiResultBean.succeed(userDao.findAll());
  }
}