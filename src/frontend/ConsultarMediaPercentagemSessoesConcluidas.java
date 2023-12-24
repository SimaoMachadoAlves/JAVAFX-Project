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
public class ConsultarMediaPercentagemSessoesConcluidas {

    public ConsultarMediaPercentagemSessoesConcluidas() {
    }
    
    public void mediaPercentagemSessoesConcluidas(Sistema sistema, Consola consola){
        consola.cls();
        consola.escrever("- MÉDIA DA PERCENTAGEM DE SESSÕES DE GRAVAÇÃO CONCLUÍDAS -\n\n");
        if(sistema.getAlbuns().verificarSeNaoExistemAlbum()){
            consola.escrever("\nERRO!\nNão existem álbuns no sistema!");
            consola.voltarMenuAnteriorBuffer();
            return;
        }
        else{
            int numSessoes = sistema.getSessoesGrav().devolverTamanhoDoMapSG();
            int numSessoesConcluidas = sistema.getSessoesGrav().devolverNumSessoesConcluidas();
            double media = (numSessoesConcluidas*100) / numSessoes;
            consola.escrever("% média: "+media+"%");
            consola.voltarMenuAnteriorBuffer();
        }
    }
}