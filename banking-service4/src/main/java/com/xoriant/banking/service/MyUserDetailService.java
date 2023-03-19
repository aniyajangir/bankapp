
package com.xoriant.banking.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.xoriant.banking.repository.UserDao;

@Service
public class MyUserDetailService implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.xoriant.banking.model.User userdata=userDao.findByUserId(username);
		System.out.println(userdata.getUserName()+userdata.getPassword());
		return new User(userdata.getUserName(),userdata.getPassword(),new ArrayList<>());
	}

}