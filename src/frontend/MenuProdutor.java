package frontend;

import backend.Sistema;
import backend.Utilizador;

public class MenuProdutor {

    public MenuProdutor() {
    }

    public void menuP(Sistema sistema, Consola consola, Utilizador u) {   // por este menu como o menu do Administrador, que já está direito

        int opc;
        
        do {
            consola.cls();
            consola.escrever("-- MENU PRODUTOR --\n");
            consola.escrever("\n[1] Consultar dados pessoais");
            consola.escrever("\n[2] Editar dados pessoais");
            consola.escrever("\n[3] Iniciar edição de um álbum");
            consola.escrever("\n[4] Alterar edição de um álbum");
            consola.escrever("\n[5] Realizar sessão de gravação");
            consola.escrever("\n[6] Concluir sessão de gravação");
            consola.escrever("\n[7] Consultar situação atual de um álbum");
            consola.escrever("\n[8] Consultar álbuns");
            consola.escrever("\n[9] Consultar sessões de gravação agendadas para um dia");
            consola.escrever("\n[10] EXIT\n");
            opc = consola.lerInteiro("-> ");

            switch (opc) {
                case 1:
                    ConsultarDadosPessoais cdp = new ConsultarDadosPessoais();
                    cdp.consultarDados(sistema, consola, u);
                    break;

                case 2:
                    EditarDadosPessoais edp = new EditarDadosPessoais();
                    edp.editarDados(sistema, consola, u);
                    break;

                case 3:
                    IniciarEdicaoAlbum ia = new IniciarEdicaoAlbum();
                    ia.iniciarEdicaoAlbum(sistema, consola, u);
                    break;

                case 4:
                    AlterarEdicaoAlbum altEditAlb = new AlterarEdicaoAlbum();
                    altEditAlb.altEdicaoAlbum(sistema, consola, u);
                    break;
                
                case 5:
                    RealizarSessaoGrav rSess = new RealizarSessaoGrav();
                    rSess.realizarSessGrav(sistema,consola, u);
                    break;
                    
                case 6:
                    ConcluirSessaoGravacao csg = new ConcluirSessaoGravacao();
                    csg.concSessGrav(sistema, consola, u);
                    break;

                case 7:
                    ConsultarSituacaoAtualAlbum csa = new ConsultarSituacaoAtualAlbum();
                    csa.consultarSitAlbum(sistema, consola, u);
                    break;

                case 8:
                    ConsultarAlbunsProduzidos cap = new ConsultarAlbunsProduzidos();
                    cap.consultarAlbProd(sistema, consola, u);
                    break;

                case 9:
                    ConsultarSessoesGravacaoAgendadas csga = new ConsultarSessoesGravacaoAgendadas();
                    csga.consultarSessGravAgend(sistema, consola, u);
                    break;

                case 10:
                    break;

                default:
                    consola.escrever("\nOpcao inválida!\n\n");
            }
        } while (opc != 10);
    }
}
