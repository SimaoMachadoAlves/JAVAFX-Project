
package frontend;

import backend.Sistema;

public class CarregarDados {

    public CarregarDados() {
    }
    
    public void carregarDadosFicheiro(Sistema sistema, Consola consola){
        consola.cls();
        consola.escrever("- CARREGAR DADOS DE UM FICHEIRO -\n\n");
        
        String nomeFicheiro = consola.lerStringBuffer("Introduza o nome do ficheiro: ");
        try {
            sistema.carregarFicheiroObjetos(nomeFicheiro);
            consola.escrever("\nDados do ficheiro carregados com sucesso!");
        } catch (Exception ex) {
            consola.escrever("\nNão foi possivel carregar os dados do ficheiro: "+ ex.getMessage());
        }
        consola.voltarMenuAnterior();
    }
}
