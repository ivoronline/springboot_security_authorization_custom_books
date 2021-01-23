package com.ivoronline.springboot_security_authorization_custom_books.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {

  //LOAD PROPERTIES (from application.properties file)
  @Value("${spring.security.user.name}")     private String userName;
  @Value("${spring.security.user.password}") private String userPassword;
  @Value("${spring.security.user.profile}")  private String userProfile;
  @Value("${profile.user}")                  private String profileUser;
  @Value("${profile.admin}")                 private String profileAdmin;

  @Override
  public UserDetails loadUserByUsername(String enteredUserName) throws UsernameNotFoundException {

    //CHECK USERNAME
    if(!enteredUserName.equals(userName)) { throw new UsernameNotFoundException("User not found"); }

    //GET AUTHORITIES FOR GIVEN USER PROFILE
    String userAuthorities = "";
    if(userProfile.equals("USER") ) { userAuthorities = profileUser;  }
    if(userProfile.equals("ADMIN")) { userAuthorities = profileAdmin; }

    //GET AUTHORITIES FROM STRING PROPERTY
    String[]     authoritiesArray = userAuthorities.split(", ");
    List<String> authoritiesList  = Arrays.asList(authoritiesArray);

    //CREATE AUTHORITIES (FOR USER OBJECT)
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    for (String authority : authoritiesList) {
      authorities.add(new SimpleGrantedAuthority(authority.trim()));
    }

    //CREATE USER
    User user = new User(userName, userPassword, true, true, true, true, authorities);

    //RETURN USER
    return user;

  }

}
