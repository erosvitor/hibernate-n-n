package com.ctseducare.crud;

import com.ctseducare.dao.ProfileDAO;
import com.ctseducare.model.Profile;
import com.ctseducare.model.User;

public class Insert {

  public static void main(String[] args) {
    
    Profile profile = new Profile();
    profile.setName("Profile Teste");
    
    User user = new User();
    user.setName("Eros Vitor Bornatoowski");
    user.getProfiles().add(profile);
    
    profile.getUsers().add(user);
    
    ProfileDAO profileDAO = new ProfileDAO();
    try {
      profileDAO.insert(profile);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
