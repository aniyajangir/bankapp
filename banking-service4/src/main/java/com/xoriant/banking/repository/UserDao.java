package com.xoriant.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xoriant.banking.exception.NotFoundException;
import com.xoriant.banking.model.User;


public interface UserDao extends JpaRepository<User, Integer> {


	@Query("from User u where u.userName=?1 and u.password=?2")
	public User authenticateUser(String userName, String password);


	@Query("from User u where u.userName=?1")
	public User findByUserName(String userName);

	@Modifying
	@Query("update User u set u.password = :password where u.userId = :userId")
	public void updateUser(@Param("userId") int userId,@Param("password") String newPassword);

	@Query(value="select u from User u where u.userName=:loginName")
	public User findByUserId(@Param("loginName") String loginName);
}
