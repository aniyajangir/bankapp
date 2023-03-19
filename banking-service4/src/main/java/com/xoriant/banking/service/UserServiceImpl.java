package com.xoriant.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.banking.command.UserDTO;
import com.xoriant.banking.exception.NotFoundException;
import com.xoriant.banking.model.User;
import com.xoriant.banking.repository.UserDao;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	CustomerService customerService;
	@Autowired UserDao userDao;
	@Override
	public String login(UserDTO userData) {
		try {

			User loggedInUser = customerService.authUser(userData.getUserName(), userData.getPassword());
			if (loggedInUser == null) {
				return "not found";
			}
			return loggedInUser.getRole();
			
		} catch (NotFoundException e) {
			return "failed";
		}

	}
	@Override
	public User findUserByUsername(String userName) {
		return userDao.findByUserName(userName);
	}

}
