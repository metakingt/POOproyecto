package logica;

public class Combo {
    private int[] idcateg;
    private int[] codigoprod;
    private int idCombo;
    private int Precio;

    public Combo(int[] idcateg, int[] codigoprod, int idCombo, int precio) {
        this.idcateg = idcateg;
        this.codigoprod = codigoprod;
        this.idCombo = idCombo;
        this.Precio = precio;
    }


    public int[] getIdcateg() {
        return idcateg;
    }

    public void setIdcateg(int[] idcateg) {
        this.idcateg = idcateg;
    }

    public int[] getCodigoprod() {
        return codigoprod;
    }

    public void setCodigoprod(int[] codigoprod) {
        this.codigoprod = codigoprod;
    }

    public int getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(int idCombo) {
        this.idCombo = idCombo;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        this.Precio = precio;
    }
}
