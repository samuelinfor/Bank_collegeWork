public class Investimento {
    private static final double CDB_TAXA_ANUAL = 0.10;
    private static final double LCI_TAXA_ANUAL = 0.08;

    public static double calcularRendimentoCDB(double valorInvestido, int quantidadeParcelas) {
        double rendimentoAnual = valorInvestido * CDB_TAXA_ANUAL;
        return rendimentoAnual * quantidadeParcelas;
    }

    public static double calcularRendimentoLCI(double valorInvestido, int quantidadeParcelas) {
        double rendimentoAnual = valorInvestido * LCI_TAXA_ANUAL;
        return rendimentoAnual * quantidadeParcelas;
    }
}
