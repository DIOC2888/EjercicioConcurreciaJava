package org.example;

public class Caja {
    private int ventas = 0;
    private int total = 0;

    public synchronized void registrarVenta(int monto){
        ventas ++;
        total += monto;
        System.out.println("Se registró una venta de: C$" + monto);
    }

    public void mostrarTotales(){
        System.out.println("Cantidad de ventas registradas:" + ventas);
        System.out.println("Total vendido: C$" + total);
    }

    public int getVentas() {
        return ventas;
    }

    public int getTotal() {
        return total;
    }
}
