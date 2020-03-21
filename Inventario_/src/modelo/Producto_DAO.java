package modelo;

import java.util.List;

public interface Producto_DAO {
    public boolean crearProducto(Producto producto);
    public List<Producto> readAll();
    public List<Producto> readAll(String clave);
    public boolean modificarAtributoCadena(String clave, String atributo, String valor);
    public boolean modificarAtributoNumero(String clave, String atributo, float valor);
    public boolean eliminarProducto(String clave);
    public Producto obtenerProducto(String clave);
}
