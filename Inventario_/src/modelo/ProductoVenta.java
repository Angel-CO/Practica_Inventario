package modelo;
public class ProductoVenta {
    private String claveVenta;
    private String claveProducto;
    private int cantidad;

    public ProductoVenta() {
        this.claveVenta = "";
        this.claveProducto = "";
        this.cantidad = 0;
    }
    
    public ProductoVenta(String claveVenta, String claveProducto, int cantidad) {
        this.claveVenta = claveVenta;
        this.claveProducto = claveProducto;
        this.cantidad = cantidad;
    }

    public String getClaveVenta() {
        return claveVenta;
    }

    public void setClaveVenta(String claveVenta) {
        this.claveVenta = claveVenta;
    }

    public String getClaveProducto() {
        return claveProducto;
    }

    public void setClaveProducto(String claveProducto) {
        this.claveProducto = claveProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
