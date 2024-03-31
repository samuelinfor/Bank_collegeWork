import java.util.Scanner;
/*
*
*@author Samuel Ferreira
*
*
*/
public class AplicacaoBancaria {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome:");
        String nome = scanner.nextLine();

        System.out.println("Digite seu sobrenome:");
        String sobrenome = scanner.nextLine();

        System.out.println("Digite seu CPF:");
        String cpf = scanner.nextLine();

        ContaBancaria conta = new ContaBancaria(nome, sobrenome, cpf);

        while (true) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("a) Transações comuns");
                System.out.println("b) Investimentos");
                System.out.println("c) Calculadora");
                System.out.println("x) Sair");
            String opcao = scanner.nextLine();

            if (opcao.equals("a")) {
                menuTransacoesComuns(scanner, conta);
            } else if (opcao.equals("b")) {
                menuInvestimentos(scanner);
            } else if (opcao.equals("c")) {
                calcularComCalculadora(scanner);
            } else if (opcao.equals("x")) {
                System.out.println("Encerrando a aplicação...");
                break;
            } else {
                System.out.println("Opção inválida. Por favor, digite novamente.");
            }
        }

         scanner.close();
     }

    public static void menuTransacoesComuns(Scanner scanner, ContaBancaria conta) {
        while (true) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("a) Verificar saldo");
            System.out.println("b) Depositar valor");
            System.out.println("c) Retirar valor");
            System.out.println("x) Voltar");

            String opcao = scanner.nextLine();

            if (opcao.equals("a")) {
                System.out.println("Saldo atual: R$" + conta.getSaldo());
            } else if (opcao.equals("b")) {
                System.out.println("Digite o valor a ser depositado:");
                double valor = scanner.nextDouble();
                conta.depositar(valor);
                scanner.nextLine(); // Limpar o buffer do scanner
            } else if (opcao.equals("c")) {
                System.out.println("Digite o valor a ser retirado:");
                double valor = scanner.nextDouble();
                conta.sacar(valor);
                scanner.nextLine(); // Limpar o buffer do scanner
            } else if (opcao.equals("x")) {
                break;
            } else {
                System.out.println("Opção inválida. Por favor, digite novamente.");
            }
        }
    }

    public static void menuInvestimentos(Scanner scanner) {
        while (true) {
            System.out.println("\nEscolha um tipo de investimento:");
            System.out.println("a) CDB (10% ao ano)");
            System.out.println("b) LCI (8% ao ano)");
            System.out.println("x) Voltar");

            String opcao = scanner.nextLine();

            if (opcao.equals("a")) {
                System.out.println("Digite o valor a ser investido:");
                double valorInvestido = scanner.nextDouble();

                System.out.println("Digite a quantidade de parcelas (meses):");
                int quantidadeParcelas = scanner.nextInt();

                double rendimento = Investimento.calcularRendimentoCDB(valorInvestido, quantidadeParcelas);
                double totalInvestido = valorInvestido * quantidadeParcelas;

                System.out.println("Rendimento anual do CDB: R$" + rendimento);
                System.out.println("Quantidade de parcelas: " + quantidadeParcelas);
                System.out.println("Valor total investido: R$" + totalInvestido);

                scanner.nextLine(); // Limpar o buffer do scanner
                break;
            } else if (opcao.equals("b")) {
                System.out.println("Digite o valor a ser investido:");
                double valorInvestido = scanner.nextDouble();

                System.out.println("Digite a quantidade de parcelas (meses):");
                int quantidadeParcelas = scanner.nextInt();

                double rendimento = Investimento.calcularRendimentoLCI(valorInvestido, quantidadeParcelas);
                double totalInvestido = valorInvestido * quantidadeParcelas;

                System.out.println("Rendimento anual do LCI: R$" + rendimento);
                System.out.println("Quantidade de parcelas: " + quantidadeParcelas);
                System.out.println("Valor total investido: R$" + totalInvestido);

                scanner.nextLine(); // Limpar o buffer do scanner
                break;
            } else if (opcao.equals("x")) {
                break;
            } else {
                System.out.println("Opção inválida. Por favor, digite novamente.");
            }
        }
    }
    public static void calcularComCalculadora(Scanner scanner) {
        CalculadoraInvestimentos calculadoraInvestimentos = new CalculadoraInvestimentos();
        CalculadoraRadiciacao calculadoraRadiciacao = new CalculadoraRadiciacao();

        while (true) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1) Cálculo de Juros Simples");
            System.out.println("2) Cálculo de Juros Compostos");
            System.out.println("3) Cálculo de Raiz Quadrada");
            System.out.println("x) Voltar");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Digite o capital:");
                    double capitalJS = Double.parseDouble(scanner.nextLine());
                    System.out.println("Digite a taxa de juros (em decimal):");
                    double taxaJS = Double.parseDouble(scanner.nextLine());
                    System.out.println("Digite o período (em anos):");
                    int periodoJS = Integer.parseInt(scanner.nextLine());
                    double jurosSimples = calculadoraInvestimentos.calcularJurosSimples(capitalJS, taxaJS, periodoJS);
                    System.out.println("Juros Simples: R$" + jurosSimples);
                    break;
                case "2":
                    System.out.println("Digite o capital:");
                    double capitalJC = Double.parseDouble(scanner.nextLine());
                    System.out.println("Digite a taxa de juros (em decimal):");
                    double taxaJC = Double.parseDouble(scanner.nextLine());
                    System.out.println("Digite o período (em anos):");
                    int periodoJC = Integer.parseInt(scanner.nextLine());
                    double jurosCompostos = calculadoraInvestimentos.calcularJurosCompostos(capitalJC, taxaJC, periodoJC);
                    System.out.println("Juros Compostos: R$" + jurosCompostos);
                    break;
                case "3":
                    System.out.println("Digite o número para calcular a raiz quadrada:");
                    double numeroRaiz = Double.parseDouble(scanner.nextLine());
                    double raizQuadrada = calculadoraRadiciacao.calcularRaizQuadrada(numeroRaiz);
                    System.out.println("Raiz Quadrada: " + raizQuadrada);
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, digite novamente.");
            }
        }
    }
}
