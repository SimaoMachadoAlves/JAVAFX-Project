package frontend;

import backend.SessaoGravacao;
import backend.Sistema;
import backend.Utilizador;
import java.time.LocalDate;


public class ConcluirSessaoGravacao {
    /* MENU PRODUTOR */
    
    public ConcluirSessaoGravacao(){
    }

    public void mensagem(Sistema sistema, Consola consola, Utilizador u) {
        consola.escrever("\n\n[1] Voltar ao menu anterior");
        consola.escrever("\n[2] Voltar a concluir uma sessão de gravação\n");
        int opcao = consola.lerInteiro("-> ");

        do {
            switch (opcao) {
                case 1:
                    break;

                case 2:
                    concSessGrav(sistema, consola, u);
                    break;

                case 3:
                    break;

                default:
                    consola.escrever("\nOpção inválida!");
            }
        } while (opcao != 1 && opcao != 2);
    }
    
    public void concSessGrav(Sistema sistema, Consola consola, Utilizador u){
        consola.cls();
        consola.escrever("- CONCLUIR SESSÃO DE GRAVAÇÃO -\n\n");
        
        int cod = consola.lerInteiro("Introduza o código do álbum da sessão que pretende concluir: ");
        
        //verificar se o album existe e se o produtor em questão é "dono" desse album
        if(sistema.getAlbuns().verificarSeExisteAlbum(cod) && sistema.getAlbuns().devolverUsernameProdutorAlbum(cod).equals(u.getUsername())){
            SessaoGravacao s = sistema.getSessoesGrav().getProximaSessaoAConcluirAlbum(cod);
            if(s == null){
                consola.escrever("Não existem sessões de gravação!");
                consola.voltarMenuAnterior();
                return;
            }
            consola.escrever("\nSessão de gravação que pode concluir:\n\n"+s);
            
            int codProx = s.getCodigoSessao();
            
            consola.escrever("\n\nPretende concluir esta sessão?\n[1] Sim\n[2] Não");
            int opc = consola.lerInteiro("\n> ");
            while(opc != 1 && opc != 2){
                consola.escrever("Opção inválida!\n");
                opc = consola.lerInteiro("Introduza uma opção entre [1] e [2]: ");
            }
            
            if(opc == 1){
                sistema.getSessoesGrav().devolverSessaoGravacao(codProx).setEstadoSessao("Concluído");
                LocalDate date = LocalDate.now();
                sistema.getSessoesGrav().devolverSessaoGravacao(codProx).setDataFinalSessao(date);
                int aux = sistema.getAlbuns().devolverAlbum(cod).getNumSessoesConcluidas();
                aux++;
                sistema.getAlbuns().devolverAlbum(cod).setNumSessoesConcluidas(aux);
                consola.escrever("\nSessão concluída!");
            }
            else{
                consola.voltarMenuAnteriorBuffer();
                return;
            }
            
            mensagem(sistema, consola, u);
        }
        else if(!sistema.getAlbuns().verificarSeExisteAlbum(cod)){
            consola.escrever("\nERRO! Não existe esse álbum!");
            mensagem(sistema, consola, u);
        }
        else if(!sistema.getAlbuns().devolverUsernameProdutorAlbum(cod).equals(u.getUsername())){
            consola.escrever("\nERRO! Este álbum não é seu!");
            mensagem(sistema, consola, u);
        }
    }
}
