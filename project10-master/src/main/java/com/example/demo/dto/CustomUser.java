package com.example.demo.dto;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;

public class CustomUser extends User {

  public CustomUser(MemberDTO dto) {
	super(dto.getId(), dto.getPassword(), Arrays.asList(new SimpleGrantedAuthority(dto.getRole())));    
  }
  
}

