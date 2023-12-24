package frontend;

import backend.Instrumento;
import backend.Sistema;

public class RegistarInstrumento {

    /* MENU ADMINISTRADOR */
    public void registarInst(Sistema sistema, Consola consola) {
        consola.cls();

        Instrumento i = new Instrumento();
        consola.escrever("- REGISTAR INSTRUMENTO -\n\n");
        int codigo = consola.lerInteiro("Código do instrumento: ");
        while(sistema.getInstrumentos().verificarSeExisteInst(codigo)){
            consola.escrever("\nERRO!\nJá existe um instrumento com o código "+codigo);
            codigo = consola.lerInteiro("\nIntroduza um novo código: ");
        }
        i.setCodInstrumento(codigo);
        
        String aux = consola.lerStringBuffer("Designação do instrumento: ");
        i.setNomeInstrumento(aux);

        sistema.getInstrumentos().inserir(i);
        
        consola.escrever("\nInstrumento registado com sucesso!");
        int opcao;

        do {
            consola.escrever("\n\n[1] Voltar ao menu anterior");
            consola.escrever("\n[2] Registar outro instrumento\n");
            opcao = consola.lerInteiro("-> ");
            switch (opcao) {
                case 1:
                    break;

                case 2:
                    registarInst(sistema, consola);
                    break;

                default:
                    consola.escrever("\nOpção inválida!");
            }
        } while (opcao != 1 && opcao != 2);
    }
}
