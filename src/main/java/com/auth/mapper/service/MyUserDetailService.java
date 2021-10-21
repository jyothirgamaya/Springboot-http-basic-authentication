package com.auth.mapper.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.entity.User;
import com.auth.mapper.mybatis.UserMapper;
import com.auth.repositry.jpa.UserRepo;
import com.auth.userdetails.MyUserDetails;

@Service
public class MyUserDetailService implements UserDetailsService {
@Autowired
 UserRepo repo;

@Autowired
UserMapper mapper;

@Autowired
PasswordEncoder encoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// mapper
		Optional<User> user=mapper.findUserByName(username);
		System.out.println(user.get().getName());
		//jpa
		//Optional<User> user=repo.findUserByName(username);
	  String userName=null;
	  String password = null;
	  try{
			  if(user.get().getName()==null) {
				 
				  throw new UsernameNotFoundException("User Not Found");
			  }else
			  if(user.get().getPrivatePassword()==null) {
				  throw new UsernameNotFoundException("User Not Found");
			  }
			  
			  userName=user.get().getName();
			  System.out.println(userName);
			  password=encoder.encode(user.get().getPrivatePassword());
			  return new MyUserDetails(userName,password);
			  
		  }catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
	
	  
			  
	 
	}

}
