
package frontend;

import backend.Sistema;

public class GuardarDados {

    public GuardarDados() {
    }
    
    public void guardarDadosFicheiro(Sistema sistema, Consola consola){
        consola.cls();
        consola.escrever("- GUARDAR DADOS NUM FICHEIRO -\n\n");
        
        String nomeFicheiro = consola.lerStringBuffer("Introduza o nome do ficheiro: ");
        try {
            sistema.guardarFicheiroObjetos(nomeFicheiro);
            consola.escrever("\nDados guardados no ficheiro com sucesso!");
        } catch (Exception ex) {
            consola.escrever("\nNão foi possivel criar o ficheiro: " + ex.getLocalizedMessage());
        }
        consola.voltarMenuAnterior();
    }
}
