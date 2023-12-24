package frontend;

import backend.RequisicaoInstrumentos;
import backend.Sistema;

public class DefinirLimiteRequisicoes {
    public void defLimReq(Sistema sistema, Consola consola){
        consola.cls();
        RequisicaoInstrumentos rqI = new RequisicaoInstrumentos();
        consola.escrever("- DEFINIR LIMITE DE REQUISICOES -\n\n");
        
        int num = consola.lerInteiro("Introduza o limite máximo de requisições: ");
        rqI.setNumMaxRqIns(num);
        consola.voltarMenuAnteriorBuffer();
    }
}
