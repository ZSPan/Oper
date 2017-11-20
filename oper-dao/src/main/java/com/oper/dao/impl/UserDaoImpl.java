package com.oper.dao.impl;

import com.oper.dao.UserDao;
import com.oper.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author yemingfeng
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

  @Autowired
  private EntityManager entityManager;

  @Override
  public User save(User user) {
    entityManager.persist(user);
    return user;
  }

  @Override
  public User getByEmail(String email) {
    return (User) entityManager
        .createQuery("SELECT user FROM User user WHERE user.email = :email")
        .setParameter("email", email)
        .getSingleResult();
  }

  @Override
  public User getByNickname(String nickname) {
    return (User) entityManager
        .createQuery("SELECT user FROM User user WHERE user.nickname = :nickname")
        .setParameter("nickname", nickname)
        .getSingleResult();
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<User> findAll() {
    return entityManager.createQuery("select user FROM User user")
        .getResultList();
  }
}