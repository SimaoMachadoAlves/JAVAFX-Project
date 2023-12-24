package frontend;

import backend.Musico;
import backend.Produtor;
import backend.Sistema;
import java.time.LocalDate;

public class AdicionarUtilizador {

    /* MENU ADMINISTRADOR */
    public void adicionarUtilizador(Sistema sistema, Consola consola, int opc) {
        String aux;
        int num;
        LocalDate date;

        // adicionar produtor
        if (opc == 1) {
            consola.cls();
            Produtor p = new Produtor();
            consola.escrever("- ADICIONAR PRODUTOR -\n\n");

            aux = consola.lerStringBuffer("Username do produtor: ");
            aux = consola.verificarUsername(sistema, aux);
            p.setUsername(aux);

            aux = consola.lerString("Password do produtor: ");
            p.setPassword(aux);

            aux = consola.lerString("Nome do produtor: ");
            p.setNome(aux);

            date = consola.lerData("Data de nascimento (formato dd/MM/yyyy): ");
            p.setDataNasc(date);

            aux = consola.lerString("Morada do produtor: ");
            p.setMorada(aux);

            num = consola.lerInteiro("Numero do CC do produtor: ");
            p.setCartaoC(num);

            // inserir o produtor no sistema
            sistema.getUtilizadores().inserir(p);

            consola.escrever("\nProdutor adicionado com sucesso!");
            
            int opcao;

            do {
                consola.escrever("\n\n[1] Voltar ao menu anterior");
                consola.escrever("\n[2] Adicionar outro produtor\n");
                opcao = consola.lerInteiro("-> ");
                switch (opcao) {
                    case 1:
                        break;

                    case 2:
                        adicionarUtilizador(sistema, consola, 1);
                        break;

                    default:
                        consola.escrever("\nOpção inválida!");
                }
            } while (opcao != 1 && opcao != 2);
            
        } // adicionar músico
        else if (opc == 2) {
            consola.cls();
            Musico m = new Musico();
            consola.escrever("- ADICIONAR MÚSICO -\n\n");

            aux = consola.lerStringBuffer("Username do músico: ");
            aux = consola.verificarUsername(sistema, aux);
            m.setUsername(aux);

            aux = consola.lerString("Password do músico: ");
            m.setPassword(aux);

            aux = consola.lerString("Nome do músico: ");
            m.setNome(aux);

            date = consola.lerData("Data de nascimento (formato dd/MM/yyyy): ");
            m.setDataNasc(date);

            aux = consola.lerString("Morada do músico: ");
            m.setMorada(aux);

            num = consola.lerInteiro("Número do CC do músico: ");
            m.setCartaoC(num);

            // inserir o musico no sistema
            sistema.getUtilizadores().inserir(m);
            consola.escrever("\nMúsico adicionado com sucesso!");
            int opcao;

            do {
                consola.escrever("\n\n[1] Voltar ao menu anterior");
                consola.escrever("\n[2] Adicionar outro músico\n");
                opcao = consola.lerInteiro("-> ");
                switch (opcao) {
                    case 1:
                        break;

                    case 2:
                        adicionarUtilizador(sistema, consola, 2);
                        break;

                    default:
                        consola.escrever("\nOpção inválida!");
                }
            } while (opcao != 1 && opcao != 2);
        
        }
        
    }
}
