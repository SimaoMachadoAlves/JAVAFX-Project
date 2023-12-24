/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.Sistema;

/**
 *
 * @author simao
 */
public class ConsultarTotalAlbunsProduzidos {

    public ConsultarTotalAlbunsProduzidos() {
    }
    
    public void totalAlbunsProduzidos(Sistema sistema, Consola consola){
        consola.cls();
        consola.escrever("- TOTAL ALBUNS PRODUZIDOS -\n\n");
        if(sistema.getAlbuns().verificarSeNaoExistemAlbum()){
            consola.escrever("\nERRO!\nNão existem álbuns no sistema!");
            consola.voltarMenuAnteriorBuffer();
            return;
        }
        else{
            int cont = sistema.getAlbuns().devolverNumAlbunsProduzidos();
            consola.escrever("Nº de albuns produzidos: "+cont);
            consola.voltarMenuAnteriorBuffer();
        }
    }
    
}
