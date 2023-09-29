package logica;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
	
	private int numero;
	private Date fecha;
	private int valorTotal;
	
	private Cajero cajero;
	
	private ArrayList<Facturaproducto> facturaproductos;
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getValorTotal() {
		return valorTotal;
	}
	public Cajero getCajero() {
		return cajero;
	}
	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}
	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ArrayList<Facturaproducto> getFacturaproductos() {
		return facturaproductos;
	}

	public void setFacturaproductos(ArrayList<Facturaproducto> facturaproductos) {
		this.facturaproductos = facturaproductos;
	}
	public Factura(int numero, Date fecha, Cajero cajero ) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.cajero = cajero;
		this.facturaproductos = new ArrayList<Facturaproducto>();
	}
	public void adicionarproducto(Productos producto, int cantidad) {
		Facturaproducto  facturaproducto = new Facturaproducto(cantidad, producto.getPrecio(), producto );
		this.facturaproductos.add(facturaproducto);
	}
	public void calcularTotal() {
		int total = 0;
		for(Facturaproducto facturaproducto : this.facturaproductos) {
			total += facturaproducto.getPrecio() * facturaproducto.getCantidad();
		}
		this.valorTotal = total;
	}
}
