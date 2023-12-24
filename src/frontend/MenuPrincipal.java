package frontend;

import backend.Sistema;

public class MenuPrincipal {

    public MenuPrincipal() {
    }

    public void menuPrincipal(Sistema sistema, Consola consola) {
        int opc = 0;
        Login log = new Login();;

        // ciclo do while para o menu principal do programa
        do {
            consola.cls();
            consola.escrever("--- MENU PRINCIPAL ---\n");
            consola.escrever("\n[1] Administrador");
            consola.escrever("\n[2] Produtor");
            consola.escrever("\n[3] Músico");
            consola.escrever("\n[4] Guardar dados em ficheiro");
            consola.escrever("\n[5] Carregar dados de um ficheiro");
            consola.escrever("\n[6] EXIT\n");
            opc = consola.lerInteiro("-> ");
            
            switch (opc) {

                case 1:
                    log.fazerLogin(sistema, consola, opc);
                    break;

                case 2:
                    log.fazerLogin(sistema, consola, opc);
                    break;

                case 3:
                    log.fazerLogin(sistema, consola, opc);
                    break;
                
                case 4: 
                    GuardarDados gD = new GuardarDados();
                    gD.guardarDadosFicheiro(sistema, consola);
                    break;
                    
                case 5:
                    CarregarDados cD = new CarregarDados();
                    cD.carregarDadosFicheiro(sistema, consola);
                    break;
                    
                case 6:
                    break;
                    
                default:
                    consola.escrever("\nOpcao inválida!\n\n");
                    break;
            }
        } while (opc != 6);
    }
}
