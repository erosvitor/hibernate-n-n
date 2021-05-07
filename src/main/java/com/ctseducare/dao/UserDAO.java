package com.ctseducare.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ctseducare.hibernate.HibernateUtils;
import com.ctseducare.model.User;

public class UserDAO extends DAO<User> {

  public UserDAO() {
    super(User.class);
  }
  
  public User findByName(String name) {
    String hql = "FROM User WHERE name = :name";
    
    Session session = HibernateUtils.getSessionFactory().openSession();
    
    TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
    typedQuery.setParameter("name", name);
    
    User user = typedQuery.getSingleResult();
    
    session.close();
    
    return user;
  }
  
  public void removeAll() throws Exception {
    Session session = HibernateUtils.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();

      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaDelete<User> delete = cb.createCriteriaDelete(User.class);
      delete.from(User.class);

      Query query = session.createQuery(delete);
      query.executeUpdate();

      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw new Exception(e);
    } finally {
      session.close();
    }
  }
  
  
  public List<User> findUsersWithProfile(Integer profileId) {
    String hql = "SELECT u FROM User u JOIN u.profiles p WHERE p.id = :profileId";
    
    Session session = HibernateUtils.getSessionFactory().openSession();
    
    TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
    typedQuery.setParameter("profileId", profileId);
    
    List<User> users = typedQuery.getResultList();
    
    session.close();
    
    return users;
  }

}
