package com.algaworks.algafood.jpa.formaPagamento;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

public class ConsultaFormaPagamentoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		FormaPagamentoRepository formasPagamento = applicationContext.getBean(FormaPagamentoRepository.class);

		List<FormaPagamento> todasFormasPagamento = formasPagamento.listar();

		for (FormaPagamento formaPagamento : todasFormasPagamento) {
			System.out.println(formaPagamento.getDescricao());
		}

	}

}
