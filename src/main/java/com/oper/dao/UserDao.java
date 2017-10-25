package com.oper.dao;


import com.oper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author yemingfeng
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

  @Query("SELECT user FROM User user WHERE email = :email")
  User getByEmail(@Param("email") String email);

  @Query("SELECT user FROM User user WHERE nickname = :nickname")
  User getByNickname(@Param("nickname") String nickname);

}