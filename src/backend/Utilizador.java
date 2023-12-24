
package backend;

import java.io.Serializable;
import java.time.LocalDate;

public class Utilizador implements Serializable{
    
    private String username;
    private String password;
    private String nome;
    private LocalDate dataNasc;
    private String morada;
    private int cartaoC;

    public Utilizador() {
    }

    public Utilizador(String username, String password, String nome) {
        this.username = username;
        this.password = password;
        this.nome = nome;
    }

    public Utilizador(String username, String password, String nome, LocalDate dataNasc, String morada, int cartaoC) {
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.morada = morada;
        this.cartaoC = cartaoC;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getCartaoC() {
        return cartaoC;
    }

    public void setCartaoC(int cartaoC) {
        this.cartaoC = cartaoC;
    }

    @Override
    public boolean equals(Object obj) {
        //se nao forem objetos da mesma classe sao objetos diferentes
        if(!(obj instanceof Utilizador)) return false; 

        //se forem o mesmo objeto, retorna true
        if(obj == this) return true;

        // aqui o cast é seguro por causa do teste feito acima
        Utilizador user = (Utilizador) obj; 

        //aqui você compara a seu gosto, o ideal é comparar atributo por atributo
        return this.username.equals(user.getUsername());
    }   
    
    @Override
    public String toString() {
        return "\n    Username: " + username + "\n    Password: " + password + "\n    Nome: " + nome + "\n    DataNascimento: " + dataNasc + "\n    Morada: " + morada + "\n    Cartao de Cidadão: " + cartaoC + "\n\n\n\n";
    }

}
