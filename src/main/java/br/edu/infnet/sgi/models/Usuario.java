package br.edu.infnet.sgi.models;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table("Usuarios")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cpf_cnpj")
	private String cpfCnpj;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "tipo_usuario")
	private String tipoUsuario;
	
	@Column(name = "saldo_carteira")
	private BigDecimal saldoCarteira;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)	
	private Set<Compra> compra;
	
	@OneToMany(mappedBy = "organizador", cascade = CascadeType.ALL)	
	private Set<Evento> evento;
	
	private Boolean validarCpfCnpj(String valor)
	{
		if(valor == null || valor.length() != 11 &&  valor.length() != 14)
			return false;
		
		return true;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		
		if(validarCpfCnpj(cpfCnpj))
			this.cpfCnpj = cpfCnpj;
		else {
			// Decidir depois entre lançar exceção ou retornar boolean
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {		
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public BigDecimal getSaldoCarteira() {
		return saldoCarteira;
	}

	public void setSaldoCarteira(BigDecimal saldoCarteira) {
		this.saldoCarteira = saldoCarteira;
	}
}
