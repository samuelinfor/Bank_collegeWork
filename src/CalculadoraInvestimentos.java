public class CalculadoraInvestimentos extends Calculadora {
    public double calcularJurosSimples(double capital, double taxa, int periodo) {
        return capital * taxa * periodo;
    }

    public double calcularJurosCompostos(double capital, double taxa, int periodo) {
        return capital * Math.pow((1 + taxa), periodo) - capital;
    }
}
