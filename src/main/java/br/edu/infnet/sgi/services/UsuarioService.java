package br.edu.infnet.sgi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.infnet.sgi.dtos.UsuarioDto;
import br.edu.infnet.sgi.models.Usuario;
import br.edu.infnet.sgi.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	EntityConverterService conversor;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	public UsuarioDto criarUsuario(UsuarioDto novoUsuario)
	{
		Usuario usuario = conversor.converterDtoParaUsuario(novoUsuario);
		usuario.setPassword(passwordEncoder.encode(novoUsuario.password));
		
		usuarioRepository.save(usuario);
		
		return novoUsuario;
	}
	
	public UsuarioDto buscarUsuario(long id)
	{
		Optional<Usuario> usuario = usuarioRepository.findById(id);	
		
		if(usuario.isPresent())
		{
			UsuarioDto usuarioDto = conversor.converterUsuarioParaDto(usuario.get());			
			return usuarioDto;
		}
		
		return null;
		
	}
	
	public UsuarioDto buscarUsuarioPorEmail(String email)
	{
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		
		if(usuario.isPresent())
		{
			UsuarioDto usuarioDto = conversor.converterUsuarioParaDto(usuario.get());
			return usuarioDto;
		}
		
		return null;
	}
	
	public UsuarioDto atualizarUsuario(UsuarioDto usuarioAtualizado, long id)
	{		
		Usuario usuario = usuarioRepository.findById(usuarioAtualizado.id).get();
		
		usuario.setId(id);
		usuario.setNome(usuarioAtualizado.nome);
		usuario.setCpfCnpj(usuarioAtualizado.cpfCnpj);
		usuario.setEmail(usuarioAtualizado.email);
		usuario.setEndereco(usuarioAtualizado.endereco);
		usuario.setTipoUsuario(usuarioAtualizado.tipoUsuario);
		usuario.setSaldoCarteira(usuarioAtualizado.saldoCarteira);
		
		usuarioRepository.save(usuario);
		return usuarioAtualizado;
	}
	
	public void deletarUsuario(long id)
	{
		usuarioRepository.deleteById(id);
	}
}
