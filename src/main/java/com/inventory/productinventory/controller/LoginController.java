package com.inventory.productinventory.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.productinventory.config.jwt.JwtRequest;
import com.inventory.productinventory.config.jwt.JwtResponse;
import com.inventory.productinventory.config.jwt.JwtTokenUtil;
import com.inventory.productinventory.entities.User;
import com.inventory.productinventory.services.AppUserDetailsService;
import com.inventory.productinventory.services.UserService;
import com.inventory.productinventory.util.CustomErrorType;

/**
 * @author shivaji barge
 *
 */
@RestController
public class LoginController {

	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private AuthenticationManager authenticationManager;


	@Autowired
	private UserService userService;
	
	@Autowired
	private AppUserDetailsService UserDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User newUser) {
		
		if (userService.find(newUser.getUsername()) != null) {
			logger.error("username Already exist " + newUser.getUsername());
			return new ResponseEntity(
					new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
					HttpStatus.CONFLICT);
		}

		String encodedPassword = bCryptPasswordEncoder.encode(newUser.getPassword());

		User user = new User(newUser.getUsername(), encodedPassword,newUser.getFullName(), "USER");
		return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
	}


	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = UserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	// this is the login api/service
	@CrossOrigin
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public Principal user(Principal principal) {
		logger.info("user logged " + principal);
		return principal;
	}

	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String welcome() {
		logger.info("inside welcome logged ");
		return "Hello User";
	}
}
