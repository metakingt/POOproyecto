package logica;
import java.util.ArrayList;
import java.util.List;

public class Combo {
    // Atributos de la clase Combo
    private int idCombo;
    private String nombre;
    private int precioCombo;
    private List<Productos> productos;

    // Constructor de la clase Combo
    public Combo(int idCombo, String nombre, int precioCombo) {
        this.idCombo = idCombo;
        this.nombre = nombre;
        this.precioCombo = precioCombo;
        this.productos = new ArrayList<>();
    }

    // Método para agregar un producto al combo
    public void agregarProducto(Productos producto) {
        productos.add(producto);
    }

    // Método para calcular el precio total del combo
    public double calcularPrecio() {
       int precioTotal = precioCombo;
        for (Productos producto : productos) {
            precioTotal += producto.getPrecio();
        }
        return precioTotal;
    }

    // Getters y setters para los atributos
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

    public double getPrecioCombo() {
        return precioCombo;
    }

    public void setPrecioCombo(int precioCombo) {
        this.precioCombo = precioCombo;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }
}
