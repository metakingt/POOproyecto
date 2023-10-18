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
	            	+ "2. ingresar Ingrediente\n"
	            	+ "3. ingresar Producto\n"
	            	+ "4. ingresar Combo\n"
	            	+ "5. ingresar Cajero\n"
	            	+ "6. ingresar Factura\n"
	            	+ "7. imprimir Facturas\n"
	            	+ "8. cargar Archivos\n");
	            op = sc.nextInt();

	            if(op == 1){
	            	System.out.println("Digite id: ");
	    			int id = sc.nextInt();
	    			System.out.println("Digite nombre: ");
	    			String nombre = sc.next();				
	    			this.xxe.ingresarTipoProducto(id, nombre);
	            }else{
	            if(op == 2) {
	            	System.out.println("ingrese el id del ingrediente");
	            	int id = sc.nextInt();
	            	System.out.println("ingrese el nombre del ingrediente");
	            	String nombre = sc.next();
	            	System.out.println("ingrese el precio del ingrediente");
	            	int precio = sc.nextInt();
	            	this.xxe.ingresartopping(id, nombre, precio);
	            }else{
	            if(op == 3) {
	            	System.out.println("Digite id del Tipo de Producto: ");
					int idTipoProducto = sc.nextInt();
					System.out.println("Digite codigo: ");
					int codigo = sc.nextInt();
					System.out.println("Digite nombre: ");
					String nombre = sc.next();				
					System.out.println("Digite precio: ");
					int Precio = sc.nextInt();
					System.out.println("el producto va a tener ingredientes?\n"
							+ "1. si\n"
							+ "2. no\n");
					int sing = sc.nextInt();
					if(sing == 1) {
						int[] ids = new int[6];
							for (int i = 0; i < ids.length; i++) {
				            System.out.println("Introduce un id:"
				            		+ "ingrese 0 para no añadir ingrediente");
				            int id = Integer.parseInt(System.console().readLine());
				            ids[i] = id;
				        }
						this.xxe.ingresarProductocomp(idTipoProducto, ids, codigo, nombre, Precio);
					}
					this.xxe.ingresarProducto(idTipoProducto, codigo, nombre, Precio);
	            }else{
	            if(op == 4) {
	                int[] ids = new int[6];
	                for (int i = 0; i < 6; i++) {
	                    System.out.println("Ingrese el elemento #" + (i + 1));
	                    System.out.print("ID del producto: ");
	                     ids[i] = sc.nextInt();
	                }
	                System.out.println("digite el nombre del combo: ");
	            	String nombre = sc.next();
	            	System.out.println("digite el id del combo: ");
	            	int idCombo = sc.nextInt();
	            	System.out.println("digite el precio del combo: ");
	            	int PrecioCombo = sc.nextInt();
	            	this.xxe.nuevoCombo(ids, nombre, idCombo, PrecioCombo);
	            }else {
	            if(op == 5) {
	            	System.out.println("Digite id:");
	            	int id = sc.nextInt();
	            	System.out.println("Digite nombre:");
	            	String nombre = sc.next();
	            	System.out.println("Digite apellido:");
	            	String apellido = sc.next();
	            	this.xxe.ingresarCajero(id, nombre, apellido);
	            }else {
	            if(op == 6) {
	            	System.out.println("Digite id del Cajero");
	            	int idCajero = sc.nextInt();
	            	System.out.println("Digite la fecha de forma yyyy-MM-dd");
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
	            		System.out.println("El producto es un combo?\n"
	            				+ "1. Si\n"
	            				+ "2. No\n");
	            		int bifur = sc.nextInt();	
	            		int datos[] = new int[6];		
	            			switch (bifur) {
	            			case 1:
		            				
	            			System.out.println("Digite id del combo");
	            			int idCombo = sc.nextInt();
	            			System.out.println("Digite la cantidad de combos");
	            			int cantCombo = sc.nextInt();
	            			datos[3] = idCombo;
	            			datos[4] = cantCombo;
	            			System.out.println("quiere ingresar mas productos?\n"
	            						+ "1. Si\n"
		            					+ "2. No\n");
	            				int bifur2 = sc.nextInt();
	            				if(bifur2 == 2) {
	            					break;
	            				}
	            			case 2:
	            			System.out.println("Digite id del producto");
	            			int idProducto = sc.nextInt();
	            			System.out.println("Digite la cantidad del producto");
	            			int cantidadProducto = sc.nextInt();
	            			datos[0] = idProducto;
	            			datos[1] = cantidadProducto;
	            			productosComprados.add(datos);
	            			}
	            			System.out.println("Desea ingresar otro producto?\n"
		    							+ "1. Si\n"
		    							+ "2. No\n");
	            			otroProducto = sc.nextInt();
	            			int desingr = 1;
                int desingr = 1;
	            			do {
	            			System.out.println("quiere quitar algun ingrediente?\n"
	            					+ "1. si\n"
	            					+ "2. no\n");
	            			desingr = sc.nextInt();
	            			if(desingr == 1) {
	            				System.out.println("ingrese el id del ingrediente ");
	            				int newingr = sc.nextInt();
	            				this.xxe.restaingredientes(newingr);
	            			}
	            			}while(desingr == 1);
do {
System.out.println("quiere anadir algun ingrediente?\n"
	            					+ "1. si\n"
	            					+ "2. no\n");
	            			desingr1 = sc.nextInt();
	            			if(desingr1 == 1) {
	            				System.out.println("ingrese el id del ingrediente ");
	            				int newingr = sc.nextInt();
	            				this.xxe.sumaingredientes(newingr);
	            			}
	            			}while(desingr1 == 1);

	            		}while(otroProducto == 1);
	            		this.xxe.ingresarFactura(idCajero,fecha, productosComprados);
	            	}else {
	            		if(op == 7) {
	            			this.xxe.imprimirFacturas();
	            	}else {
		            	if(op == 8) {
		            		this.xxe.leerArchivos();
		            		}
		            	}
	            	}
	            }
	            }
	            }
	            }
	            }
	            }while (op != 0);
            sc.close();
	    	}
	    }