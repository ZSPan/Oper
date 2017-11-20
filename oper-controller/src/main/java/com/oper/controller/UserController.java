package com.oper.controller;

import com.oper.bean.ApiResultBean;
import com.oper.entity.User;
import com.oper.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yemingfeng
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "", method = RequestMethod.GET)
  @ResponseBody
  public ApiResultBean findAll() {
    return userService.findAll();
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  @ResponseBody
  public ApiResultBean register(@RequestBody @Valid User user) {
    return userService.register(user);
  }

}