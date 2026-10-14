package ar.edu.unlam.pb2.SistemaPedidos;
//interfaz porque Estándar y VIP no comparten estado o datos, y el plan de un cliente puede reasignarse en tiempo de ejecución (composición, no herencia)
// si se ejecuta un cambio (solicitud del cliente), al ser una interface lo unico que hace es definir QUE hace ese sistema, dejando el COMO a cada clase. 
//Es independiente de los pedidos, asi si quiere el cliente agregar el cobro de pj. aluileres no afecta al codigo. 
public interface PlanFidelidad {
	
public Double  aplicarDescuento(Double monto);
}

