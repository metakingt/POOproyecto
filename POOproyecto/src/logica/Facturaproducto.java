package logica;

public class Facturaproducto {

	private int cantidad;
	private int precio;
	
	private Productos producto;
	private Combo combo;
	
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
	public Combo getCombo() {
		return combo;
	}
	public void setCombo(Combo combo) {
		this.combo = combo;
	}
	public Facturaproducto(int cantidad, int precio, Productos producto) {
		super();
		this.cantidad = cantidad;
		this.precio = precio;
		this.producto = producto;
	}
	public Facturaproducto(int cantidad, int precio, Combo combo) {
		super();
		this.cantidad = cantidad;
		this.precio = precio;
		this.combo = combo;
	}
	public Facturaproducto(int cantidad, int precio, Productos producto, Combo combo) {
		super();
		this.cantidad = cantidad;
		this.precio = precio;
		this.producto = producto;
		this.combo = combo;
	}
}
