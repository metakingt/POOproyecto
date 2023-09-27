package logica;

import java.util.ArrayList;

public class xxe {

	private ArrayList<CategProductos> categproductos;
	private ArrayList<Combo> combo;

	public xxe() {
		this.categproductos = new ArrayList<CategProductos>();
		this.combo = new ArrayList<Combo>();
	
	}
	public void ingresarTipoProducto(int id, String nombre) {
		CategProductos categproducto = new CategProductos(id, nombre);		
		this.categproductos.add(categproducto);
	}
	public void ingresarProducto(int idTipoProducto, int codigo, String nombre, int Precio) {
		CategProductos categproducto = this.buscarTipoProducto(idTipoProducto);
		if( categproducto != null) {
			categproducto.ingresarProducto(codigo, nombre, Precio);
		}
		
	}
	private CategProductos buscarTipoProducto(int idTipoProducto) {
		for(CategProductos categproducto : this.categproductos) {
			if(categproducto.getId() == idTipoProducto) {
				return categproducto;
			}
		}
		return null;
	}
	
	public void nuevoCombo(int[] ids, int[] codigos,int idCombo, int precioCombo) {
				Combo combo = new Combo(ids, codigos,idCombo, precioCombo);
				this.combo.add(combo);
			}
		}
	
