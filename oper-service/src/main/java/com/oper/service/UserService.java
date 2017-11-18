package com.oper.service;

import com.oper.bean.ApiResultBean;
import com.oper.entity.User;

/**
 * @author yemingfeng
 */
public interface UserService {

  ApiResultBean register(User user);

  ApiResultBean login(User user);

  ApiResultBean findAll();

}