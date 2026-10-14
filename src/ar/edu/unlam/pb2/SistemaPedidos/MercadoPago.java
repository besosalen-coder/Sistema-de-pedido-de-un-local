package ar.edu.unlam.pb2.SistemaPedidos;

public class MercadoPago implements ModoPago{
	private static Double descuetoMercadoPago = 0.03; 

	@Override
	public Double calcularMontoFinal(Double monto) {
	return monto - (monto * descuetoMercadoPago );
	}
}
