package com.company;
/*Tarea adicional para el Main:
        a) Permitir borrar o actualizar ítems del carrito.
        b) Permitir listar todos los productos disponibles.
        c) Permitir filtrar por categoría de producto.
        d) Los productos tienen un stock. Sólo mostrar los productos con stock.
        e) Cuando se agrega un producto al carrito de un cliente, cambiar el stock.
        f) Permitir consultar los descuentos aplicados a un cliente en particular: Tipo y monto.
        g) Permitir consultar el precio sin descuento.
        */
//Cada producto tiene un nombre, una descripción y precio unitario.
public class Producto {
    private String nombre;
    private Integer precioUnitario;
    private String descripcion;
    private String clasificacion;
    private Integer stock;

    public Producto(String nombre, Integer precioUnitario, String descripcion, String clasificacion, Integer stock) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.descripcion = descripcion;
        this.clasificacion = clasificacion;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public Integer getStock() {
        return stock;
    }

    public void restarStock(Integer cantidad){
        this.stock = stock - cantidad;
    }

    public void agregarStock(Integer cantidad){
        this.stock = stock + cantidad;
    }

    public void mostrarDatosProductos(){
        if (stock != 0) {
            System.out.println("El nombre del producto es "+nombre+", el precio por unidad es $"+precioUnitario+" y su descripción "+descripcion+". Hay en stock "+stock);
        }
    }

}
