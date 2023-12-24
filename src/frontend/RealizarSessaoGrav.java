package frontend;

import backend.SessaoGravacao;
import backend.Sistema;
import backend.Utilizador;

public class RealizarSessaoGrav {
    
    /* MENU PRODUTOR */
    public RealizarSessaoGrav() {
    }
    
    public void mensagem(Sistema sistema, Consola consola, Utilizador u){
        consola.escrever("\n\n[1] Voltar ao menu anterior");
        consola.escrever("\n[2] Voltar a realizar uma sessão de gravação\n");
        int opcao = consola.lerInteiro("-> ");

        do {
            switch (opcao) {
                case 1:
                    break;

                case 2:
                    realizarSessGrav(sistema, consola, u);
                    break;

                case 3:
                    break;

                default:
                    consola.escrever("\nOpção inválida!");
            }
        } while (opcao != 1 && opcao != 2);
    }
    
    public void realizarSessGrav(Sistema sistema, Consola consola, Utilizador u){
        consola.cls();
        consola.escrever("- REALIZAR SESSÃO DE GRAVAÇÃO -\n\n");
        
        int cod = consola.lerInteiro("Introduza o código do álbum da sessão que pretende realizar: ");
        
        //verificar se o album existe e se o produtor em questão é "dono" desse album
        if(sistema.getAlbuns().verificarSeExisteAlbum(cod) && sistema.getAlbuns().devolverUsernameProdutorAlbum(cod).equals(u.getUsername())){
            SessaoGravacao s = sistema.getSessoesGrav().getProximaSessaoARealizarAlbum(cod);
            if(s == null){
                consola.escrever("Não existem sessões de gravação!");
                consola.voltarMenuAnterior();
                return;
            }
            consola.escrever("\nSessão de gravação que pode realizar:\n\n"+s);
            
            int codProx = s.getCodigoSessao();
            
            consola.escrever("\n\nPretende realizar esta sessão?\n[1] Sim\n[2] Não");
            int opc = consola.lerInteiro("\n> ");
            while(opc != 1 && opc != 2){
                consola.escrever("Opção inválida!\n");
                opc = consola.lerInteiro("Introduza uma opção entre [1] e [2]: ");
            }
            if(opc == 1){
                if(sistema.getRequisicaoInstrumentos().validacaoParaRealizarSessaoGrav(codProx)){
                    sistema.getSessoesGrav().devolverSessaoGravacao(codProx).setEstadoSessao("Iniciado");
                    consola.escrever("\nSessão realizada!");
                }
                else{
                    consola.escrever("\nERRO!\nPossíveis erros:\n1- Não existe nenhuma requisição de instrumentos para esta sessão de gravação!"
                            + "\n2- O pedido de requisição de instrumentos (ainda) não foi aceite pelo admin!"
                            + "\n3- Não existe nenhuma sessão de gravação com esse código!");
                }
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