package logica;
import java.util.ArrayList;
import java.util.Scanner;
public class Hamburgueseria {
	private ArrayList<CategProductos> categproductos;
	private ArrayList<Productos> producto;
	
	private xxe xxe;
	public Hamburgueseria() {
		this.categproductos = new ArrayList<CategProductos>();
		this.producto = new ArrayList<Productos>();
		this.xxe = new xxe();
	}
	    public static void main(String[] args) {
	        Hamburgueseria principal = new Hamburgueseria();
	        principal.iniciar();
	    }
	    private void iniciar() {
	    	Scanner sc = new Scanner(System.in);
	        int op;
	        do {
	            System.out.println("Menú Principal:\n"
	            	+ "1. ingresar Tipo Producto\n"
	            	+ "2. ingresar Producto\n"
	            	+ "3. ingresar Combo\n");
	            op = sc.nextInt();

	            if(op == 1){
	            	System.out.println("Digite id: ");
	    			int id = sc.nextInt();
	    			System.out.println("Digite nombre: ");
	    			String nombre = sc.next();				
	    			this.xxe.ingresarTipoProducto(id, nombre);
	            }else{
	            if(op == 2) {
	            	System.out.println("Digite id del Tipo de Producto: ");
					int idTipoProducto = sc.nextInt();
					System.out.println("Digite codigo: ");
					int codigo = sc.nextInt();
					System.out.println("Digite nombre: ");
					String nombre = sc.next();				
					System.out.println("Digite precio: ");
					int Precio = sc.nextInt();	
					this.xxe.ingresarProducto(idTipoProducto, codigo, nombre, Precio);
	            }else{
	            if(op == 3) {
	            	System.out.print("Ingrese la cantidad de productos que va a contener el combo: ");
	                int cantidadcombo = sc.nextInt();
	                int[] ids = new int[cantidadcombo];
	                int[] codigos = new int[cantidadcombo];
	                for (int i = 0; i < cantidadcombo; i++) {
	                    System.out.println("Ingrese el elemento #" + (i + 1));
	                    System.out.print("ID de la categoria del producto: ");
	                    int idTipoProducto = sc.nextInt();
	                    CategProductos categproducto = this.buscarTipoProducto(idTipoProducto);
	                    if(categproducto != null) {
	                    	sc.close();
	                    	throw new RuntimeException("este tipo de producto no existe, verifique que el id sea correcto o cree un nuevo tipo de producto");
	            		}
	                    System.out.print("Código del producto: ");
	                    int codigoProducto = sc.nextInt();
	                    Productos producto = this.buscarProducto(codigoProducto);
	        			if(producto != null) {
	        				sc.close();
	        				throw new RuntimeException("este producto no existe, verifique que el codigo sea correcto o cree un nuevo producto");
	        			}
	                    ids[i] = idTipoProducto;
	                    codigos[i] = codigoProducto;
	            		
	                }
	            	System.out.println("digite el id del combo: ");
	            	int idCombo = sc.nextInt();
	            	System.out.println("digite el precio del combo: ");
	            	int PrecioCombo = sc.nextInt();
	            	this.xxe.nuevoCombo(ids,codigos,idCombo,PrecioCombo);
	            }else {
	            if(op == 4) {
	            	
	            }
	            }
	        }
	            }
	            sc.close();
	            } while (op != 4);
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
	    }
