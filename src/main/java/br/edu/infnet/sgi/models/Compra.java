package br.edu.infnet.sgi.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Compra {

	private long id;
	private ArrayList<Ingresso> ingressos;
	private Cliente cliente;
	private Date data;
	private BigDecimal total;
	private String metodoPagamento;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public ArrayList<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(ArrayList<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
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

	public BigDecimal calculaTotal() {
		BigDecimal valorCompra = new BigDecimal(0);
		
		for(Ingresso ingresso : this.ingressos)
		{
			valorCompra.add(ingresso.getPreco());
		}
		
		this.total = valorCompra;
		
		return this.total;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	
	
}
