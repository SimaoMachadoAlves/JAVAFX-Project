package frontend;

import backend.Sistema;
import backend.Utilizador;
import java.time.format.DateTimeFormatter;

public class ConsultarDadosPessoais {
    
    public void consultarDados(Sistema sistema, Consola consola, Utilizador u) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        consola.cls();
        consola.escrever("- CONSULTAR DADOS PESSOAIS -\n\n");
        consola.escrever("- DADOS PESSOAIS -\n");
        consola.escrever("\nUsername: " + u.getUsername());
        consola.escrever("\nNome: " + u.getNome());
        consola.escrever("\nData de nascimento: " + dtf.format(u.getDataNasc()));
        consola.escrever("\nMorada: " + u.getMorada());
        consola.escrever("\nNumero do CC: " + u.getCartaoC());
        consola.voltarMenuAnteriorBuffer();
    }
        
}

