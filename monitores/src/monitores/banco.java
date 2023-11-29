package monitores;

class Banco {
    private int clientesEnBanco = 0;
    private static final int MAX_CLIENTES = 2;

    public synchronized void ingresarBanco(String nombreCliente) throws InterruptedException {
        while (clientesEnBanco >= MAX_CLIENTES) {
            System.out.println(nombreCliente + " está esperando para ingresar al banco. Clientes en el banco: " + clientesEnBanco);
            wait();
        }

        clientesEnBanco++;
        System.out.println(nombreCliente + " ha ingresado al banco. Clientes en el banco: " + clientesEnBanco);

        // Simulamos una operación dentro del banco
        Thread.sleep(1000);

        // Notificamos a otros hilos que estén esperando
        notifyAll();
    }

    public synchronized void salirBanco(String nombreCliente) throws InterruptedException {
        clientesEnBanco--;
        System.out.println(nombreCliente + " ha salido del banco. Clientes en el banco: " + clientesEnBanco);

        // Notificamos a otros hilos que estén esperando
        notifyAll();
    }
}