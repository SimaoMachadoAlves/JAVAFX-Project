package backend;

import java.io.Serializable;
import java.time.LocalDate;

public class Musico extends Utilizador implements Serializable {

    private Instrumento[] inst;
    
    public Musico(){}

    public Musico(Instrumento[] inst, String username, String password, String nome, LocalDate dataNasc, String morada, int cartaoC) {
        super(username, password, nome, dataNasc, morada, cartaoC);
        this.inst = inst;
    }

    public Instrumento[] getInst() {
        return inst;
    }

    public void setInst(Instrumento[] inst) {
        this.inst = inst;
    }

    @Override
    public String toString() {
        return "\n   Musico   " + "\nInstrumento: " + inst;
    }
    
}