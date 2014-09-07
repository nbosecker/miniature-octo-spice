package com.bosecker.tm.account;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.*;

public class UserService implements UserDetailsService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@PostConstruct	
	protected void initialize() {
		accountRepository.save(new Account("joetest", "joetest", "ROLE_TEST_USER"), new TmStudent("JoeTest", "User"));
		accountRepository.save(new Account("janetest", "janetest", "ROLE_TEST_USER"), new TmStudent("JaneTest", "User"));
		accountRepository.save(new Account("johntest", "johntest", "ROLE_TEST_USER"), new TmStudent("JohnTest", "User"));
		accountRepository.save(new Account("jacktest", "jacktest", "ROLE_TEST_USER"), new TmStudent("JackTest", "User"));
		accountRepository.save(new Account("nancy", "nancy", "ROLE_TEST_ADMIN"), new TmStudent("Nancy", "Admin"));
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByEmail(username);
		if(account == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return createUser(account);
	}
	
	public void signin(Account account) {
		SecurityContextHolder.getContext().setAuthentication(authenticate(account));
	}
	
	private Authentication authenticate(Account account) {
		return new UsernamePasswordAuthenticationToken(createUser(account), null, Collections.singleton(createAuthority(account)));		
	}
	
	private User createUser(Account account) {
		return new User(account.getEmail(), account.getPassword(), Collections.singleton(createAuthority(account)));
	}

	private GrantedAuthority createAuthority(Account account) {
		return new SimpleGrantedAuthority(account.getRole());
	}

}
