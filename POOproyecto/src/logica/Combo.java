package logica;

import java.util.ArrayList;

public class Combo {
	private int idCombo;
	private String nombre;
	private ArrayList<Productos> Contenidos;
	private int precio;
	public int getIdCombo() {
		return idCombo;
	}
	public void setIdCombo(int idCombo) {
		this.idCombo = idCombo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Productos> getProductos() {
		return Contenidos;
	}
	public void setProductos(ArrayList<Productos> productos) {
		this.Contenidos = productos;
	}
	public int getprecio() {
		return precio;
	}
	public void setprecio(int precio) {
		this.precio = precio;
	}
	public Combo(int idCombo, String nombre, ArrayList<Productos> contenidos) {
		this.idCombo = idCombo;
		this.nombre = nombre;
		this.Contenidos = new ArrayList<Productos>();
	}
	public void preciocombo() {
		int total = 0;
		int dscombo = 0;
		for(Productos producto : this.Contenidos) {
			dscombo += producto.getPrecio() * 0.20;
			total += producto.getPrecio()+ dscombo;
		}
		this.precio = total;
	}
}