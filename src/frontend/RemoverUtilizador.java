package frontend;

import backend.Sistema;
import backend.Utilizador;

public class RemoverUtilizador {

    public void mensagem(Sistema sistema, Consola consola, Utilizador u, int tipoUser) {
        int opcao;

        do {
            consola.escrever("\n\n[1] Voltar ao menu anterior");
            if(tipoUser == 3)
                consola.escrever("\n[2] Voltar a remover um Produtor\n");
            else
                consola.escrever("\n[2] Voltar a remover um Músico\n");
            opcao = consola.lerInteiro("-> ");
            switch (opcao) {
                case 1:
                    break;

                case 2:
                    removerUtilizador(sistema, consola, tipoUser, u);
                    break;

                default:
                    consola.escrever("\nOpção inválida!");
            }
        } while (opcao != 1 && opcao != 2);
    }

    /* MENU ADMINISTRADOR */
    public void removerUtilizador(Sistema sistema, Consola consola, int opc, Utilizador u) {
        String username;
        consola.cls();

        // REMOVER PRODUTOR
        if (opc == 3) {
            consola.escrever("- REMOVER PRODUTOR -\n\n");
            username = consola.lerStringBuffer("Introduza o username do produtor que pretende apagar: ");

            // validaçao do username
            if (sistema.getUtilizadores().verificarSeExiste(username) && !username.equals(u.getUsername())
                    && sistema.getUtilizadores().verificarSeExisteProdutor(username)) {
                sistema.getUtilizadores().remover(username);            // remover do sistema 
                
                consola.escrever("\nProdutor removido com sucesso!");
                mensagem(sistema, consola, u, opc);
                
            } else if (username.equals(u.getUsername())) {
                consola.escrever("\nERRO! Impossível remover o Administrador!");
                mensagem(sistema, consola, u, opc);
            } else if (!sistema.getUtilizadores().verificarSeExisteProdutor(username)) {
                consola.escrever("\nERRO! Não existe um Produtor com este username!");
                mensagem(sistema, consola, u, opc);
            }

        } // REMOVER MUSICO
        else {
            consola.escrever("- REMOVER MÚSICO -\n\n");
            username = consola.lerStringBuffer("Introduza o username do musico que pretende apagar: ");

            // validaçao do username
            if (sistema.getUtilizadores().verificarSeExiste(username) && !username.equals(u.getUsername())
                    && sistema.getUtilizadores().verificarSeExisteMusico(username)) {
                sistema.getUtilizadores().remover(username);            // remover do sistema
                
                consola.escrever("\nMúsico removido com sucesso!");
                mensagem(sistema, consola, u, opc);
                
            } else if (username.equals(u.getUsername())) {
                consola.escrever("\nERRO! Impossível remover o Administrador!");
                mensagem(sistema, consola, u, opc);
            } else if (!sistema.getUtilizadores().verificarSeExisteProdutor(username)) {
                consola.escrever("\nERRO! Não existe um Músico com este username!");
                mensagem(sistema, consola, u, opc);
            }
        }
    }
}
