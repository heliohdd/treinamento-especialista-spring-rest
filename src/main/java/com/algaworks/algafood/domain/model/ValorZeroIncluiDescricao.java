package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

public class ValorZeroIncluiDescricao {

	public boolean name(BigDecimal taxaFrete, String nome) {
		if (taxaFrete.equals(BigDecimal.ZERO)) {
			if (nome.contains("Frete Grátis")) {
				return true;
			}
		}
		concatenar(nome);
		return false;
	}
	
	public String concatenar(String nome) {
		return nome + " Frete Grátis";
	}
}
