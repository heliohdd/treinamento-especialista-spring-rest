package com.algaworks.algafood.api.model;

import java.math.BigDecimal;

import com.algaworks.algafood.domain.model.CozinhaModel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestauranteModel {

	private Long id;
	private String nome;
	private BigDecimal precoFrete;
	private CozinhaModel cozinha;
	private Boolean ativo;
	private EnderecoModel endereco;
	private Boolean aberto;
}