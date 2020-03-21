package controlador;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import modelo.Producto;
import modelo.Producto_DAO_Imp;
import modelo.Venta;
import modelo.Venta_DAO_Imp;
import vistas.Mensajes;
import modelo.ProductoVenta_DAO_Imp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import modelo.ProductoVenta;

public class Operaciones {

    private Scanner sc = new Scanner(System.in);
    private Mensajes ms;
    private Producto_DAO_Imp proDAOImp;
    private Venta_DAO_Imp ventaDAOImp;
    private ProductoVenta_DAO_Imp proVenDAOImp;
    
    public Operaciones() {
        this.ms = new Mensajes();
        this.proDAOImp = new Producto_DAO_Imp();
        this.ventaDAOImp = new Venta_DAO_Imp();
        this.proVenDAOImp = new ProductoVenta_DAO_Imp();
    }

    public void guardarProducto(String clave, String nombre, String descripcion, String unidad, int cantidad, float precio) {
        Producto pro = new Producto(clave, nombre, descripcion, unidad, cantidad, precio);
        Producto_DAO_Imp proImp = new Producto_DAO_Imp();
        proImp.crearProducto(pro);
    }

    public void mostrar() {
        List<Producto> lista = this.proDAOImp.readAll();
        ms.mostrarProductos(lista);
    }

    public void modificar(String clave, String atributo, String valor) {
        Producto_DAO_Imp proImp = new Producto_DAO_Imp();
        proImp.modificarAtributoCadena(clave, atributo, valor);
    }

    public void modificar(String clave, String atributo, float valor) {
        Producto_DAO_Imp proImp = new Producto_DAO_Imp();
        proImp.modificarAtributoNumero(clave, atributo, valor);
    }

    public void eliminar(String clave) {
        Producto_DAO_Imp ei = new Producto_DAO_Imp();
        ei.eliminarProducto(clave);
    }

    public void aumentar(String clave, int cantidad, float precio) {
        Producto_DAO_Imp ei = new Producto_DAO_Imp();
        Producto pro = ei.obtenerProducto(clave);
        int cant = cantidad + pro.getCantidad();
        float prec = (float) ((float) (cantidad * precio) + (float) (pro.getCantidad() * pro.getPrecio())) / cant;
        modificar(clave, "cantidad", cant);
        modificar(clave, "precio", prec);
    }

    public void disminuir(String clave, int cantidad) {
        Producto_DAO_Imp ei = new Producto_DAO_Imp();
        Producto pro = ei.obtenerProducto(clave);
        int cant = pro.getCantidad() - cantidad;
        modificar(clave, "cantidad", cant);
    }

    public void realizarVenta() {
        Calendar calendario = Calendar.getInstance();
        int hora;
        int minuto;
        int segundo;
        
        int opcionVenta = 0;
        int cantidad = 0;
        String claveProducto;
        String claveVenta;
        
        List<Producto> listProducto = new ArrayList<Producto>();
        
        do {
            ms.menuVentas();
            opcionVenta = ms.opcionEntero();
            switch (opcionVenta) {
                case 1: // Agregar
                    claveProducto = ms.leerClave();
                    cantidad = ms.leerCantidad();
                    Producto nuevo = proDAOImp.obtenerProducto(claveProducto);
                    nuevo.setCantidad(cantidad);
                    listProducto.add(nuevo);
                    break;
                case 2: // Ver venta
                    ms.mostrarVenta(listProducto);
                    break;
                case 3: // Aceptar
                    Date date = new Date();
                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                    hourFormat.format(date);
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    dateFormat.format(date);
                    
                    
                    Venta nuevaVenta = new Venta(hourFormat.format(date),dateFormat.format(date));
                    ventaDAOImp.crearVenta(nuevaVenta);
                        
                    
                    Iterator<Producto> iteradorPro = listProducto.iterator();
                    while(iteradorPro.hasNext()){
                        Producto productoActual = iteradorPro.next();
                        ProductoVenta proVen = new ProductoVenta();
                        proVen.setClaveVenta(nuevaVenta.getClave());
                        proVen.setClaveProducto(productoActual.getClave());
                        proVen.setCantidad(productoActual.getCantidad());
                        
                        proVenDAOImp.crearProductoVenta(proVen);
                        
                        disminuir(productoActual.getClave(),productoActual.getCantidad());
                    }
                    
                    opcionVenta = 4;
                    break;
                case 4: // Cancelar
                    System.out.println("Venta cancelada");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opcionVenta != 4);
    }

    public void mostrarVentas() {
        List<Venta> listaVe = this.ventaDAOImp.readAll();
        Iterator<Venta> iteradorVe = listaVe.iterator();

        while (iteradorVe.hasNext()) {
            Venta venta = iteradorVe.next();
            System.out.println("clave: " + venta.getClave());
            List<Producto> listaPro = proDAOImp.readAll(venta.getClave());

            ms.mostrarVenta(listaPro);
        }
    }

    public void ejecutarAplicacion() {
        int opcion = 0;
        int opcionModificar = 0;
        String clave;
        String claveNueva;
        String nombre;
        String descripcion;
        String unidad;
        int cantidad;
        float precio;
        do {
            ms.menu();
            opcion = ms.opcionEntero();
            switch (opcion) {
                case 1://agregar
                    System.out.println("Ingrese los datos del producto");
                    clave = ms.leerClave();
                    nombre = ms.leerNombre();
                    descripcion = ms.leerDescripcion();
                    unidad = ms.leerUnidad();
                    cantidad = ms.leerCantidad();
                    precio = ms.leerPrecio();

                    Producto producto = new Producto(clave, nombre, descripcion, unidad, cantidad, precio);
                    boolean creado = this.proDAOImp.crearProducto(producto);
                    ms.resultadoOperacion(creado, "Crear");
                    break;
                case 2://mostrar
                    mostrar();
                    break;
                case 3://modificar
                    clave = ms.leerClave();
                    ms.menuModificar();
                    opcionModificar = ms.opcionEntero();
                    switch (opcionModificar) {
                        case 1:
                            claveNueva = ms.leerClave();
                            modificar(clave, "clave", claveNueva);
                            break;
                        case 2:
                            nombre = ms.leerNombre();
                            modificar(clave, "nombre", nombre);
                            break;
                        case 3:
                            descripcion = ms.leerDescripcion();
                            modificar(clave, "descripcion ", descripcion);
                            break;
                        case 4:
                            unidad = ms.leerUnidad();
                            modificar(clave, "unidad", unidad);
                            break;
                        case 5:
                            cantidad = ms.leerCantidad();
                            modificar(clave, "cantidad", cantidad);
                            break;
                        case 6:
                            precio = ms.leerPrecio();
                            modificar(clave, "precio", precio);
                            break;
                    }
                    break;
                case 4://eliminar 
                    clave = ms.leerClave();
                    boolean eliminado = this.proDAOImp.eliminarProducto(clave);
                    ms.resultadoOperacion(eliminado, "Eliminarr");
                    break;
                case 5: // aumetar
                    clave = ms.leerClave();
                    cantidad = ms.leerCantidad();
                    precio = ms.leerPrecio();
                    aumentar(clave, cantidad, precio);
                    break;
                case 6: // disminuir
                    clave = ms.leerClave();
                    cantidad = ms.leerCantidad();
                    disminuir(clave, cantidad);
                    break;
                case 7: // venta
                    realizarVenta();
                    break;
                case 8: // mostrar venta
                    mostrarVentas();
                    break;
                case 9://salir
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 9);
    }

}
