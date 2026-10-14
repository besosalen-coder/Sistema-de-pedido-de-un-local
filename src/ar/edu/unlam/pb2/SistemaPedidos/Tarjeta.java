package ar.edu.unlam.pb2.SistemaPedidos;

public class Tarjeta implements ModoPago {
 private static Double recargaTarjeta = 0.025; 
	
 @Override
	public Double calcularMontoFinal(Double monto) {
	return monto + (monto * recargaTarjeta);
}
}
