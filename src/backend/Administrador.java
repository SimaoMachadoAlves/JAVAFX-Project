
package backend;

import java.io.Serializable;
import java.time.LocalDate;

public class Administrador extends Utilizador implements Serializable{
    
    public Administrador() {}

    public Administrador(String username, String password, String nome, LocalDate dataNasc, String morada, int cartaoC) {
        super(username, password, nome, dataNasc, morada, cartaoC);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
