package frontend;

import backend.Sistema;

public class MenuAdminRequisicaoInstrumentos {

    public void menuReqInst(Sistema sistema, Consola consola) {
        consola.cls();;
        int opc;

        do {
            consola.escrever("-- REQUISIÇÃO DE INSTRUMENTOS --\n");
            consola.escrever("\n[1] Listar pedidos de requisição");
            consola.escrever("\n[2] Conceder/Recusar pedidos pendentes");
            consola.escrever("\n[3] Definir limite de requisições");
            consola.escrever("\n[4] EXIT\n");
            opc = consola.lerInteiro("-> ");

            switch (opc) {
                case 1:
                    ListarPedidosRequisicao pr = new ListarPedidosRequisicao();
                    pr.listarPedReq(sistema, consola);
                    break;

                case 2:
                    ConcederRecusarPedidosPendentes pp = new ConcederRecusarPedidosPendentes();
                    pp.pedidosPendentes(sistema, consola);
                    break;

                case 3: 
                    DefinirLimiteRequisicoes defLim = new DefinirLimiteRequisicoes();
                    defLim.defLimReq(sistema,consola);
                    break;

                case 4:
                    break;

                default:
                    consola.escrever("\nOpção inválida!\n\n");
                    break;
            }
        } while (opc != 4);
    }
}
