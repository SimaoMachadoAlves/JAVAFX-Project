package frontend;

import backend.Sistema;


public class MenuEstatisticasTotais {
    /* MENU ADMINISTRADOR */
    
    public MenuEstatisticasTotais(){
    }

    public void menuEstatTotais(Sistema sistema, Consola consola) {
        consola.cls();;
        int opc;

        do {
            consola.escrever("-- ESTATÍSTICAS TOTAIS --\n");
            consola.escrever("\n[1] Consultar total de álbuns em edição");
            consola.escrever("\n[2] Consultar média da percentagem de sessões de gravação concluídas");
            consola.escrever("\n[3] Consultar total de albúns produzidos");
            consola.escrever("\n[4] EXIT\n");
            opc = consola.lerInteiro("-> ");

            switch (opc) {
                case 1:
                    ConsultarTotalAlbunsEmEdicao caem = new ConsultarTotalAlbunsEmEdicao();
                    caem.totalAlbunsEmEdicao(sistema, consola);
                    break;

                case 2:
                    ConsultarMediaPercentagemSessoesConcluidas cmpsc = new ConsultarMediaPercentagemSessoesConcluidas();
                    cmpsc.mediaPercentagemSessoesConcluidas(sistema, consola);
                    break;
                    
                case 3: 
                    ConsultarTotalAlbunsProduzidos ctap = new ConsultarTotalAlbunsProduzidos();
                    ctap.totalAlbunsProduzidos(sistema, consola);
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
