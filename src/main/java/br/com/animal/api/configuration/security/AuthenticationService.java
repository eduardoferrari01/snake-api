package br.com.animal.api.configuration.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.animal.api.domain.User;
import br.com.animal.api.dto.MockDB;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private MockDB mockDB;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 
		Optional<User> user = mockDB.getUsuario(username);
		
		if(user.isPresent()) {
			
			return user.get();
		}
		
		throw new UsernameNotFoundException("Dados inválidos");
	}
	
}
