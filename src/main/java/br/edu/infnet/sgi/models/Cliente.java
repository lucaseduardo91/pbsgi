package br.edu.infnet.sgi.models;

import java.math.BigDecimal;

public class Cliente extends Usuario {

	private BigDecimal saldoCarteira;

	public BigDecimal getSaldoCarteira() {
		return saldoCarteira;
	}

	public void setSaldoCarteira(BigDecimal saldoCarteira) {
		this.saldoCarteira = saldoCarteira;
	}
	
	public void adicionarSaldo(BigDecimal valor) {
		this.saldoCarteira.add(valor);
	}
	
	public void debitarSaldo(BigDecimal valor) {
		
		if(this.saldoCarteira.compareTo(valor) >= 0)
			this.saldoCarteira.subtract(valor);
		else {
			// Decidir depois entre lançar exceção ou retornar boolean
		}
	}
}
