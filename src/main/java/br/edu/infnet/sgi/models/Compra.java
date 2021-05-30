package br.edu.infnet.sgi.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Compra {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "evento_id", nullable = false,
        referencedColumnName = "id")
	private Evento evento;
	
	@Column(name = "qtd_ingressos")
	private int qtdIngressos;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false,
        referencedColumnName = "id")
	private Usuario cliente;
	
	@Column(name = "data_compra")
	private Date data;
	
	@Column(name = "total")
	private BigDecimal total;
	
	@Column(name = "metodo_pagamento")
	private String metodoPagamento;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public int getQtdIngressos() {
		return qtdIngressos;
	}

	public void setQtdIngressos(int qtdIngressos) {
		this.qtdIngressos = qtdIngressos;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getTotal() {
		return total;
	}	
	
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	
	
}
