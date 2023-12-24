package frontend;

import backend.Instrumento;
import backend.Musico;
import backend.RequisicaoInstrumentos;
import backend.Sistema;
import backend.Utilizador;
import java.time.LocalDate;
import java.util.Random;


public class RequisicaoInstrumentosSessaoGravacao {
    
    public void reqInst(Sistema sistema, Consola consola, Utilizador u){
        consola.cls();
        consola.escrever("- REQUISIÇÃO DE INSTRUMENTOS -\n\n");
        
        RequisicaoInstrumentos reqIns = new RequisicaoInstrumentos();
        
        if(reqIns.getNumMaxRqIns() == sistema.getRequisicaoInstrumentos().devolverTamanhoMapRqInst() && reqIns.getNumMaxRqIns()>0){
            consola.escrever("ERRO!\nFoi atingido o limite máximo de requisições de instrumentos!");
            consola.voltarMenuAnteriorBuffer();
            return;
        }
        else{
            Random gerador = new Random();
            
            if(!sistema.getInstrumentos().verificarSeNaoExisteInst()){

                if(reqIns.getNumMaxRqIns() > 0 && sistema.getSessoesGrav().verificarSeMusicoNaSessao(u.getUsername())){
                    if(sistema.getSessoesGrav().verificarSeNaoExistemSessaoGrav()){
                        consola.escrever("\nERRO!\nNão existem sessões de gravação!");
                        consola.voltarMenuAnterior();
                        return;
                    }

                    reqIns.setCodigoRq(gerador.nextInt(reqIns.getNumMaxRqIns()));

                    reqIns.setMusico((Musico) u);                       // cast (Utilizador para Musico)

                    int cod = consola.lerInteiro("Código da sessão: ");
                    while(!sistema.getSessoesGrav().verificarSeExisteSessaoGrav(cod) && sistema.getSessoesGrav().verificarSeMusicoNaSessao(u.getUsername())){
                        consola.escrever("\nSessão inexistente!");
                        cod = consola.lerInteiro("\nIntroduza outro código: ");
                    }
                    reqIns.setSessao(sistema.getSessoesGrav().devolverSessaoGravacao(cod));

                    int numIns = consola.lerInteiro("\nQuantos instrumentos pretende requisitar?\n> ");
                    while(numIns > sistema.getInstrumentos().numeroInstrumentos()){
                        consola.escrever("\nERRO! Só existem "+sistema.getInstrumentos().numeroInstrumentos()+" instrumentos!");
                        numIns = consola.lerInteiro("\nIntroduza um número de 1 a "+sistema.getInstrumentos().numeroInstrumentos()+": ");
                    }

                    consola.escrever("\nInstrumentos disponíveis:\n\n"+sistema.getInstrumentos());

                    for(int i = 0; i<numIns; i++){
                        Instrumento ins = new Instrumento();
                        cod = consola.lerInteiro("\nCódigo do instrumento a requisitar: ");
                        while(!sistema.getInstrumentos().verificarSeExisteInst(cod)){
                            cod = consola.lerInteiro("\nCódigo inexistente!\nIntroduza um código válido: ");
                        }
                        ins.setCodInstrumento(cod);

                        String nomeIns = sistema.getInstrumentos().devolverInstrumento(cod).getNomeInstrumento();
                        ins.setNomeInstrumento(nomeIns);

                        reqIns.addInstrumento(ins);
                    }

                    reqIns.setDataRequisicao(LocalDate.now());

                    reqIns.setEstadoRequisicao("Pendente");

                    sistema.getRequisicaoInstrumentos().inserir(reqIns);

                    consola.escrever("\nPedido de requisição realizado com sucesso!");

                    consola.voltarMenuAnteriorBuffer();
                }
                else if(reqIns.getNumMaxRqIns() <= 0){
                    consola.escrever("\nERRO!\nAinda não foi definido o limite de requisições!");
                    consola.voltarMenuAnteriorBuffer();
                }
                else if(!sistema.getSessoesGrav().verificarSeMusicoNaSessao(u.getUsername())){
                    consola.escrever("\nERRO!\nO " +u.getNome()+ " não está associado a nenhuma sessão de gravação!");
                    consola.voltarMenuAnteriorBuffer();
                }
                int opcao;

                do {
                    consola.escrever("\n\n[1] Voltar ao menu anterior");
                    consola.escrever("\n[2] Fazer outra requisição de instrumentos\n");
                    opcao = consola.lerInteiro("-> ");
                    switch (opcao) {
                        case 1:
                            break;

                        case 2:
                            reqInst(sistema, consola, u);
                            break;

                        default:
                            consola.escrever("\nOpção inválida!");
                    }
                } while (opcao != 1 && opcao != 2);
            }
            else{
                consola.escrever("\nERRO! Não existem instrumentos registados!");
                consola.voltarMenuAnteriorBuffer();
            }
        }
    }
}
