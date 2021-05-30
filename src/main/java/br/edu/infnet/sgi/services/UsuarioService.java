package br.edu.infnet.sgi.services;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public UsuarioDto criarUsuario(UsuarioDto novoUsuario)
	{
		Usuario usuario = conversor.converterDtoParaUsuario(novoUsuario);
		
		usuarioRepository.save(usuario);
		
		return novoUsuario;
	}
	
	public UsuarioDto buscarUsuario(long id)
	{
		Usuario usuario = usuarioRepository.findById(id).get();		
		UsuarioDto usuarioDto = conversor.converterUsuarioParaDto(usuario);
		
		return usuarioDto;
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
