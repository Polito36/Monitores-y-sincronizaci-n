package monitores;

class Cliente extends Thread {
    private Banco banco;
    private String nombre;

    public Cliente(Banco banco, String nombre) {
        this.banco = banco;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            // Introducimos un pequeño retraso antes de que algunos clientes intenten ingresar al banco
            Thread.sleep((long) (Math.random() * 2000));

            banco.ingresarBanco(nombre);

            // Simulamos una operación dentro del banco
            Thread.sleep(2000);

            banco.salirBanco(nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

