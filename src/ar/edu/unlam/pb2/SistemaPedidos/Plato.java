package ar.edu.unlam.pb2.SistemaPedidos;
// Plato: clase base propia, su precio de venta es directamente el precio base, el que pone la regla. 
public class Plato implements Producto{
private Double precioBase;

	public Plato(double precioBase) {
		this.precioBase =precioBase;
	}

	public Double getPrecioVenta() {
		return precioBase;
	}
	public void setPrecioBase(Double nuevoPrecio) {
	    this.precioBase = nuevoPrecio;
	}

}
