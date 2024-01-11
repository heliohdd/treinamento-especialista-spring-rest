package com.algaworks.algafood.jpa.formaPagamento;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

public class InclusaoEstadoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		EstadoRepository cadastroEstado = applicationContext.getBean(EstadoRepository.class);

		Estado estado1 = new Estado();
		estado1.setNome("Brasileira");

		Estado estado2 = new Estado();
		estado2.setNome("Japonesa");

		estado1 = cadastroEstado.salvar(estado1);
		estado2 = cadastroEstado.salvar(estado2);
		
		System.out.printf("%d - %s\n", estado1.getId(), estado1.getNome());
		System.out.printf("%d - %s\n", estado2.getId(), estado2.getNome());

	}

}