package com.curso.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.curso.model.Pedido;
import com.curso.model.Producto;
import com.curso.service.PedidosService;

@RestController
public class PedidosController {
	@Autowired
	PedidosService service;
	@GetMapping(value="pedidos")
	public List<Pedido> listadoPedidos(){
		return service.verPedidos();
	}
	@PostMapping(value="pedido/{idPedido}/{codigoProducto}/{unidades}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void realizarPedido(@PathVariable("idPedido")int idPedido,@PathVariable("codigoProducto")int codigoProducto,@PathVariable("unidades") int unidades) {
		Pedido pedido=new Pedido();
		service.realizarPedido(idPedido,codigoProducto,unidades);
	}
}
