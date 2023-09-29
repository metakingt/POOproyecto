package logica;

public class Facturaproducto {

	private int cantidad;
	private int precio;
	
	private Productos producto;
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public Productos getProducto() {
		return producto;
	}
	public void setProducto(Productos producto) {
		this.producto = producto;
	}
	public Facturaproducto(int cantidad, int precio, Productos producto) {
		super();
		this.cantidad = cantidad;
		this.precio = precio;
		this.producto = producto;
	}
}
