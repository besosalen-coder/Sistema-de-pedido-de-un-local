package ar.edu.unlam.pb2.SistemaPedidos;

import java.util.List;

public class Pedido {
	 private Cliente cliente; 
	 private ModoPago modoPago;
	private List<Producto> productos;

	
 public Pedido(Cliente clienteVip, ModoPago modoPago, List<Producto> productos) {
		this.cliente=clienteVip;
		this.modoPago=modoPago;
		this.productos=productos;
	}


 public Double calcularTotal() {
	Double suma= 0.0;
	for(Producto producto: this.productos) {
		suma +=producto.getPrecioVenta();
	}
	Double totalConDescuento= this.cliente.aplicarDescuento(suma);
	return this.modoPago.calcularMontoFinal(totalConDescuento);
 }


}
