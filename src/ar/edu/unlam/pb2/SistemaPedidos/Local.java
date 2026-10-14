package ar.edu.unlam.pb2.SistemaPedidos;

import java.util.ArrayList;
import java.util.List;

public class Local {
private String nombre; 
private List<Pedido>pedidos; 

public Local(String nombre ) {
	this.nombre= nombre;
	this.pedidos= new ArrayList<>(); 
	
}

public void registrarPedido(Pedido nuevoPedido) {
	pedidos.add(nuevoPedido); 
}

public Double calcularFacturaTotal() {
	Double facturacionTotal = 0.0;
	
	for( Pedido pedido : pedidos) {
		facturacionTotal+= pedido.calcularTotal();
	}
	return facturacionTotal;
}


}
