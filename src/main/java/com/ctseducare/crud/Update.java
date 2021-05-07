package com.ctseducare.crud;

import com.ctseducare.dao.ProfileDAO;
import com.ctseducare.model.Profile;
import com.ctseducare.model.User;

public class Update {

  public static void main(String[] args) {
    
    User user = new User();
    user.setName("Daniele Bornatowski");
    
    ProfileDAO profileDAO = new ProfileDAO();
    Profile profile = profileDAO.findByName("Profile Teste");
    profile.getUsers().add(user);

    user.getProfiles().add(profile);
    
    try {
      profileDAO.update(profile);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }

}
