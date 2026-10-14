package ar.edu.unlam.pb2.SistemaPedidos;

public class PlanVip implements PlanFidelidad {
	private static Double descuentoVip = 0.10;

@Override
public Double aplicarDescuento(Double monto) {
	return monto -(monto * descuentoVip);
}
}
