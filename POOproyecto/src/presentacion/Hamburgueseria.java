package presentacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import logica.xxe;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Hamburgueseria {

	
	private xxe xxe;
	public Hamburgueseria() {
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
	            	+ "3. ingresar Combo\n"
	            	+ "4. ingresar Cajero\n"
	            	+ "5. ingresar Factura\n");
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
	                     ids[i] = sc.nextInt();
	                    System.out.print("Código del producto: ");
	                     codigos[i] = sc.nextInt();
	                }
	            	System.out.println("digite el id del combo: ");
	            	int idCombo = sc.nextInt();
	            	System.out.println("digite el precio del combo: ");
	            	int PrecioCombo = sc.nextInt();
	            	this.xxe.nuevoCombo(ids,codigos,idCombo,PrecioCombo);
	            }else {
	            if(op == 4) {
	            	System.out.println("Digite id:");
	            	int id = sc.nextInt();
	            	System.out.println("Digite nombre:");
	            	String nombre = sc.next();
	            	System.out.println("Digite apellido:");
	            	String apellido = sc.next();
	            	this.xxe.ingresarCajero(id, nombre, apellido);
	            }else {
	            	if(op == 5) {
	            		System.out.println("Digite id del Cajero");
	            		int idCajero = sc.nextInt();
	            		System.out.println("Digite la fecha");
	            		String fechaTexto = sc.next();
	            		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            		Date fecha = null;
	            		try {
	            			fecha = dateFormat.parse(fechaTexto);
	            		}catch (ParseException e) {
	            			e.printStackTrace();
	            		}
	            		int otroProducto;
	            		ArrayList<int[]>productosComprados = new ArrayList<int[]>();
	            		do {
	            			int datos[] = new int[2];
	            			System.out.println("Digite id del producto");
	            			int idProducto = sc.nextInt();
	            			System.out.println("Digite la cantidad del producto");
	            			int cantidadProducto = sc.nextInt();
	            			datos[0] = idProducto;
	            			datos[1] = cantidadProducto;
	            			productosComprados.add(datos);
	            			System.out.println("Desea ingresar otro producto?\n"
	    							+ "1. Si\n"
	    							+ "2. No\n");
	            			otroProducto = sc.nextInt();
	            		}while(otroProducto == 1);
	            		this.xxe.ingresarFactura(idCajero,fecha, productosComprados);
	            	}
	            }
	            }
	        }
	            }
	            } while (op != 0);
            sc.close();
	    }
		}
