package frontend;

import backend.Sistema;


public class ConcederRecusarPedidosPendentes {
    /* MENU ADMINISTRADOR */


    public void pedidosPendentes(Sistema sistema, Consola consola){
        consola.cls();
        consola.escrever("- PEDIDOS DE REQUISIÇÃO PENDENTES -\n\n");
        
        if(!sistema.getRequisicaoInstrumentos().verificarSeNaoExistemReqInst()){
            consola.escrever("[1] Conceder pedidos\n[2] Recusar pedidos");
            int opc = consola.lerInteiro("\n-> ");
            while(opc != 1 && opc != 2){
                consola.escrever("\nOpção inválida!");
                opc = consola.lerInteiro("\nIntroduza uma opção ([1] ou [2]): ");
            }

            switch(opc){
                case 1:
                    consola.cls();
                    consola.escrever("- CONCEDER PEDIDOS DE REQUISIÇÃO PENDENTES -\n\n");
                    //consola.escrever(sistema.getRequisicaoInstrumentos().escreverRequisicoes(1).toString());
                    consola.escrever(sistema.getRequisicaoInstrumentos().printPedidos(1).toString());
                    int cod = consola.lerInteiro("\n\nIntroduza o código do pedido de requisição pendente que pretende conceder: ");
                    while(!sistema.getRequisicaoInstrumentos().verificarSeExisteReqInst(cod)){
                        consola.escrever("\nERRO! Código de requisição inexistente!");
                        cod = consola.lerInteiro("Introduza um código válido: ");
                    }
                    sistema.getRequisicaoInstrumentos().devolverReqIns(cod).setEstadoRequisicao("Atribuído");
                    
                    consola.escrever("\nPedido de requisição aceite!");
                    
                    break;

                case 2:
                    consola.cls();
                    consola.escrever("- RECUSAR PEDIDOS DE REQUISIÇÃO PENDENTES -\n\n");
                    //consola.escrever(sistema.getRequisicaoInstrumentos().escreverRequisicoes(1).toString());
                    consola.escrever(sistema.getRequisicaoInstrumentos().printPedidos(1).toString());
                    cod = consola.lerInteiro("\n\nIntroduza o código do pedido de requisição pendente que pretende recusar: ");
                    while(!sistema.getRequisicaoInstrumentos().verificarSeExisteReqInst(cod)){
                        consola.escrever("\nERRO! Código de requisição inexistente!");
                        cod = consola.lerInteiro("Introduza um código válido: ");
                    }
                    sistema.getRequisicaoInstrumentos().devolverReqIns(cod).setEstadoRequisicao("Recusado");
                    
                    consola.escrever("\nPedido de requisição recusada!");
                    break;
            }
        }
        else{
            consola.escrever("\nERRO! Não existem pedidos de requisição!");
        }
        int opcao;

        do {
            consola.escrever("\n\n[1] Voltar ao menu anterior");
            consola.escrever("\n[2] Voltar a conceder/recusar pedidos pendentes\n");
            opcao = consola.lerInteiro("-> ");
            switch (opcao) {
                case 1:
                    break;

                case 2:
                    pedidosPendentes(sistema, consola);
                    break;

                default:
                    consola.escrever("\nOpção inválida!");
            }
        } while (opcao != 1 && opcao != 2);
    }
}