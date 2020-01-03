package com.singha.app.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.singha.app.model.User;
import com.singha.app.model.UserAuth;
import com.singha.app.repository.UserRepository;

@Service("userDetailsService")
public class SinghaUserDetailsService implements UserDetailsService {
	private UserRepository userRepository;
	
	@Autowired
	public SinghaUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		Optional<User> opUser = userRepository.findByUserid(userid);
		
		User user = opUser.orElseThrow(() -> new UsernameNotFoundException(userid));
		
		List<GrantedAuthority> authorities = new ArrayList<>();

		List<UserAuth> roles = user.getRoles();
		roles.forEach(r -> authorities.add(new SimpleGrantedAuthority(r.getRolecd())));
		
		return new SinghaUser(user, authorities);
	}

}
