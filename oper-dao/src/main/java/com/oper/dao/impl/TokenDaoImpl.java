package com.oper.dao.impl;

import com.oper.dao.TokenDao;
import com.oper.entity.Token;
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
public class TokenDaoImpl implements TokenDao {

  @Autowired
  private EntityManager entityManager;

  @Override
  public void save(Token token) {
    entityManager.persist(token);
  }

  @Override
  public Token getByToken(String token) {
    return (Token) entityManager
        .createQuery("SELECT t FROM Token t WHERE t.token = :token")
        .setParameter("token", token)
        .getSingleResult();
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Token> listByUser(User user) {
    return entityManager
        .createQuery("SELECT t FROM Token t WHERE t.user = :user")
        .setParameter("user", user)
        .getResultList();
  }
}