package br.edu.infnet.sgi.models;

public abstract class Usuario {

	private long id;
	private String nome;
	private String cpfCnpj;
	private String email;
	private Endereco endereco;
	
	private Boolean validarCnpj()
	{
		// Adicionar validação
		return true;
	}
	
	private Boolean validarCpf()
	{
		// Adicionar validação
		return true;
	}
	
	private Boolean validarEmail()
	{
		// Adicionar validação
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
		
		if(validarCpf() || validarCnpj())
			this.cpfCnpj = cpfCnpj;
		else {
			// Decidir depois entre lançar exceção ou retornar boolean
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		
		if(validarEmail())
			this.email = email;
		else {
			// Decidir depois entre lançar exceção ou retornar boolean
		}
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
