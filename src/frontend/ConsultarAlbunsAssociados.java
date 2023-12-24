package frontend;

import backend.Sistema;
import backend.Utilizador;


public class ConsultarAlbunsAssociados {

    public ConsultarAlbunsAssociados () {
    }

    public void ConsultarAlbAss(Sistema sistema, Consola consola, Utilizador u) {
        consola.cls();
        int opcao;
        do {
            consola.cls();
            consola.escrever("-- CONSULTAR ÁLBUNS ASSOCIADOS --\n");
            consola.escrever("\n[1] Consultar álbuns já realizados");
            consola.escrever("\n[2] Consultar álbuns em produção");
            consola.escrever("\n[3] EXIT\n");
            opcao = consola.lerInteiro("-> ");

            switch (opcao) {
                case 1:
                    if (sistema.getAlbuns().verificarSeNaoExistemAlbum()) {
                        consola.escrever("\nNão existem registos de álbuns no sistema!");
                        consola.voltarMenuAnteriorBuffer();
                    }
                    else {
                        consola.cls();
                        consola.escrever("- ÁLBUNS JÁ REALIZADOS -\n\n");
                        consola.escrever(sistema.getAlbuns().devolverAlbunsDeUmProdutorOuMusico(u.getUsername(), 1, 2).toString());
                        //consola.escrever(sistema.getAlbuns().printAlbunsMusico(u.getUsername(), 1).toString());
                        consola.voltarMenuAnteriorBuffer();
                    }
                    break;

                case 2:
                    if (sistema.getAlbuns().verificarSeNaoExistemAlbum()) {
                        consola.escrever("\nNão existem registos de álbuns no sistema!");
                        consola.voltarMenuAnteriorBuffer();
                    }
                    else {
                        consola.cls();
                        consola.escrever("- ÁLBUNS EM PRODUÇÃO -\n\n");
                        consola.escrever(sistema.getAlbuns().devolverAlbunsDeUmProdutorOuMusico(u.getUsername(), 2, 2).toString());
                        //consola.escrever(sistema.getAlbuns().printAlbunsMusico(u.getUsername(), 2).toString());
                        consola.voltarMenuAnteriorBuffer();
                    }
                    break;

                case 3:
                    break;

                default:
                    consola.escrever("\nOpção inválida!");
                    break;
            }
        } while (opcao != 3);
    }
}
