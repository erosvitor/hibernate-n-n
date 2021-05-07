package com.ctseducare.queries;

import java.util.List;

import com.ctseducare.dao.UserDAO;
import com.ctseducare.model.User;

public class Queries {

  public static void main(String[] args) {
    
    UserDAO dao = new UserDAO();
    
    //----------------------------------------------------------------------------------------------------
    // Find users with specific profile
    //----------------------------------------------------------------------------------------------------
    List<User> users = dao.findUsersWithProfile(8);
    for (User user : users) {
      System.out.println(user.getName());
    }

  }

}
