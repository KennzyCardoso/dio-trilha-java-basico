
public class ExemploExcecao {
    public static void main(String[] args) {
        try {
            String cepFormatado = formatarCep("2376506");
            System.out.println(cepFormatado);
        } catch (CepInvalidoException e) {
            System.out.println("O cep não corresponde com as regras de negocio");
        }
    }

    static String formatarCep(String cep) throws CepInvalidoException {
        if (cep == null || !cep.matches("\\d{8}")) {
            throw new CepInvalidoException();
        }
        // Formata o CEP para o padrão XX.XXX-XXX
        return cep.substring(0,2) + "." + cep.substring(2,5) + "-" + cep.substring(5,8);
    }
}

class CepInvalidoException extends Exception {
    public CepInvalidoException() {
        super("CEP inválido");
    }
}
