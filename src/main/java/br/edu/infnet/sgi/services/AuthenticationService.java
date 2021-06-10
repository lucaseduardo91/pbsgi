package br.edu.infnet.sgi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.infnet.sgi.models.Usuario;
import br.edu.infnet.sgi.repositories.UsuarioRepository;

@Service
public class AuthenticationService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Usuario> usuarios = repository.findByEmail(username);
		
		if(usuarios.size() > 0) {
			return usuarios.get(0);
		}
		
		throw new UsernameNotFoundException("User not found");
	}	

}