package com.ctseducare.crud;

import com.ctseducare.dao.ProfileDAO;
import com.ctseducare.model.Profile;
import com.ctseducare.model.User;

public class Select {

  public static void main(String[] args) {
    
    ProfileDAO profileDAO = new ProfileDAO();
    Profile profile = profileDAO.findByName("Profile Teste");

    for (User user : profile.getUsers()) {
      System.out.println(user.getName());
    }
  }

}
