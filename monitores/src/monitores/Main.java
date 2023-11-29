package monitores;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Cliente cliente1 = new Cliente(banco, "Cliente 1");
        Cliente cliente2 = new Cliente(banco, "Cliente 2");
        Cliente cliente3 = new Cliente(banco, "Cliente 3");
        Cliente cliente4 = new Cliente(banco, "Cliente 4");
        Cliente cliente5 = new Cliente(banco, "Cliente 5");

        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
    }
}