package ar.edu.unlam.pb2.test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import ar.edu.unlam.pb2.SistemaPedidos.Bebida;
import ar.edu.unlam.pb2.SistemaPedidos.Cliente;
import ar.edu.unlam.pb2.SistemaPedidos.Combo;
import ar.edu.unlam.pb2.SistemaPedidos.Efectivo;
import ar.edu.unlam.pb2.SistemaPedidos.Local;
import ar.edu.unlam.pb2.SistemaPedidos.MercadoPago;
import ar.edu.unlam.pb2.SistemaPedidos.Pedido;
import ar.edu.unlam.pb2.SistemaPedidos.PlanEstandar;
import ar.edu.unlam.pb2.SistemaPedidos.PlanFidelidad;
import ar.edu.unlam.pb2.SistemaPedidos.PlanVip;
import ar.edu.unlam.pb2.SistemaPedidos.Plato;
import ar.edu.unlam.pb2.SistemaPedidos.PlatoDelDia;
import ar.edu.unlam.pb2.SistemaPedidos.Producto;
import ar.edu.unlam.pb2.SistemaPedidos.Tarjeta;
public class PlatoTest {

	@Test
	public void unPlatoNormalTieneElMismoPrecioQueElPrecioBase() {
	Plato plato= new Plato(15.0);
	assertEquals(15.0, plato.getPrecioVenta());
	}
	@Test
	public void siCambioElPrecioBaseDeUnPlatoElNuevoCalculoLoToma() {
	    Plato plato = new Plato(10.0);
	    plato.setPrecioBase(20.0);
	    assertEquals(20.0, plato.getPrecioVenta(), 0.01);
	}
	
	@Test
	public void unPlatoDelDiaTieneUnDescuentoDelVeintePorCientoSobreElPrecioBase() {
		PlatoDelDia platoDelDia =new PlatoDelDia(15.0);
		assertEquals(12, platoDelDia.getPrecioVenta());
	}
	@Test 
	public void unaBebidaTieneUnImpuestoDelDiezPorcientoSobreSuPrecioBase(){
		Bebida bebida = new Bebida(3.00);
		assertEquals(3.3,bebida.getPrecioVenta(), 0.01);
	}
	
	@Test 
	public void calcularElPrecioVentaDeDosProductosDeDistintoTipo(){
		List<Producto> productos = new ArrayList<>();
		productos.add(new Plato(10.0));
		productos.add(new Bebida(3.0));
		
		assertEquals(10.0, productos.get(0).getPrecioVenta(), 0.01);
		assertEquals(3.3, productos.get(1).getPrecioVenta(), 0.01);
	}
	
	@Test
	public void unComboTieneUnDescuentoDeUnQuincePorCientoSobreElTotalDeSusProductos() {
		List<Producto> productos = new ArrayList<>();
		productos.add(new Plato(10.0));
		productos.add(new Bebida(3.0));
		
		Combo combo = new Combo(productos, 0.15);
		
		assertEquals(11.305,combo.getPrecioVenta(), 0.01);
	}
	
	@Test
	public void unaBebidaCalculaSuPrecioIgualSueltaQueDentroDeUnCombo() {
	    Bebida bebidaSuelta = new Bebida(3.0);
	    Bebida bebidaEnCombo = new Bebida(3.0);

	    List<Producto> productos = new ArrayList<>();
	    productos.add(bebidaEnCombo);
	    Combo combo = new Combo(productos, 0.15);

	    assertEquals(bebidaSuelta.getPrecioVenta(), bebidaEnCombo.getPrecioVenta(), 0.01);
	}
	@Test
	public void unComboFamiliarTieneUnDescuentoDeUnVeintePorCientoSobreElTotalDeSusProductos() {
		List<Producto> productos = new ArrayList<>();
		productos.add(new Plato(10.0));
		productos.add(new Bebida(3.0));
		
		Combo combo = new Combo(productos, 0.20);
		
		assertEquals(10.64,combo.getPrecioVenta(), 0.01);
	}
	
	@Test
	public void unClientePagaConEfectivoElMontoTotalSinCargoNiDescuentos() {
		Efectivo efectivo= new Efectivo();
		Double montoFinal = 	efectivo.calcularMontoFinal(100.0);
		
		assertEquals(100,montoFinal, 0.01);
	}
	
	@Test
	public void unClientePagaConMercadoElMontoTotalTieneUnTresPorCientoDescuento() {
	MercadoPago mercado = new MercadoPago();		
	Double montoFinal = mercado.calcularMontoFinal(100.0);
		assertEquals(97.00,montoFinal, 0.01);
	}
	@Test
	public void unClientePagaConTarjetaElMontoTotalTieneUnRecargoDeDosComaCincoPorciento() {
	Tarjeta tarjeta = new Tarjeta();		
	Double montoFinal = tarjeta.calcularMontoFinal(100.0);
		assertEquals(102.5,montoFinal, 0.01);
	}
	@Test
	public void unClienteConPlanEstandarNoTieneDescuento() {
	PlanEstandar planEstandar = new PlanEstandar();
	Double montoFinal = planEstandar.aplicarDescuento(100.0);
	assertEquals(100, montoFinal, 0.01);
	}
	@Test
	public void unClienteConPlanVipTieneDiezPorcientoDescuento() {
	PlanVip planVip = new PlanVip();
	Double montoFinal = planVip.aplicarDescuento(100.0);
	assertEquals(90.0, montoFinal, 0.01);
	}
	
	@Test
	public void unClienteQueAsciendeDeEstandarAVipTieneUnDescuento() {
		Cliente clienteVip = new Cliente ("Juan"); 
		PlanFidelidad planVip= new PlanVip();
		clienteVip.cambiarPlan(planVip); 
		
		Double montoFinal= clienteVip.aplicarDescuento(100.00);
		assertEquals(90.0, montoFinal, 0.01);
	}
	@Test
	public void unClienteVipRealizaUnPedido() {
		Cliente clienteVip = new Cliente("Juan");
		clienteVip.cambiarPlan(new PlanVip());
		
		Efectivo efectivo = new Efectivo(); 
		
		List<Producto>productos = new ArrayList<Producto>();
		productos.add(new Plato(10.0));
		productos.add(new Bebida(3.0));
		
		Pedido pedido= new Pedido (clienteVip, efectivo, productos);
		
		Double totalPedido= pedido.calcularTotal();
		assertEquals(11.97, totalPedido, 0.01);
	}
	
	@Test
	public void unLocalConDosPedidosCalculaLaFacturacionTotal() {
		Local restaurante = new Local ("En lo de Tuly");
		
		Cliente cliete1 = new Cliente("Juan");
		cliete1.cambiarPlan(new PlanVip());
		Efectivo efectivo = new Efectivo();
		List<Producto>productos1 =new ArrayList<Producto>();
		productos1.add(new Plato(10.0));
		productos1.add(new Bebida(3.0));
		Pedido pedido1 = new Pedido(cliete1, efectivo, productos1);
		
		Cliente cliente2= new Cliente("Maria");
		List<Producto>productos2 = new ArrayList<Producto>();
		productos2.add(new Plato(50.0));
		Pedido pedido2 = new Pedido(cliente2, efectivo, productos2);
		
		restaurante.registrarPedido(pedido1);
		restaurante.registrarPedido(pedido2);
		
		Double facturacionTotal =  restaurante.calcularFacturaTotal();
		
		assertEquals(61.97, facturacionTotal, 0.01);
	}
	
}

