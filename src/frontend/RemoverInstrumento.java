package frontend;

import backend.Sistema;

public class RemoverInstrumento {

    /* MENU ADMINISTRADOR */
    public void removerInst(Sistema sistema, Consola consola) {
        consola.cls();

        consola.escrever(sistema.getInstrumentos().toString());
        consola.escrever("- REMOVER INSTRUMENTO -\n\n");
        int codigo = consola.lerInteiro("Introduza o código do instrumento que pretende remover: ");
        // validação do instrumento
        if (sistema.getInstrumentos().verificarSeExisteInst(codigo)) {
            sistema.getInstrumentos().remover(codigo);
            consola.escrever("\nInstrumento removido com sucesso!");

            int opcao;

            do {
                consola.escrever("\n\n[1] Voltar ao menu anterior");
                consola.escrever("\n[2] Remover outro instrumento\n");
                opcao = consola.lerInteiro("-> ");
                
                switch (opcao) {
                    case 1:
                        break;

                    case 2:
                        removerInst(sistema, consola);
                        break;

                    default:
                        consola.escrever("\nOpção inválida!");
                }
            } while (opcao != 1 && opcao != 2);
        } else {
            consola.escrever("ERRO! Não existe esse instrumento");

            int opcao;

            do {
                consola.escrever("\n\n[1] Voltar ao menu anterior");
                consola.escrever("\n[2] Remover outro instrumento\n");
                opcao = consola.lerInteiro("-> ");
                switch (opcao) {
                    case 1:
                        break;

                    case 2:
                        removerInst(sistema, consola);
                        break;

                    default:
                        consola.escrever("\nOpção inválida!");
                }
            } while (opcao != 1 && opcao != 2);
        }
    }
}