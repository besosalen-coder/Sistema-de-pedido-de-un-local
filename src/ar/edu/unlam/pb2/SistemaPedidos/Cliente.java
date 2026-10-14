package ar.edu.unlam.pb2.SistemaPedidos;

public class Cliente {
	private String nombre;
	private PlanFidelidad planFidelidad; 
	
	public Cliente (String nombre) {
		this.nombre=nombre;
		this.planFidelidad= new PlanEstandar(); 
	}

	public void cambiarPlan(PlanFidelidad nuevoPlan) {
		this.planFidelidad=nuevoPlan;
		}

	public Double aplicarDescuento(Double monto) {
		return this.planFidelidad.aplicarDescuento(monto);
	}
	
	
	
}
