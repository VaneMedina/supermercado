package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
Main
En una cadena de supermercados se manejan distintos tipos de productos:
•	comidas, artículos de limpieza, bazar, librería y perfumería.
Cada producto tiene un nombre, una descripción y precio unitario.
Se desea crear un carrito de compras online en el que los clientes puedan seleccionar los productos a comprar (cantidad por producto).
El sistema debe informar el precio total de la compra.
Nota: los jubilados tienen un 15% de descuento.
Nota2: si es el cumpleaños del cliente, tiene un 10% de descuento adicional.


Tarea adicional para el Main:
a) Permitir borrar o actualizar ítems del carrito.
b) Permitir listar todos los productos disponibles.
c) Permitir filtrar por categoría de producto. (Me falta esto)
d) Los productos tienen un stock. Sólo mostrar los productos con stock.
e) Cuando se agrega un producto al carrito de un cliente, cambiar el stock.

f) Permitir consultar los descuentos aplicados a un cliente en particular: Tipo y monto.
g) Permitir consultar el precio sin descuento.
*/

public class Main {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();

        Supermercado supermercado = new Supermercado();


        supermercado.agregarProductos(new Producto("Leche", 100, "Leche pasteurizada", "categoria", 7));
        supermercado.agregarProductos(new Producto("Jabon", 50, "Rexona", "categoria",3));
        supermercado.agregarProductos(new Producto("Arroz", 200, "Arroz yamaní", "categoria",4));


        clientes.add(new Cliente("Pepe", LocalDate.of(1995, 9, 9), false));
        clientes.add(new Cliente("Roberto", LocalDate.of(1850, 9, 9), true));


        Cliente cliente0 = clientes.get(0);
        Cliente cliente1 = clientes.get(1);


        cliente0.agregarItem(supermercado.getProductos().get(0),7);
        System.out.println(supermercado.getProductos().get(0).getStock());
        cliente0.modificarItem(supermercado.getProductos().get(0),5);
        System.out.println(supermercado.getProductos().get(0).getStock());

        System.out.println();
        System.out.println("El cliente "+cliente0.getNombre()+" $"+cliente0.calcularTotal());
        System.out.println("El cliente "+cliente1.getNombre()+" $"+cliente1.calcularTotal());

        System.out.println();

        supermercado.mostrarProductosStock();

        System.out.println();
        supermercado.filtrarCategoria("categoria");

    }
}























