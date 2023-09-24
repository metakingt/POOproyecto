package logica;
import java.util.Scanner;
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
	            	
	            }
	        }
	            }
	            } while (op != 4);

	        sc.close();
	        System.out.println("Digite id: ");
			int id = sc.nextInt();
			System.out.println("Digite nombre: ");
			String nombre = sc.next();				
			this.xxe.ingresarTipoProducto(id, nombre);
	    }
	    }
