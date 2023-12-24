package backend;

import java.io.Serializable;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapUtilizadores implements Serializable{
    
    // declaracao do Map de utilizadores
    private SortedMap<String, Utilizador> mapU;
    
    // construtor da classe MapPessoas
    public MapUtilizadores(){
        mapU = new TreeMap<>();
    }
    
    // metodo para inserir utilizadores no Map
    public void inserir(Utilizador user){
        mapU.put(user.getUsername(), user);
    }
    
    // metodo para remover utilizadores no Map
    public void remover(String username){
        mapU.remove(username);
    }

    public Utilizador get(String username){
        return mapU.get(username);
    }
    
    public boolean verificarAdmin() {
        for(Utilizador u : mapU.values()){
            if(u instanceof Administrador)
                return true;
        }
        return false;
    }
    
    public boolean verificarProdutor() {
        for(Utilizador u : mapU.values()){
            if(u instanceof Produtor)
                return true;
        }
        return false;
    }
    
    public boolean verificarSeExiste(String username){
        return mapU.containsKey(username);
    }
    
    public boolean verificarSeExisteProdutor(String username){
        for(Utilizador u: mapU.values()){
            if(u.getUsername().equals(username) && u instanceof Produtor)
                return true;
        }
        return false;
    }
    
    public boolean verificarSeExisteMusico(String username){
        for(Utilizador u: mapU.values()){
            if(u.getUsername().equals(username) && u instanceof Musico)
                return true;
        }
        return false;
    }
    
    public Produtor devolverProdutor(String username){
        if(verificarSeExiste(username)){
            Utilizador p = mapU.get(username);
            return (Produtor) p;
        }
        return null;
    }
    
    public Musico devolverMusico(String username){
        if(verificarSeExiste(username)){
            Utilizador m = mapU.get(username);
            return (Musico) m;
        }
        return null;
    }
    
    public int contarNumeroMusicos(){
        int cont = 0;
        for(Utilizador u : mapU.values()){
            if(u instanceof Musico)
                cont++;
        }
        return cont;
    }
    
    @Override
    public String toString() {
        return "" + mapU;
    }
}
