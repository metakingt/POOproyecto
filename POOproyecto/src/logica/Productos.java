package logica;

public class Productos {
	private int codigo;
	private String nombre;
	private int Precio;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return Precio;
	}
	public void setPrecio(int precio) {
		Precio = precio;
	}
	public Productos(int codigo, String nombre, int Precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.Precio = Precio;
	}
}
