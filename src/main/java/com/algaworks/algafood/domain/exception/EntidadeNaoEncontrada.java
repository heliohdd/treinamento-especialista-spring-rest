package com.algaworks.algafood.domain.exception;

public abstract class EntidadeNaoEncontrada extends NegocioException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontrada(String mensagem) {
		super(mensagem);
	}
}
