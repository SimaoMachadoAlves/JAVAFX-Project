
package backend;

import java.io.Serializable;

public class Instrumento implements Serializable{
    /* private int tipoDeInstrumento -> seleceionar o tipo de instrumento, seria um extra (Instrumentos de cordas, percussao, sopro, outros)*/
    private String nomeInstrumento;
    private int codInstrumento;

    public Instrumento(){}
    public Instrumento (String nomeInstrumento, int codInstrumento){
        this.nomeInstrumento = nomeInstrumento;
        this.codInstrumento = codInstrumento;
    }

    public String getNomeInstrumento() {
        return nomeInstrumento;
    }

    public void setNomeInstrumento(String nomeInstrumento) {
        this.nomeInstrumento = nomeInstrumento;
    }

    public int getCodInstrumento() {
        return codInstrumento;
    }

    public void setCodInstrumento(int codInstrumento) {
        this.codInstrumento = codInstrumento;
    }

    @Override
    public String toString (){
        return "    INSTRUMENTO   " + "\nNome do Instrumento: "+nomeInstrumento + "\nCodigo: "+codInstrumento + "\n\n";
    }

}
