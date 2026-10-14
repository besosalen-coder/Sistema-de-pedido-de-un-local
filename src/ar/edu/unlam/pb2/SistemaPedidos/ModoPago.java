package ar.edu.unlam.pb2.SistemaPedidos;

//es interface porque los metodos de pago no requieren  de datos en comun , solo comparten el metodo es decir el comportamiento. 
// son distintos pero se comportan igual, todas ejecutan un pago. 
//el sistema de pagos es independiente del sistema de pedidos de comida.

public interface ModoPago {
public Double calcularMontoFinal(Double monto);
}
