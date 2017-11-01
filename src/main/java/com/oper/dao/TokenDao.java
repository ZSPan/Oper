package com.oper.dao;

import com.oper.entity.Token;
import com.oper.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author yemingfeng
 */
public interface TokenDao extends JpaRepository<Token, Long> {

  @Query("SELECT token from Token token where token.token = :token")
  Token getByToken(@Param("token") String token);

  @Query("SELECT token from Token token where token.user = :user")
  List<Token> listByUser(@Param("user") User user);

}