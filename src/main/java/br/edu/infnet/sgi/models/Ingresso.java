package br.edu.infnet.sgi.models;

import java.math.BigDecimal;

public class Ingresso {

	private long codigo;
	private Evento evento;
	private BigDecimal preco;
	private String codigoSetor;
	private String tipoIngresso;
	
	public long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getCodigoSetor() {
		return codigoSetor;
	}

	public void setCodigoSetor(String codigoSetor) {
		this.codigoSetor = codigoSetor;
	}

	public String getTipoIngresso() {
		return tipoIngresso;
	}

	public void setTipoIngresso(String tipoIngresso) {
		this.tipoIngresso = tipoIngresso;
	}
}
