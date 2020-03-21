package modelo;

public class Producto {

    private String clave;
    private String nombre;
    private String descripcion;
    private String unidad;
    private int cantidad;
    private float precio;

    public Producto() {
        this.clave = "";
        this.nombre = "";
        this.descripcion = "";
        this.unidad = "";
        this.cantidad = 0;
        this.precio = 0;
    }

    public Producto(String clave, String nombre, String descripcion, String unidad, int cantidad, float precio) {
        this.clave = clave;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "clave=" + clave + ", nombre=" + nombre + ", descripcion=" + descripcion + ", unidad=" + unidad + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }

}
