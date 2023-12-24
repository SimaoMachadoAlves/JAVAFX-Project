package frontend;

import backend.Sistema;
import backend.Utilizador;


public class ConsultarEstadoSessoesGravacao {
    /*MENU MUSICO*/
    public void consultarEstSessGrav(Sistema sistema, Consola consola, Utilizador u){
        consola.cls();
        consola.escrever("- CONSULTAR ESTADO DAS SESSÕES DE GRAVAÇÃO -\n\n");
        
        if(sistema.getAlbuns().verificarSeNaoExistemAlbum()){
            consola.escrever("ERRO! Não existem álbuns registados!");
            consola.voltarMenuAnteriorBuffer();
            return;
        }
        else{
            int cod = consola.lerInteiro("Introduza o código do álbum: ");
            while(!sistema.getAlbuns().verificarSeExisteAlbum(cod) && 
                    !sistema.getAlbuns().verificarSeMusicoNoAlbum(u.getUsername(), cod)){
                if(!sistema.getAlbuns().verificarSeExisteAlbum(cod))
                    consola.escrever("\nERRO! Álbum inexistente!");
                else if(!sistema.getAlbuns().verificarSeMusicoNoAlbum(u.getUsername(), cod))
                    consola.escrever("\nERRO! O "+ u.getNome() +" não está associado ao " +sistema.getAlbuns().devolverAlbum(cod));
                cod = consola.lerInteiro("\nIntroduza outro código: ");
            }

            consola.escrever("\nEstado das sessões do "+sistema.getAlbuns().devolverAlbum(cod).getTituloAlbum() +"\n");

            consola.escrever(sistema.getSessoesGrav().devolverEstadosSessoesDeUmAlbum(cod).toString());
            
            int opcao;

            do {
                consola.escrever("\n\n[1] Voltar ao menu anterior");
                consola.escrever("\n[2] Voltar a consultar o estado das sessões de gravação\n");
                opcao = consola.lerInteiro("-> ");
                switch (opcao) {
                    case 1:
                        break;

                    case 2:
                        consultarEstSessGrav(sistema, consola, u);
                        break;

                    default:
                        consola.escrever("\nOpção inválida!");
                }
            } while (opcao != 1 && opcao != 2);
        }
    }
}