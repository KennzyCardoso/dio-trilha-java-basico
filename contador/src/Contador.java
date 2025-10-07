import java.util.Scanner;

// Classe principal que contém o método main
public class Contador {

    public static void main(String[] args) {
        // 1. Configuração do Scanner para entrada do usuário
        Scanner terminal = new Scanner(System.in);
        int parametroUm = 0;
        int parametroDois = 0;

        try {
            System.out.println("Digite o primeiro parâmetro (número inteiro):");
            parametroUm = terminal.nextInt();

            System.out.println("Digite o segundo parâmetro (número inteiro):");
            parametroDois = terminal.nextInt();

            // 3. Chamando o método de contagem dentro do bloco try
            contar(parametroUm, parametroDois);

        } catch (ParametrosInvalidosException exception) {
            // 4. Tratamento da exceção: imprime a mensagem customizada
            System.out.println("ERRO: " + exception.getMessage());
        } catch (Exception e) {
            // Tratamento genérico para erros de entrada (ex: digitar texto ao invés de número)
            System.out.println("ERRO de entrada: Certifique-se de digitar números inteiros válidos.");
        } finally {
             // Garante que o Scanner seja fechado
            terminal.close();
        }
    }

    // 2. Método com a Lógica de Contagem e Validação
    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {

        // **A. Validação da Condição de Negócio (Controle de Fluxo)**
        // Se o primeiro parâmetro for MAIOR que o segundo, lança a exceção.
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        // B. Cálculo das Interações
        int contagem = parametroDois - parametroUm;

        System.out.println("\nIniciando contagem de " + contagem + " interações...");

        // **C. Laço de Repetição (Controle de Fluxo)**
        // Realiza o loop 'contagem' vezes.
        for (int i = 1; i <= contagem; i++) {
            // Imprime o número incrementado
            System.out.println("Imprimindo o número " + i);
        }

        System.out.println("Contagem finalizada.");
    }
}

// Classe de exceção customizada (não precisa ser public se estiver no mesmo arquivo)
class ParametrosInvalidosException extends Exception {
    public ParametrosInvalidosException(String message) {
        super(message);
    }
}
