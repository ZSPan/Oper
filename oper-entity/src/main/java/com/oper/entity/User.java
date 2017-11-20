package com.oper.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

/**
 * @author yemingfeng
 */
@Data
@Table(name = "user")
@Entity
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NotNull(message = "nickname is empty")
  private String nickname;
  @NotNull(message = "email is empty")
  @Pattern(regexp = "^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$",
      message = "email invalid")
  private String email;
  @NotNull(message = "password is empty")
  private String password;
  private String lastLoginTime;
  private String lastLoginIp;

}