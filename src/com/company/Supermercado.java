package com.company;

import java.util.ArrayList;
import java.util.List;


/*Tarea adicional para el Main:
        a) Permitir borrar o actualizar ítems del carrito.
        b) Permitir listar todos los productos disponibles.
        c) Permitir filtrar por categoría de producto.
        d) Los productos tienen un stock. Sólo mostrar los productos con stock.
        e) Cuando se agrega un producto al carrito de un cliente, cambiar el stock.
        f) Permitir consultar los descuentos aplicados a un cliente en particular: Tipo y monto.
        g) Permitir consultar el precio sin descuento.
        */

public class Supermercado {
    private List<Producto> productos;
    private List<Cliente> clientes;

    public Supermercado() {
        this.productos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void agregarProductos(Producto producto) {
        productos.add(producto);
    }


    public void mostrarProductosStock(){
        for (Producto p: productos){
            p.mostrarDatosProductos();
        }
    }

    public void filtrarCategoria(String categoria){
        System.out.println("Todos los productos con la categoria elegida son: ");
        System.out.println();
        for (Producto p: productos) {
            if (p.getClasificacion() == categoria){
                System.out.println(p.getNombre()+", precio por unidad $"+p.getPrecioUnitario()+", "+p.getDescripcion()+".");
            }
        }
    }


}
