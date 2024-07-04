package com.algaworks.algafood;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.algaworks.algafood.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

// Sugestão padrão nome métodos
// givenJaExisteCozinhaChinesa_WhenCadastroCozinhaChinesa_ThenDeveFalhar()
// shouldComportamentoEsperado_WhenEstadoEmTeste()
// deveAtribuirId_QuandoCadastrarCozinhaComDadosCorretos()

@SpringBootTest
class CadastroCozinhaIntegrationTests {

	@Autowired
	private CadastroCozinhaService cadastroCozinha;

	@Test
	public void deveAtribuirId_QuandoCadastrarCozinhaComDadosCorretos() {
//		cenário
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Chinesa");
		
//		ação
		novaCozinha = cadastroCozinha.salvar(novaCozinha);
		
//		validação
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
	}
	
	@Test
	public void deveFalhar_QuandoCadastrarCozinhaSemNome() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);
		
		ConstraintViolationException erroEsperado = Assertions.assertThrows(
				ConstraintViolationException.class, () -> {cadastroCozinha.salvar(novaCozinha);});

		assertThat(erroEsperado).isNotNull();
	}
	
	@Test
	public void deveFalhar_QuandoExcluirCozinhaEmUso() {
//		cenário
//		Cozinha cozinhaEmUso = new Cozinha();
//		cozinhaEmUso.setId(1L);

//		ação
		EntidadeEmUsoException erroEsperado = 
				Assertions.assertThrows(EntidadeEmUsoException.class, () -> {
					cadastroCozinha.excluir(1L);
					});

//		validação
		assertThat(erroEsperado).isNotNull();
	}
	
	@Test
	public void deveFalhar_QuandoExcluirCozinhaInexistente() {
//		cenário
		
//		ação
		CozinhaNaoEncontradaException erroEsperado = 
				Assertions.assertThrows(CozinhaNaoEncontradaException.class, () -> {
					cadastroCozinha.excluir(100L);
					});
		
//		validação
		assertThat(erroEsperado).isNotNull();
	}

}
