package br.edu.infnet.sgi.models;

public class Evento {

	private long id;
	private String nome;
	private String tipoEvento;
	private Organizador organizador;
	private int lotacao;
	private Endereco endereco;
	private String descricao;
	
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

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Organizador getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Organizador organizador) {
		this.organizador = organizador;
	}

	public int getLotacao() {
		return lotacao;
	}

	public void setLotacao(int lotacao) {
		this.lotacao = lotacao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
