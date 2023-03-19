package com.xoriant.banking.service;

import com.xoriant.banking.command.UserDTO;
import com.xoriant.banking.model.User;

public interface UserService {
	String login( UserDTO userData);
	User findUserByUsername(String userName);
}
