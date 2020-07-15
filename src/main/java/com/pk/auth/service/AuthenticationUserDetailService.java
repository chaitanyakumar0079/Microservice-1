package com.pk.auth.service;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationUserDetailService implements UserDetailsService{

  @Override
  public UserDetails loadUserByUsername(String username)  {
	  PasswordEncoder passwordEncoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
     return new User(username, passwordEncoder.encode("password"), new ArrayList<>());
  }

}
