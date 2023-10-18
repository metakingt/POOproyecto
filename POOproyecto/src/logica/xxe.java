package logica;

import java.util.ArrayList;
import java.util.Date;

import persistencia.Archivo;

public class xxe {
	private ArrayList<CategProductos> categproductos;
	private ArrayList<Combo> combos;
	private ArrayList<Cajero> cajeros;
	private ArrayList<Productos> producto;
	private ArrayList<Factura> facturas;
	private ArrayList<Ingredientes> ingredientes;
	
	public xxe() {
		this.categproductos = new ArrayList<CategProductos>();
		this.producto = new ArrayList<Productos>();
		this.combos = new ArrayList<Combo>();
		this.cajeros = new ArrayList<Cajero>();
		this.facturas = new ArrayList<Factura>();
		this.ingredientes = new ArrayList<Ingredientes>(); 
	
	}
	public void ingresarTipoProducto(int id, String nombre) {
		CategProductos categproducto = new CategProductos(id, nombre);		
		this.categproductos.add(categproducto);
	}
	public void ingresarProducto(int idTipoProducto, int codigo, String nombre, int Precio) {
		CategProductos categproducto = this.buscarTipoProducto(idTipoProducto);
		if( categproducto != null) {
			Productos producto = new Productos(codigo, nombre, Precio); 
			this.producto.add(producto);
		}
		
	}
	public void ingresarProductocomp(int idTipoProducto, int[]ids, int codigo, String nombre, int Precio) {
		CategProductos categproducto = this.buscarTipoProducto(idTipoProducto);
		if( categproducto != null) {
			Productos producto = new Productos(codigo, ids, nombre, Precio);
			this.producto.add(producto);
		}
	}
	public void ingresartopping(int codigo, String nombre, int precio) {
		Ingredientes ingrediente = new Ingredientes(codigo, nombre, precio);
		this.ingredientes.add(ingrediente);
	}
	private CategProductos buscarTipoProducto(int idTipoProducto) {
		for(CategProductos categproducto : this.categproductos) {
			if(categproducto.getId() == idTipoProducto) {
				return categproducto;
			}
		}
		return null;
	}
	 private Productos buscarProducto(int codigoProducto) {
			for(Productos producto : this.producto ) {
				if(producto.getCodigo() == codigoProducto) {
					return producto;
				}
			}
			return null;
		}
	 private Cajero buscarCajero(int idCajero) {
		 for(Cajero cajero : this.cajeros) {
			 if(cajero.getId() == idCajero) {
				 return cajero;
			 }
		 }
		 return null;
	 }
	 private Combo buscarCombo(int idCombo) {
		 for(Combo combo : this.combos) {
			 if(combo.getIdCombo() == idCombo) {
				 return combo;
			 }
		 }
		 return null;
	 }
	
	public void nuevoCombo(int[] ids,String nombre,int idCombo, int precioCombo) {
		for (int i = 0; i < ids.length; i++) {
				Productos producto = this.buscarProducto(ids[i]);
				if(producto != null) {
					Combo combo = new Combo(nombre, idCombo, ids, precioCombo);
					this.combos.add(combo);
				}
		}
			}
	public void ingresarCajero(int id, String nombre, String apellido) {
		Cajero cajero = new Cajero(id, nombre, apellido);
		this.cajeros.add(cajero);
	}
	public void ingresarFactura(int idCajero, Date fecha, ArrayList<int[]> productosComprados) {
		Cajero cajero = this.buscarCajero(idCajero);
		int numero = this.facturas.size() + 1;
		Factura factura = new Factura(numero, fecha, cajero);
		for(int[] datos : productosComprados) {
			if(datos[3] == 0) {
				int temp = datos[5];
				datos[2] = temp;
			Productos producto = this.buscarProducto(datos[0]);
			factura.adicionarproducto(producto, datos[1]);
			}else {
				Combo combo = this.buscarCombo(datos[3]);
				factura.adicionarcombo(combo, datos[4]);
			}
			if(datos[0] == 0) {
				Combo combo = this.buscarCombo(datos[3]);
				factura.adicionarcombo(combo, datos[4]);
			}
		}
		factura.calcularTotal();
		this.facturas.add(factura);
	}
	public void leerArchivos(){
		String[] datos1;
		ArrayList<String> lineas;
		lineas = Archivo.leerArchivo("tipoProducto.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(",");
			this.ingresarTipoProducto(Integer.parseInt(datos[0]), datos[1]);
		}
		lineas = Archivo.leerArchivo("producto.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(",");
			this.ingresarProducto(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), datos[2], Integer.parseInt(datos[3]));
		}		
		lineas = Archivo.leerArchivo("cajero.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(",");
			this.ingresarCajero(Integer.parseInt(datos[0]), datos[1], datos[2]);
		}
		lineas = Archivo.leerArchivo("ingredientes.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(",");
			this.ingresartopping(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2]));
		}
		lineas = Archivo.leerArchivo("productocomp.dat");
		for(String linea : lineas) {
			datos1 = linea.split(",");
			int[] ingredientes = new int[] {Integer.parseInt(datos1[1]), Integer.parseInt(datos1[2]), Integer.parseInt(datos1[3]), Integer.parseInt(datos1[4]), Integer.parseInt(datos1[5]), Integer.parseInt(datos1[6])};
			this.ingresarProductocomp(Integer.parseInt(datos1[0]), ingredientes, Integer.parseInt(datos1[7]), datos1[8], Integer.parseInt(datos1[9]));
		}
		lineas = Archivo.leerArchivo("Combos.dat");
		for(String linea : lineas) {
			datos1 = linea.split(",");
			int[] productos = new int[] {Integer.parseInt(datos1[2]), Integer.parseInt(datos1[3]), Integer.parseInt(datos1[4]), Integer.parseInt(datos1[5]), Integer.parseInt(datos1[6]), Integer.parseInt(datos1[7])};
			this.nuevoCombo(productos, datos1[0], Integer.parseInt(datos1[1]), Integer.parseInt(datos1[8]));
		}
		}
	public void imprimirFacturas() {
	for(Factura factura : this.facturas) {
		factura.sumaringredientes(aumento);
		factura.restaringredientes(descuento);
		System.out.println("-------");
		System.out.println(factura.getNumero() + " -> " + factura.getFecha() + " -> " + factura.getValorTotal() + " -> " + factura.getCajero().getNombre());
		for(Facturaproducto facturaProducto : factura.getFacturaproductos()) {
			if(facturaProducto.getProducto() == null) {
			}else {
				System.out.println(facturaProducto.getProducto().getNombre() + " -> " + facturaProducto.getCantidad() + " -> " + facturaProducto.getPrecio());
			}
	}
		for(Facturaproducto facturaProducto : factura.getFacturaproductos()) {
			if(facturaProducto.getCombo() == null) {
			}else {
			System.out.println(facturaProducto.getCombo().getIdCombo() + " -> " + facturaProducto.getCantidad() + " -> " + facturaProducto.getPrecio());
				}
			}
		}
	}
	public int descuento;
	public void restaingredientes(int idIngrediente) {
		for(int i = 0; i < ingredientes.size(); i++) {
			if(ingredientes.get(i).getCodigo() == idIngrediente) {
				int descuento1 = ingredientes.get(i).getPrecio();
				descuento1 = (int) (descuento1 * 0.2);
				descuento = descuento + descuento1;
			}
		}
	}
	public int aumento;
	public void sumaingredientes(int idIngrediente) {
		for(int i = 0; i < ingredientes.size(); i++) {
			if(ingredientes.get(i).getCodigo() == idIngrediente) {
				int aumento1 = ingredientes.get(i).getPrecio();
				aumento = aumento + aumento1;
			}
		}
	}
}

		
	
