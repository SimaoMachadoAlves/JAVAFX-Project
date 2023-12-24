package frontend;

import backend.Sistema;
import backend.Utilizador;
import java.util.ArrayList;

public class ConsultarAlbunsProduzidos {

    /*MENU PRODUTOR*/
    public void consultarAlbProd(Sistema sistema, Consola consola, Utilizador u) {
        consola.cls();
        int opcao;
        do {
            consola.cls();
            consola.escrever("-- CONSULTAR ÁLBUNS --\n");
            consola.escrever("\n[1] Consultar álbuns produzidos");
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
                        consola.escrever("- ÁLBUNS PRODUZIDOS -\n\n");
                        
                        /*SortedMap<Integer, Album> albunsProduzidos;
                        albunsProduzidos = sistema.getAlbuns().devolverAlbunsDeUmProdutorOuMusico(u.getUsername(), 1, 1);
                        if(albunsProduzidos.isEmpty())
                            consola.escrever("ERRO!\nO "+ u.getNome() +" ainda não concluíu nenhum álbum!");
                        
                        else
                            consola.escrever(albunsProduzidos.toString());
                        consola.voltarMenuAnteriorBuffer();*/
                        
                        ArrayList<String> albunsProduzidos;
                        albunsProduzidos = sistema.getAlbuns().printAlbunsProdutor(u.getUsername(), 1);
                        if(albunsProduzidos.isEmpty())
                            consola.escrever("ERRO!\nO "+ u.getNome() +" ainda não concluíu nenhum álbum!");
                        
                        else
                            consola.escrever(albunsProduzidos.toString());
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
                        
                        /*SortedMap<Integer, Album> albunsEmProducao;
                        albunsEmProducao = sistema.getAlbuns().devolverAlbunsDeUmProdutorOuMusico(u.getUsername(), 2, 1);
                        if(albunsEmProducao.isEmpty())
                            consola.escrever("ERRO!\nO "+ u.getNome() +" ainda não produziu nenhum álbum!\n");
                        
                        else
                            consola.escrever(albunsEmProducao.toString());
                        consola.voltarMenuAnteriorBuffer();*/
                        
                        ArrayList<String> albunsProduzidos;
                        albunsProduzidos = sistema.getAlbuns().printAlbunsProdutor(u.getUsername(), 2);
                        if(albunsProduzidos.isEmpty())
                            consola.escrever("ERRO!\nO "+ u.getNome() +" ainda não produziu nenhum álbum!");
                        
                        else
                            consola.escrever(albunsProduzidos.toString());
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
