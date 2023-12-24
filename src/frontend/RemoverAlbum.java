package frontend;

import backend.Sistema;

public class RemoverAlbum {

    //MENU ADMINISTRADOR
    public void removerAlbum(Sistema sistema, Consola consola) {
        consola.cls();
        consola.escrever("- REMOVER ALBUM -\n\n");
        consola.escrever("Álbuns registados\n\n"+sistema.getAlbuns().devolverRegistoAlbum());

        int num = consola.lerInteiro("\n\nIntroduza o código do álbum que pretende remover: ");

        if (sistema.getAlbuns().verificarSeExisteAlbum(num)) {
            sistema.getAlbuns().remover(num);
            consola.escrever("\nÁlbum removido com sucesso!");

            int opcao;

            do {
                consola.escrever("\n\n[1] Voltar ao menu anterior");
                consola.escrever("\n[2] Remover outro álbum\n");
                opcao = consola.lerInteiro("-> ");
                switch (opcao) {
                    case 1:
                        break;

                    case 2:
                        removerAlbum(sistema, consola);
                        break;

                    default:
                        consola.escrever("\nOpção inválida!");
                }
            } while (opcao != 1 && opcao != 2);

        } else {

            consola.escrever("ERRO! Não existe esse álbum!");
            int opcao;

            do {
                consola.escrever("\n\n[1] Voltar ao menu anterior");
                consola.escrever("\n[2] Remover outro álbum\n");
                opcao = consola.lerInteiro("-> ");
                switch (opcao) {
                    case 1:
                        return;

                    case 2:
                        removerAlbum(sistema, consola);
                        break;

                    default:
                        consola.escrever("\nOpção inválida!");
                }
            } while (opcao != 1 && opcao != 2);
        }
    }
}
