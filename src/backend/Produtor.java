
package backend;

import java.io.Serializable;
import java.time.LocalDate;

public class Produtor extends Utilizador implements Serializable{
    
    public Produtor(){}
    
    public Produtor(String username, String password, String nome, LocalDate dataNasc, String morada, int cartaoC) {
        super(username, password, nome, dataNasc, morada, cartaoC);
    }
    
    public String toString() {
        return super.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        //se nao forem objetos da mesma classe sao objetos diferentes
        if(!(obj instanceof Produtor)) return false; 

        //se forem o mesmo objeto, retorna true
        if(obj == this) return true;

        // aqui o cast é seguro por causa do teste feito acima
        Produtor prod = (Produtor) obj; 

        //aqui você compara a seu gosto, o ideal é comparar atributo por atributo
        return this.getUsername().equals(prod.getUsername());
    }
    
}
