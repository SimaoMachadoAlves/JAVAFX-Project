package frontend;

import backend.Sistema;
import backend.Utilizador;

public class MenuAdmin {

    public MenuAdmin() {
    }

    public void menuA(Sistema sistema, Consola consola, Utilizador u) {
        int opc;
        
        do {
            consola.cls();
            consola.escrever("-- MENU ADMINISTRADOR --\n");
            consola.escrever("\n[1] Adicionar Produtor");
            consola.escrever("\n[2] Adicionar Músico");
            consola.escrever("\n[3] Remover Produtor");
            consola.escrever("\n[4] Remover Músico");
            consola.escrever("\n[5] Registar Álbum");
            consola.escrever("\n[6] Remover Álbum");
            consola.escrever("\n[7] Registar instrumento");
            consola.escrever("\n[8] Remover instrumento");
            consola.escrever("\n[9] Requisição instrumentos");
            consola.escrever("\n[10] Consultar situação atual de um álbum");
            consola.escrever("\n[11] Estatísticas totais");
            consola.escrever("\n[12] EXIT\n");
            opc = consola.lerInteiro("-> ");
            
            switch (opc) {
                case 1:
                    AdicionarUtilizador adUt = new AdicionarUtilizador(); //PRODUTOR
                    adUt.adicionarUtilizador(sistema, consola, opc);
                    break;

                case 2:
                    adUt = new AdicionarUtilizador(); //MUSICO
                    adUt.adicionarUtilizador(sistema, consola, opc);
                    break;

                case 3:
                    RemoverUtilizador rmUt = new RemoverUtilizador(); //PRODUTOR
                    rmUt.removerUtilizador(sistema, consola, opc, u);
                    break;
                
                case 4:
                    rmUt = new RemoverUtilizador(); //MUSICO
                    rmUt.removerUtilizador(sistema, consola, opc, u);
                    break;
                    
                case 5:
                    RegistarAlbum regAlb = new RegistarAlbum();
                    regAlb.registarAlbum(sistema, consola);
                    break;

                case 6:
                    RemoverAlbum rmAlb = new RemoverAlbum();
                    rmAlb.removerAlbum(sistema, consola);
                    break;
                    
                case 7:
                    RegistarInstrumento regInst = new RegistarInstrumento();
                    regInst.registarInst(sistema, consola);
                    break;

                case 8:
                    RemoverInstrumento rmInst = new RemoverInstrumento();
                    rmInst.removerInst(sistema, consola);
                    break;
                    
                case 9:
                    MenuAdminRequisicaoInstrumentos rqInst = new MenuAdminRequisicaoInstrumentos();
                    rqInst.menuReqInst(sistema, consola);
                    break;
                
                case 10:
                    ConsultarSituacaoAtualAlbum csa = new ConsultarSituacaoAtualAlbum();
                    csa.consultarSitAlbum(sistema, consola, u);
                    break;
                    
                case 11:
                    MenuEstatisticasTotais em = new MenuEstatisticasTotais();
                    em.menuEstatTotais(sistema, consola);
                    break;
                
                case 12:
                    break;
                    
                default:
                    consola.escrever("\nOpção inválida!\n\n");
                    break;
            }
        } while (opc != 12);
    }

}
