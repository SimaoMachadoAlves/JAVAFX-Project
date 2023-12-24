package frontend;

import backend.Administrador;
import backend.Produtor;
import backend.Sistema;
import backend.Utilizador;

public class ConsultarSituacaoAtualAlbum {
    /*MENU ADMIN E PRODUTOR*/
    
    public void mensagem(Sistema sistema, Consola consola, Utilizador u) {
        int opcao;
        do {
            consola.escrever("\n\n[1] Voltar ao menu anterior");
            consola.escrever("\n[2] Voltar a iniciar edição de um álbum\n");
            opcao = consola.lerInteiro("-> ");
            
            switch (opcao) {
                case 1:
                    break;

                case 2:
                    consultarSitAlbum(sistema, consola, u);
                    break;

                default:
                    consola.escrever("\nOpção inválida!");
            }
        } while (opcao != 1 && opcao != 2);
    }
    
    public void consultarSitAlbum(Sistema sistema, Consola consola, Utilizador u){
        consola.cls();
        consola.escrever("- SITUAÇÃO ATUAL DOS ÁLBUNS -\n\n");
        
        if(u instanceof Administrador){
            int cod = consola.lerInteiro("Introduza o código do álbum: ");
            while(!sistema.getAlbuns().verificarSeExisteAlbum(cod)){
                consola.escrever("\nÁlbum inexistente!");
                cod = consola.lerInteiro("\nIntroduza outro código: ");
            }

            consola.escrever("\nSituação atual do " +sistema.getAlbuns().devolverAlbum(cod).getTituloAlbum()+"\n");

            try{
                consola.escrever(sistema.getSessoesGrav().devolverEstadosSessoesDeUmAlbum(cod).toString());
                
                consola.escrever("\n% de sessões concluídas: "+sistema.getAlbuns().devolverAlbum(cod).obterEstado()+"%");

            }catch(Exception e){
                consola.escrever("\nERRO!\nO álbum ainda não contém informações suficientes!\n");
            }
            mensagem(sistema, consola, u);
        }
        else if(u instanceof Produtor){
            int cod = consola.lerInteiro("Introduza o código do álbum: ");
            while(!sistema.getAlbuns().verificarSeExisteAlbum(cod) &&
                    !sistema.getAlbuns().verificarSeProdutorNoAlbum(u.getUsername(), cod)){
                if(!sistema.getAlbuns().verificarSeExisteAlbum(cod))
                    consola.escrever("\nÁlbum inexistente!");
                else if(!sistema.getAlbuns().verificarSeProdutorNoAlbum(u.getUsername(), cod))
                    consola.escrever("\nERRO! O "+ u.getNome() +" não está associado ao " +sistema.getAlbuns().devolverAlbum(cod));
                cod = consola.lerInteiro("\nIntroduza outro código: ");
            }

            consola.escrever("\nSituação atual do " +sistema.getAlbuns().devolverAlbum(cod).getTituloAlbum()+"\n");

            consola.escrever(sistema.getSessoesGrav().devolverEstadosSessoesDeUmAlbum(cod).toString());
                
            consola.escrever("\n% de sessões concluídas: "+sistema.getAlbuns().devolverAlbum(cod).obterEstado()+"%");
            
            mensagem(sistema, consola, u);
        }
    }
}