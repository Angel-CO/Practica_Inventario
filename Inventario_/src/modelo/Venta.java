package modelo;

public class Venta {
    private String clave;
    private String fecha;

    public Venta() {
        this.clave = "";
        this.fecha = "";
    }
    
    public Venta(String clave, String fecha) {
        this.clave = clave;
        this.fecha = fecha;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
