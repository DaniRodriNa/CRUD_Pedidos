package com.curso.service;

import java.util.List;

import com.curso.model.Pedido;

public interface PedidosService {
	List<Pedido> verPedidos();
	void realizarPedido(int idPedido,int codigoProducto, int unidades);
}
