package com.oper.entity;

import lombok.Data;

/**
 * @author yemingfeng
 */
@Data
public class User {

  private Long id;
  private String nickname;
  private String password;
  private String lastLoginTime;
  private String lastLoginIp;

}