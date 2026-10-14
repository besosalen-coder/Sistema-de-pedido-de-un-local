package ar.edu.unlam.pb2.SistemaPedidos;

// implemente el metodo de producto es un tipo de producto
public class Bebida implements Producto {
private static Double impuestoInterno = 0.10;
private Double precioBase;

public Bebida (Double precioBase) {
	this.precioBase=precioBase;
}

public Double getPrecioVenta() {
return precioBase + (precioBase *impuestoInterno );
}
public void setPrecioBase(Double nuevoPrecio) {
    this.precioBase = nuevoPrecio;
}

}

