package frontend;

import backend.Sistema;

public class ListarPedidosRequisicao {

    /* MENU ADMINISTRADOR */
    public void listarPedReq(Sistema sistema, Consola consola) {
        int opc = 0;
        do {
            consola.cls();
            consola.escrever("- PEDIDOS DE REQUISIÇÃO -\n");
            consola.escrever("\n[1] Consultar pedidos de requisição pendentes");
            consola.escrever("\n[2] Consultar pedidos de requisição atribuidos");
            consola.escrever("\n[3] Consultar pedidos de requisição recusados");
            consola.escrever("\n[4] EXIT\n");
            opc = consola.lerInteiro("-> ");

            switch (opc) {

                case 1:
                    consola.cls();
                    try{
                        /*consola.escrever("- PEDIDOS DE REQUISIÇÃO PENDENTES -\n\n" +
                                sistema.getRequisicaoInstrumentos().escreverRequisicoes(1).toString());*/
                        consola.escrever("- PEDIDOS DE REQUISIÇÃO PENDENTES -\n\n" +
                                sistema.getRequisicaoInstrumentos().printPedidos(1));
                        consola.voltarMenuAnteriorBuffer();
                    }
                    catch(NullPointerException e){
                        consola.escrever("\nERRO!\nNão existem requisições pendentes!");
                        consola.voltarMenuAnteriorBuffer();
                    }
                    break;

                case 2:
                    consola.cls();
                    try{
                        /*consola.escrever("- PEDIDOS DE REQUISIÇÃO ATRIBUÍDOS -\n\n" +
                                sistema.getRequisicaoInstrumentos().escreverRequisicoes(2).toString());*/
                        consola.escrever("- PEDIDOS DE REQUISIÇÃO ATRIBUÍDOS -\n\n" +
                                sistema.getRequisicaoInstrumentos().printPedidos(2));
                        
                        consola.voltarMenuAnteriorBuffer();
                    }
                    catch(NullPointerException e){
                        consola.escrever("\nERRO!\nNão existem requisições atribuídas!");
                        consola.voltarMenuAnteriorBuffer();
                    }
                    break;

                case 3:
                    consola.cls();
                    try{
                        /*consola.escrever("- PEDIDOS DE REQUISIÇÃO RECUSADOS -\n\n" +
                                sistema.getRequisicaoInstrumentos().escreverRequisicoes(3).toString());*/
                        consola.escrever("- PEDIDOS DE REQUISIÇÃO RECUSADOS -\n\n" +
                                sistema.getRequisicaoInstrumentos().printPedidos(3));
                        consola.voltarMenuAnteriorBuffer();
                    }
                    catch(NullPointerException e){
                        consola.escrever("\nERRO!\nNão existem requisições recusadas!");
                        consola.voltarMenuAnteriorBuffer();
                    }
                    break;

                case 4:
                    break;

                default:
                    consola.escrever("\nOpção inválida!");
                    break;
            }
        } while (opc != 4);
    }
}
