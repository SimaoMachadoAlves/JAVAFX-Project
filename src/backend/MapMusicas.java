package backend;

import java.io.Serializable;
import java.util.SortedMap;
import java.util.TreeMap;


public class MapMusicas implements Serializable{
    private SortedMap<Integer, Musica> mapSongs;                            
    
    public MapMusicas(){                                        
        mapSongs = new TreeMap<>();
    }
    
    public void inserir(Musica song){                            
        mapSongs.put(song.getCodigo(), song);
    }
    
    public void remover(int codMusica){
        mapSongs.remove(codMusica);
    }
    
    public Musica devolverMusica(int cod){
        for(Musica musica : mapSongs.values()){
            if(musica.getCodigo() == cod){
                return musica;
            }
        }
        return null;
    }
    
    public boolean verificarSeExisteMusica(int cod){
        return mapSongs.containsKey(cod);
    }
    
    @Override
     public String toString() {
        return "" + mapSongs;
    }
    
}
