public class CalculadoraRadiciacao extends Calculadora {
    public double calcularRaizQuadrada(double numero) {
        if (numero >= 0) {
            return Math.sqrt(numero);
        } else {
            throw new IllegalArgumentException("Não é possível calcular a raiz de um número negativo.");
        }
    }
}
