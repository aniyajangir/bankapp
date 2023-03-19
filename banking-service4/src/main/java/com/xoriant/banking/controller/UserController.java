package com.xoriant.banking.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.banking.aop.LogAspect;
import com.xoriant.banking.command.AccountDTO;
import com.xoriant.banking.command.CustomerDTO;
import com.xoriant.banking.command.TransactionsDTO;
import com.xoriant.banking.command.UserDTO;
import com.xoriant.banking.exception.NotFoundException;
import com.xoriant.banking.model.User;
import com.xoriant.banking.service.AccountService;
import com.xoriant.banking.service.CustomerService;
import com.xoriant.banking.service.ManagerService;
import com.xoriant.banking.service.UserService;
import com.xoriant.banking.utility.JWTUtility;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	LogAspect logAspect;
	
	@Autowired
	UserService userService;

	@Autowired
	CustomerService customerService;

	@Autowired
	ManagerService managerService;

	@Autowired
	AccountService accountService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTUtility jwtToken;
	
	

	HttpSession g_session;
	
	

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody UserDTO userData, HttpSession session) {
		System.out.println("Hello controller");
		logger.info("This is an info from login entry");
	 	logger.error("This is an error log entry");
	 	logger.debug("This message from debug");
	 	logger.trace("This message is from trace");
		
	 	
	 	
		String message = userService.login(userData);
		if (message.equals("manager") || message.equals("customer")) {
			
			User user = userService.findUserByUsername(userData.getUserName());
			g_session = session;
			g_session.setAttribute("user", user);
			g_session.setAttribute("userId", user.getUserId());
			
			final UserDetails userDetails=userDetailsService.loadUserByUsername(userData.getUserName());
			final String jwt=jwtToken.generateToken(userDetails);
			
			if(message.equals("manager")) {
				message="manager-";
			}
			
			return ResponseEntity.ok(message+jwt);
		}
		
		return ResponseEntity.ok(message);
		
		

	}
	
	@GetMapping("/dashboard/logout")
	public ResponseEntity<String> logout(){
		g_session.invalidate();
		return ResponseEntity.ok("logout");
	}

	@PostMapping("/dashboard/balance")
	public ResponseEntity<String> checkBalance(@RequestBody long accountNumber) {
		return ResponseEntity.ok(accountService.balanceEnquiry(accountNumber, (User) g_session.getAttribute("user")));

	}

	@PostMapping("/dashboard/deleteAccount")
	public ResponseEntity<String> deleteAccount(@RequestBody long accountNumber) {

		return ResponseEntity.ok(accountService.deleteAccount(accountNumber));
	}

	@PostMapping("/dashboard/createAccount")
	public ResponseEntity<String> createAccount(@RequestBody AccountDTO accountDTO) {
		System.out.println("Reached to controller");
		return ResponseEntity.ok(accountService.createAccount(accountDTO));
		
	}
	
	@PostMapping("/dashboard/editAccount")
	public ResponseEntity<String> editAccount(@RequestBody AccountDTO accountDTO) {
		return ResponseEntity.ok(accountService.update(accountDTO));
	}

	@PostMapping("/dashboard/deposit")
	public ResponseEntity<String> deposit(@RequestBody TransactionsDTO transactionsDTO) {
		return ResponseEntity.ok(managerService.deposit(transactionsDTO));
	}

	@PostMapping("/dashboard/withdraw")
	public ResponseEntity<String> withdraw(@RequestBody TransactionsDTO transactionsDTO) {
		return ResponseEntity.ok(managerService.withdrawal(transactionsDTO));
	}

	@PostMapping("/dashboard/createCustomer")
	public ResponseEntity<String> createCustomer(@RequestBody CustomerDTO customerDTO) {
		return ResponseEntity.ok(managerService.addCustomer(customerDTO, (int) g_session.getAttribute("userId")));
	}
	
	@PostMapping("/dashboard/editCustomer")
	public ResponseEntity<String> editCustomer(@RequestBody CustomerDTO customerDTO) {
		return ResponseEntity.ok(managerService.updateCustomer(customerDTO));
	}

	@PostMapping("/dashboard/deleteCustomer")
	public ResponseEntity<String> deleteCustomer(@RequestBody int customerId) {
		System.out.println("afdsfd");
		return ResponseEntity.ok(managerService.deleteCustomer(customerId));
	}

	@PostMapping("/dashboard/logoutUser")
	public String logoutUser(HttpSession session) {
		session.invalidate();
		return "redirect";
	}

	@PostMapping("/dashboard/fundTransfer")
	public ResponseEntity<String> fundTransfer(@RequestBody TransactionsDTO transactionsDTO) {
		return ResponseEntity.ok(managerService.fundTransfer(transactionsDTO, (User) g_session.getAttribute("user")));
	}
	
	
	@PostMapping("/dashboard/ministatement")
	public ResponseEntity<?> ministatement(@RequestBody int accountNumber) {
		try {
			System.out.println(managerService.miniStatement((long)accountNumber, (User) g_session.getAttribute("user")));
			return ResponseEntity.ok(managerService.miniStatement((long)accountNumber, (User) g_session.getAttribute("user")));
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
