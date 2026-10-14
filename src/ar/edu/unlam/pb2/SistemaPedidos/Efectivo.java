package ar.edu.unlam.pb2.SistemaPedidos;

public class Efectivo implements ModoPago {

	@Override
	public Double calcularMontoFinal(Double monto) {
	return monto;
}
}
