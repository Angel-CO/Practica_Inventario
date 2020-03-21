package modelo;

import java.util.List;

public interface Venta_DAO {
    boolean crearVenta(Venta venta);
    public List<Venta> readAll();
    //public Producto obternerVenta(String clave);
}
