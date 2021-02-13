package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private List<Item> items;
    private String nombre;
    private LocalDate fechaNacimiento;
    private Boolean jubilado;

    public Cliente(String nombre, LocalDate fechaNacimiento, Boolean jubilado) {
        this.items = new ArrayList<>();
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.jubilado = jubilado;
    }


    public List<Item> getItems() {
        return items;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Boolean getJubilado() {
        return jubilado;
    }

    public void agregarItem(Producto producto , Integer cantidad){
        if(cantidad <= producto.getStock()) {
            //cantidad = producto.getStock();
            items.add(new Item(producto, cantidad));
            producto.restarStock(cantidad);
        }else
            System.out.println("La cantidad ingresada superó el stock disponible. De este producto tenemos en stock "+producto.getStock()+".");
    }

    public void modificarItem(Producto producto, int cantidad) {
        for (Item item : items) {
            if (item.getProducto().equals(producto)) {
                if (cantidad > item.getCantidad())
                    producto.restarStock(cantidad - item.getCantidad());
                else
                    producto.agregarStock(item.getCantidad() - cantidad);
                    item.setCantidad(cantidad);
                    break;
                }
            }
        }

    public void borrarItem(Producto producto){
        for (Item item : items){
            if (item.getProducto().equals(producto)) {
                items.remove(item);
                break;
            }
        }
    }


    public Double calcularTotal(){
        Double total = 0.0;
        for (Item i: items){
            total+= i.getCantidad()*i.getProducto().getPrecioUnitario();
            if (jubilado)
                total *= 0.85;
            LocalDate hoy = LocalDate.now();
            int anio = hoy.getYear();
            int mesCumple = fechaNacimiento.getMonthValue();
            int diaCumple = fechaNacimiento.getDayOfMonth();
            Boolean cumpleanios = hoy.equals(LocalDate.of(anio, mesCumple, diaCumple));
            if (cumpleanios)
                total += 0.9;
        }
        return total;
    }

}
