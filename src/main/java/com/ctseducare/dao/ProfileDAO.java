package com.ctseducare.dao;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ctseducare.hibernate.HibernateUtils;
import com.ctseducare.model.Profile;

public class ProfileDAO extends DAO<Profile>{

  public ProfileDAO() {
    super(Profile.class);
  }
  
  public Profile findByName(String name) {
    String hql = "FROM Profile WHERE name = :name";
    
    Session session = HibernateUtils.getSessionFactory().openSession();
    
    TypedQuery<Profile> typedQuery = session.createQuery(hql, Profile.class);
    typedQuery.setParameter("name", name);
    
    Profile profile = typedQuery.getSingleResult();
    
    session.close();
    
    return profile;
  }
  
  public void removeAll() throws Exception {
    Session session = HibernateUtils.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();

      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaDelete<Profile> delete = cb.createCriteriaDelete(Profile.class);
      delete.from(Profile.class);

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

}
