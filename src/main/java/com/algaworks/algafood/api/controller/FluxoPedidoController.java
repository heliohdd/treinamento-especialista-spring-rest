package com.algaworks.algafood.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.service.FluxoPedidoService;

@RestController
@RequestMapping(value = "/pedidos/{codigoPedido}")
public class FluxoPedidoController {
	
	@Autowired
	private FluxoPedidoService pedidoService;
	
	@PutMapping("/confirmacao")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void confirmar(@PathVariable String codigoPedido) {
		pedidoService.confirmar(codigoPedido);
	}
	
	@PutMapping("/cancelamento")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void cancelar(@PathVariable String codigoPedido) {
		pedidoService.cancelar(codigoPedido);
	}
	
	@PutMapping("/entrega")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void entregar(@PathVariable String codigoPedido) {
		pedidoService.entregar(codigoPedido);
	}
}