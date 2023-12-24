package frontend;

import backend.Sistema;
import backend.Utilizador;

public class MenuMusico {

    public MenuMusico() {
    }

    public void menuM(Sistema sistema, Consola consola, Utilizador u) {
        int opc;

        do {
            consola.cls();
            consola.escrever("-- MENU MUSICO --\n");
            consola.escrever("\n[1] Consultar dados pessoais");
            consola.escrever("\n[2] Editar dados pessoais");
            consola.escrever("\n[3] Consultar os meus álbuns");
            consola.escrever("\n[4] Consultar agenda de sessões de gravação");
            consola.escrever("\n[5] Requisitar instrumentos para uma sessão de gravação");
            consola.escrever("\n[6] Consultar estado das minhas sessões de gravação");
            consola.escrever("\n[7] EXIT\n");
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
                    ConsultarAlbunsAssociados ca = new ConsultarAlbunsAssociados();
                    ca.ConsultarAlbAss(sistema, consola, u);
                    break;

                case 4:
                    ConsultarSessoesGravacaoAgendadas csga = new ConsultarSessoesGravacaoAgendadas();
                    csga.consultarSessGravAgend(sistema, consola, u);
                    break;

                case 5:
                    RequisicaoInstrumentosSessaoGravacao rqInst = new RequisicaoInstrumentosSessaoGravacao();
                    rqInst.reqInst(sistema, consola, u);
                    break;

                case 6:
                    ConsultarEstadoSessoesGravacao cesg = new ConsultarEstadoSessoesGravacao();
                    cesg.consultarEstSessGrav(sistema, consola, u);
                    break;
                
                case 7:
                    break;

                default:
                    consola.escrever("\nOpcao inválida!\n\n");
            }

        } while (opc != 7);
    }
}
