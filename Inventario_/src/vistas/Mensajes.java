/**
 * Clase Mensaje
 * 
 * Contiene todos los mensajes mostrados en consola
 * y las solicitudes de datos por teclado.
 * 
 * @author Ángel José Calderón Ortega
 * @version 1.0
 */

package vistas;

import java.util.Iterator;
import java.util.List;
import modelo.Producto;
import modelo.Venta;

public class Mensajes {
    // Atributos de la clase

    /**
     * Permite leer datos desde el teclado
     */

    Teclado teclado;
    
    /**
     * Constructor por defecto
     */
    public Mensajes(){
        this.teclado = new Teclado();
    }
    
    /**
     * Muestra un menú de las opciones que puede
     * realizar el sistema.
     * 
     * @return No retorna un valor
     */
    public void menu(){
        System.out.println("Elige una opcion");
        System.out.println("1. Agregar producto");
        System.out.println("2. Mostrar productos");
        System.out.println("3. Modificar producto");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Aumentar producto");
        System.out.println("6. Disminuir producto");
        System.out.println("7. Realizar venta");
        System.out.println("8. Mostrar ventas");
        System.out.println("9. salir");
        System.out.print(">");
    }
    
    /**
     * Muestra un menú de los atributos que se pueden
     * modificar en el producto
     * 
     * @return No retorna un valor
     */
    public void menuModificar(){
        System.out.println("Ingrese el numero del atributo");
        System.out.println("1. Clave");
        System.out.println("2. Nombre");
        System.out.println("3. Descripción");
        System.out.println("4. Unidad");
        System.out.println("5. Cantidad");
        System.out.println("6. Precio");
        System.out.print(">");
    }
    
    /**
     * Muestra un menú de opciones para poder
     * realizar una venta
     * 
     * @return No retorna un valor
     */
    public void menuVentas(){
        System.out.println("Ingrese el numero de la opcion");
        System.out.println("1. Agregar");
        System.out.println("2. Ver venta");
        System.out.println("3. Aceptar");
        System.out.println("4. Cancelar");
        System.out.print(">");
    }
    
    /**
     * Solicita ingresar un número y lo lee desde el teclado.
     * 
     * @return Retorna el número que leyó desde teclado 
     */
    public int opcionEntero(){
        int opcion =0;
        System.out.println("Introduce un dato de tipo entero");
        opcion = teclado.leerEntero();
        return opcion;
    }
    
    /**
     * Solicita ingresar una clave y la lee desde el teclado.
     * 
     * @return Retorna la clave que leyó desde teclado.
     */
    public String leerClave(){
        String clave;
        System.out.println("Introduce la clave");
        clave = teclado.leerCadena();
        return clave;
    }
    
    /**
     * Solicita ingresar un nombre y lo lee desde el teclado.
     * 
     * @return Retorna el nombre que leyó desde teclado.
     */
    public String leerNombre(){
        String nombre;
        System.out.println("Introduce el nombre");
        nombre = teclado.leerCadena();
        return nombre;
    }
    
    /**
     * Solicita ingresar una descripcion y la lee desde el teclado.
     * 
     * @return Retorna la descripcion que leyó desde teclado.
     */
    public String leerDescripcion(){
        String descripcion;
        System.out.println("Introduce el descripcion");
        descripcion = teclado.leerCadena();
        return descripcion;
    }
    
    /**
     * Solicita ingresar la unidad del producto y la lee desde el teclado.
     * 
     * @return Retorna el unidad que leyó desde teclado.
     */
    public String leerUnidad(){
        String unidad;
        System.out.println("Introduce el unidad");
        unidad = teclado.leerCadena();
        return unidad;
    }
    
    
    /**
     * Solicita ingresar la cantidad del producto y la lee desde el teclado.
     * 
     * @return Retorna la cantidad que leyó desde teclado.
     */
    public int leerCantidad(){
        int cantidad =0;
        System.out.println("Introduce la cantidad");
        cantidad = teclado.leerEntero();
        return cantidad;
    }
    

    /**
     * Solicita ingresar el precio del producto y lo lee desde el teclado.
     * 
     * @return Retorna el precio que leyó desde teclado.
     */
    public float leerPrecio(){
        float precio =0;
        System.out.println("Introduce el precio");
        precio = teclado.leerFlotante();
        return precio;
    }
    
    
    /**
     * Muestra la clave, nombre, descripcion, unidad, cantidad y precio
     * de todos los productos en almacen.
     *
     * @return No retorna un valor
     */
    public void mostrarProductos(List<Producto> lista){
        System.out.println("Los propductos son:");
        Iterator<Producto> iteradorPro = lista.iterator();
        while(iteradorPro.hasNext()){
            System.out.println("\t"+iteradorPro.next());
        }
    }
    
    
    /**
     * Recibe una lista de productos y genera una nota de venta.
     * 
     * @param listaPro Lista de productos
     */
    public void mostrarVenta(List<Producto> listaPro){
        System.out.println("VENTA");
        Iterator<Producto> iteradorPro = listaPro.iterator();
        System.out.println("Nombre    Precio  Cantidad    Importe");
        String nombre ="";
        float precio=0;
        int cantidad=0;
        float subtotal=0;
        while(iteradorPro.hasNext()){
            Producto prodcuto= iteradorPro.next();
            nombre = prodcuto.getNombre();
            precio = (float) (prodcuto.getPrecio()*1.3);
            
            cantidad = prodcuto.getCantidad();
            subtotal = subtotal + (precio*cantidad);
            System.out.println(nombre+"\t"+precio+"\t"+cantidad+"\t"+(precio*cantidad));
        }
        System.out.println("Subtotal: "+subtotal);
        System.out.println("IVA: "+(float)(subtotal*0.16));
        System.out.println("Total: "+(subtotal+(float)(subtotal*0.16))+"\n");        
    }
	
    /**
    *Muestra un mensaje si se realizo un operacion de forma exitosa o no

    *@param resultado Variable boololeana que dice si tuvo exito la operacion
    *@param operacion Nombre de la operacion
    */   
    public void resultadoOperacion(boolean resultado, String operacion){
        if(resultado){
            System.out.println("\n\t Resultado Exitoso al "+ operacion + "\n");
        }else{
            System.out.println("\n\t Resultado Fallido al "+ operacion + "\n");
        }
    }
}
