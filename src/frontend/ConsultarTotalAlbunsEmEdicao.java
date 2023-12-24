
package frontend;

import backend.Sistema;

public class ConsultarTotalAlbunsEmEdicao {

    public ConsultarTotalAlbunsEmEdicao() {
    }
    
    public void totalAlbunsEmEdicao(Sistema sistema, Consola consola){
        consola.cls();
        consola.escrever("- TOTAL ALBUNS EM EDIÇÃO -\n\n");
        if(sistema.getAlbuns().verificarSeNaoExistemAlbum()){
            consola.escrever("\nERRO!\nNão existem álbuns no sistema!");
            consola.voltarMenuAnteriorBuffer();
            return;
        }
        else{
            int cont = sistema.getAlbuns().devolverNumAlbunsEmEdicao();
            consola.escrever("Nº de albuns em edição: "+cont);
            consola.voltarMenuAnteriorBuffer();
        }
    }
    
}
