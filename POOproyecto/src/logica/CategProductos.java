package logica;

import java.util.ArrayList;

public class CategProductos {
	private int id;
	private String nombre;
	private ArrayList<Productos> productos;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Productos> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Productos> productos) {
		this.productos = productos;
	}
	public CategProductos(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.productos = new ArrayList<Productos>();
	}
	public void ingresarProducto(int codigo, String nombre, int precio) {
		Productos producto = new Productos(codigo,nombre,precio);
		this.productos.add(producto);
	}
}
