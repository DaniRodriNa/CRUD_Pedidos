package com.curso.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.PedidosDao;
import com.curso.model.Pedido;
import com.curso.model.Producto;

@Service
public class PedidosServiceImpl implements PedidosService {
	@Autowired
	PedidosDao dao;
	@Autowired
	RestTemplate template;
	private String url="http://localhost:8500/";
	List<Pedido> pedidos=new ArrayList<>();
	@Override
	public List<Pedido> verPedidos() {
		return dao.findAll();
	}

	@Override
	public void realizarPedido(int idPedido,int codigoProducto, int unidades) {
		Date fechaActual=new Date();
		Pedido pedido=new Pedido();
		int stock;
		Producto producto=template.getForObject(url+"producto/{codigoProducto}", Producto.class,codigoProducto);
		stock=producto.getStock();
		if(stock>=unidades) {
			template.put(url+"producto/{codigoProducto}/{unidades}", null,codigoProducto,unidades);
			pedido.setIdPedido(idPedido);
			pedido.setTotal(unidades*producto.getPrecioUnitario());
			pedido.setFechaPedido(fechaActual);
			pedido.setUnidades(unidades);
			pedido.setCodigoProducto(codigoProducto);
		}
		dao.save(pedido);
	}

}
