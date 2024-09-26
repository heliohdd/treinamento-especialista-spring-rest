package com.algaworks.algafood.api.model;

import com.algaworks.algafood.api.model.view.RestauranteView;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CozinhaModel {

	@JsonView(value = RestauranteView.Resumo.class)
	private Long id;
	
	@JsonView(value = RestauranteView.Resumo.class)
	private String nome;
	
}
