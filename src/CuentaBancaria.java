public class CuentaBancaria {
    private double saldo;
    private String VerSaldo;
    // Constructor
    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // depositar dinero en la cuenta
    public void depositar(double cantidad) {
        try {
            if (cantidad <= 0) {
                throw new IllegalArgumentException("La cantidad a depositar debe ser mayor que cero.");
            }
            saldo += cantidad;
            System.out.println("Deposito exitoso. Nuevo saldo: " + saldo);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // retirar dinero de la cuenta
    public void retirar(double cantidad) {
        try {
            if (cantidad <= 0) {
                throw new IllegalArgumentException("La cantidad a retirar debe ser mayor que cero.");
            }
            else if (saldo - cantidad < 0) {
                throw new IllegalStateException("Fondos insuficientes para realizar el retiro.");
            }
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    // Transferir
    public void Transferir(CuentaBancaria Cuenta2, double cantidad){
        try {
            if (cantidad <= 0) {
                throw new IllegalArgumentException("La cantidad a transferir debe ser mayor que cero.");
            }
            if (saldo - cantidad < 0) {
                throw new IllegalStateException("Fondos insuficientes para realizar la transferencia.");
            }
            saldo -= cantidad;
            Cuenta2.depositar(cantidad); // Transferimos a la cuenta destino
            System.out.println("Transferencia exitosa. Nuevo saldo: " + saldo);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }


    // Ver saldo de la cuenta
    public void verSaldo(String VerSaldo ) {
        try {if (VerSaldo == "No"){
                throw new IllegalArgumentException("No se puede ver el saldo.");
            }
            VerSaldo = "Si";
            System.out.println("Su Saldo es: " + saldo);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }
    }



        // probar las funcionalidades
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.depositar(500);
        cuenta.retirar(200);
        cuenta.verSaldo("Si");
        cuenta.depositar(200);
    }
}
