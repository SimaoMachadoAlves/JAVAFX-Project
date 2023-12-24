package frontend;

import backend.Sistema;
import backend.Utilizador;
import java.time.LocalDate;


public class EditarDadosPessoais {
    
    public void editarDados(Sistema sistema, Consola consola, Utilizador u){
        LocalDate date;
        String str;
        int num;
        
        consola.cls();
        consola.escrever("- EDITAR DADOS PESSOAIS -\n\n");
        
        consola.escrever("Pretende mudar o seu username ("+u.getUsername()+")?\n[1] Sim\n[2] Não\n");
        int opc = consola.lerInteiro("> ");
        while(opc != 1 && opc != 2){
            consola.escrever("\nOpção inválida!");
            opc = consola.lerInteiro("\nIntroduza [1] Sim ou [2] Não\n> ");
        }
        if(opc == 1){
            str = consola.lerStringBuffer("\nNovo username: ");
            str = consola.verificarUsername(sistema, str);
            u.setUsername(str);
        }
        
        str = consola.lerString("Nova password: ");
        u.setPassword(str);
        
        date = consola.lerData("Data de nascimento (formato dd/MM/yyyy): ");
        u.setDataNasc(date);
        
        str = consola.lerString("Nova morada: ");
        u.setMorada(str);
        
        num = consola.lerInteiro("Número do CC: ");
        u.setCartaoC(num);
        
        int opcao;

        do {
            consola.escrever("\n\n[1] Voltar ao menu anterior");
            consola.escrever("\n[2] Editar dados pessoais\n");
            opcao = consola.lerInteiro("-> ");
            switch (opcao) {
                case 1:
                    break;

                case 2:
                    editarDados(sistema, consola, u);
                    break;

                default:
                    consola.escrever("\nOpção inválida!");
            }
        } while (opcao != 1 && opcao != 2);
    }
}
