package logica;

public class Combo {
	private String nombre;
	private int[] idproductos;
	private int precio;
	private int idCombo;
	
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
	public int[] getIdproductos() {
		return idproductos;
	}
	public void setIdproductos(int[] idproductos) {
		this.idproductos = idproductos;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
