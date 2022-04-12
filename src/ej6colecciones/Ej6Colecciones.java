/*
 *Se necesita una aplicación para una tienda en la cual queremos almacenar los
distintos productos que venderemos y el precio que tendrán. Además, se necesita
que la aplicación cuente con las funciones básicas.
Estas las realizaremos en el main. Como, introducir un elemento, modificar su precio,
eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
Realizar un menú para lograr todas las acciones previamente mencionadas.
 */
package ej6colecciones;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ej6Colecciones {

    public static void main(String[] args) {
        HashMap<String, Integer> productos = new HashMap();

        menuProductos(productos);
    }

    public static void agregarProductos(HashMap<String, Integer> productos) {
        Scanner leer = new Scanner(System.in);
        boolean seguir = true;
        while (seguir)
        {
            System.out.println("Ingrese el nombre del producto que desea agregar");
            String nombre = leer.next();
            System.out.println("Ingrese el precio del producto");
            Integer precio = leer.nextInt();
            productos.put(nombre, precio);
            System.out.println("¿QUIERE INGRESAR OTRO PAIS? S/N");
            String preg = leer.next();
            seguir = !"n".equals(preg);
        }

    }

    public static void modificarPrecio(HashMap<String, Integer> productos) {
        Scanner leer = new Scanner(System.in);
        System.out.println("INGRESE EL NOMBRE DEL PRODUCTO QUE QUIERE CAMBIAR EL PRECIO");
        String nombre = leer.next();
        for (Map.Entry<String, Integer> aux : productos.entrySet())
        {
            String key = aux.getKey();
            Integer value = aux.getValue();

            if (key.equals(nombre))
            {
                System.out.println("INGRESE EL NUEVO PRECIO");
                Integer precioNuevo = leer.nextInt();
                productos.put(key, precioNuevo);
            }

        }

    }

    public static void eliminarProducto(HashMap<String, Integer> productos) {
        Scanner leer = new Scanner(System.in);
        System.out.println("INGRESE EL NOMBRE DEL PRODUCTO QUE QUIERE ELIMINAR");
        String nombre = leer.next();
        int cont = 0;
        for (Map.Entry<String, Integer> aux : productos.entrySet())
        {
            String key = aux.getKey();
            Integer value = aux.getValue();

            if (key.equals(nombre))
            {
                productos.remove(key);
                cont++;
            }

        }
        if (cont == 0)
        {
            System.out.println("PRODUCTO NO ENCONTRADO");
        }
    }

    public static void mostrarProductos(HashMap<String, Integer> productos) {
        for (Map.Entry<String, Integer> aux : productos.entrySet())
        {
            String key = aux.getKey();
            Integer value = aux.getValue();

            System.out.println("NOMBRE DEL PRODUCTO: " + key + " PRECIO: " + value);

        }
    }

    public static void menuProductos(HashMap<String, Integer> productos) {
        boolean seguir = true;
        Scanner leer = new Scanner(System.in);
        while (seguir)
        {
            System.out.println("BIENVENIDO, INGRESE UNA OPCION : " + "\n" + "1-AGREGAR PRODUCTOS"
                    + "\n" + "2- MODIFICAR PRECIO" + "\n" + "3- ELIMINAR PRODUCTO"
                    + "\n" + "4- MOSTRAR LOS PRODUCTOS" + "\n" + "5- SALIR");
            String opcion = leer.next();

            switch (opcion)
            {
                case "1":
                    agregarProductos(productos);
                    break;
                case "2":
                    modificarPrecio(productos);
                    break;
                case "3":
                    eliminarProducto(productos);
                    break;
                case "4":
                    mostrarProductos(productos);
                    break;
                case "5":
                    seguir = !"5".equals(opcion);
                    break;
            }
        }

        System.out.println("HASTA LUEGO :)");

    }
}
