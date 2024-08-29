package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Pedido;

@Service
public class FluxoPedidoService {
	
	@Autowired
	private EmissaoPedidoService emissaoPedido;
	
	@Transactional
	public void confirmar(String pedidoCodigo) {
		Pedido pedido = emissaoPedido.buscarOuFalhar(pedidoCodigo);
		pedido.confirmar();
	}
	
	@Transactional
	public void cancelar(String pedidoCodigo) {
		Pedido pedido = emissaoPedido.buscarOuFalhar(pedidoCodigo);
		pedido.cancelar();
	}
	
	@Transactional
	public void entregar(String pedidoCodigo) {
		Pedido pedido = emissaoPedido.buscarOuFalhar(pedidoCodigo);
		pedido.entregar();
	}
}