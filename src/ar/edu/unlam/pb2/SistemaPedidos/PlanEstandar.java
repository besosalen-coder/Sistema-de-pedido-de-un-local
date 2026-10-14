package ar.edu.unlam.pb2.SistemaPedidos;

public class PlanEstandar implements PlanFidelidad{
private Double monto;

@Override
	public Double aplicarDescuento(Double monto) {
		return monto;
	}

}
