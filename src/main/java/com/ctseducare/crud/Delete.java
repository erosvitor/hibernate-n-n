package com.ctseducare.crud;

import com.ctseducare.dao.UserDAO;
import com.ctseducare.model.User;

public class Delete {

  public static void main(String[] args) {

    UserDAO userDAO = new UserDAO();
    User user = userDAO.findByName("Daniele Bornatowski");
    try {
      userDAO.remove(user);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }

}
