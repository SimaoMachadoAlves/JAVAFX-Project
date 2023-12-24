package frontend;

import backend.Musico;
import backend.Produtor;
import backend.Sistema;
import backend.Utilizador;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConsultarSessoesGravacaoAgendadas {
    /*MENU PRODUTOR E MUSICO*/
    
    public void mensagem(Sistema sistema, Consola consola, Utilizador u) {
        int opcao;
        do {
            consola.escrever("\n\n[1] Voltar ao menu anterior");
            consola.escrever("\n[2] Voltar a consultar sessões de gravação agendadas\n");
            opcao = consola.lerInteiro("-> ");
            
            switch (opcao) {
                case 1:
                    break;

                case 2:
                    consultarSessGravAgend(sistema, consola, u);
                    break;

                default:
                    consola.escrever("\nOpção inválida!");
            }
        } while (opcao != 1 && opcao != 2);
    }
    
    public void consultarSessGravAgend(Sistema sistema, Consola consola, Utilizador u){
        consola.cls();
        consola.escrever("- SESSÕES DE GRAVAÇÃO AGENDADAS -\n\n");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = null;
        
        if(u instanceof Produtor){
            try{
                data = consola.lerDataFuturaBuffer("Introduza uma data: ");
                consola.escrever("Sessões de gravação agendadas para o dia "+dtf.format(data)+"\n\n");
                consola.escrever(sistema.getSessoesGrav().devolverSessaoDataEspecifica(data, u.getUsername(), 1).toString());
                mensagem(sistema, consola, u);
            }
            catch(NullPointerException e){
                consola.escrever("\nNão existem sessões para este dia ("+dtf.format(data)+")");
                consola.voltarMenuAnterior();
            }
        }
        else if(u instanceof Musico){
            try{
                data = consola.lerDataFuturaBuffer("Introduza uma data: ");
                consola.escrever("Sessões de gravação agendadas para o dia "+dtf.format(data)+":\n\n");
                consola.escrever(sistema.getSessoesGrav().devolverSessaoDataEspecifica(data, u.getUsername(), 2).toString());
                mensagem(sistema, consola, u);
            }
            catch(NullPointerException e){
                consola.escrever("Não existem sessões para este dia!");
                consola.voltarMenuAnteriorBuffer();
            }
        }
    }
}
