package ar.edu.unlam.pb2.SistemaPedidos;
// extencion de plato, ya que "es un", tiene el mismo precio base que plato pero a partir de ese precio en el metodo calcula el descuento.
public class PlatoDelDia extends Plato  {

	public PlatoDelDia(double precioBase) {
		super(precioBase);
		
	}
@Override
  		public Double getPrecioVenta() {
		return super.getPrecioVenta() *0.80;
}

}
