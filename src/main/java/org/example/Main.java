package org.example;

public class Main {
    static void main(String[] args) throws Exception {
        Caja caja = new Caja();

        Runnable vendedor1 = () -> procesarVentas ("Vendedor 1", caja);
        Runnable vendedor2 = () -> procesarVentas ("Vendedor 2", caja);
        Runnable vendedor3 = () -> procesarVentas ("Vendedor 3", caja);


        Thread thread1 = new Thread(vendedor1);
        Thread thread2 = new Thread(vendedor2);
        Thread thread3 = new Thread(vendedor3);

        System.out.println("#########Proceso de ventas########");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("\n-------Termina proceso de ventas-------");
        System.out.println("\nCantidad de ventas: "+ caja.getVentas());
        System.out.println("\nTotal recaudado: C$" + caja.getTotal());


    }
    private static void procesarVentas(String vendedor, Caja caja) {
        for(int i=1; i <= 5; i++){
            try{
                Thread.sleep(1000);
                caja.registrarVenta(100);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println(vendedor + " fue interrumpido.");
                return;
            }
        }
    }
}
