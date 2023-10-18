package logica;

public class Ingredientes {
	private int codigo;
	private int precio;
	private String nombre;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Ingredientes(int codigo, String nombre, int Precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = Precio;
	}
}

