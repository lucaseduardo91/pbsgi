package br.edu.infnet.sgi.dtos;

import java.math.BigDecimal;
import java.util.Date;

public class CompraDto {

	public long id;
	public EventoDto evento;
	public int qtdIngressos;
	public UsuarioDto cliente;
	public Date data;
	public BigDecimal total;
	public String metodoPagamento;
}
