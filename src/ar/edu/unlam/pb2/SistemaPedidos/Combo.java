package ar.edu.unlam.pb2.SistemaPedidos;

import java.util.List;
// se compone de otros productos (lista de productos) pero funciona como un producto mas, no hace falta que sea una "instancia de..."
// ComboFamiliar NO va a ser creada, ya que la unica diferencia con Combo es el porcentaje de descuento, se pasa por parametro y se agrega al metodo 

public class Combo implements Producto {
	private List<Producto>productos;
	private  Double descuento;  
	
	public Combo(List<Producto> productos, Double descuento) {
		this.productos=productos;
		this.descuento= descuento;
	}
 @Override
 public Double getPrecioVenta() {
	 Double subTotal = 0.0;
	 for(Producto producto : productos) {
		 subTotal += producto.getPrecioVenta();
	 }
 Double descuentoCombo = subTotal * descuento;
	 Double total = subTotal - descuentoCombo;
	 return total;
 }
}
