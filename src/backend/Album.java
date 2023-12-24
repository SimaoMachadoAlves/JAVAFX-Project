package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.SortedMap;
import java.util.TreeMap;

public class Album implements Serializable{
    private int codigoAlbum;
    private String tituloAlbum;
    private String tipoAlbum;                   
    private SortedMap<Integer, Musica> mapSongs;            // estes 4 é o admin que define
    private LocalDate dataAlbum;
    private int numSessoesAlbum;
    private int numSessoesConcluidas;
    private Produtor produtor;
    
    public Album(){
        mapSongs = new TreeMap<>();
    }

    public Album(int codigoAlbum, String tituloAlbum, String tipoAlbum, LocalDate dataAlbum, int numSessoesAlbum, int numSessoesConcluidas, Produtor produtor) {
        this.codigoAlbum = codigoAlbum;
        this.tituloAlbum = tituloAlbum;
        this.tipoAlbum = tipoAlbum;
        mapSongs = new TreeMap<>();
        this.dataAlbum = dataAlbum;
        this.numSessoesAlbum = numSessoesAlbum;
        this.numSessoesConcluidas = numSessoesConcluidas;
        this.produtor = produtor;
    }

    public int getCodigoAlbum() {
        return codigoAlbum;
    }

    public void setCodigoAlbum(int codigoAlbum) {
        this.codigoAlbum = codigoAlbum;
    }

    public String getTituloAlbum() {
        return tituloAlbum;
    }

    public void setTituloAlbum(String tituloAlbum) {
        this.tituloAlbum = tituloAlbum;
    }

    public LocalDate getDataAlbum() {
        return dataAlbum;
    }

    public void setDataAlbum(LocalDate dataAlbum) {
        this.dataAlbum = dataAlbum;
    }

    public String getTipoAlbum() {
        return tipoAlbum;
    }

    public void setTipoAlbum(String tipoAlbum) {
        this.tipoAlbum = tipoAlbum;
    }

    public SortedMap<Integer, Musica> getMapSongs() {
        return mapSongs;
    }
    
    public void setMapSongs(SortedMap<Integer, Musica> mapSongs) {
        this.mapSongs = mapSongs;
    }
    
    public int getNumSessoesAlbum() {
        return numSessoesAlbum;
    }

    public void setNumSessoesAlbum(int numSessoesAlbum) {
        this.numSessoesAlbum = numSessoesAlbum;
    }

    public int getNumSessoesConcluidas() {
        return numSessoesConcluidas;
    }

    public void setNumSessoesConcluidas(int numSessoesConcluidas) {
        this.numSessoesConcluidas = numSessoesConcluidas;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }
    
    // estado = (percentagem de sessões de gravação concluídas)
    public double obterEstado(){
        return (numSessoesConcluidas*100)/numSessoesAlbum;       
    }   

    public void addMusica(Musica song){                            
        mapSongs.put(song.getCodigo(), song);
    }
    
    public Musica devolverMusica(){
        for(Musica m : mapSongs.values()){
            return m;
        }
        return null;
    }
    
    public Musica devolverMusicaCodigo(int cod){
        for(Musica musica : mapSongs.values()){
            if(musica.getCodigo() == cod){
                return musica;
            }
        }
        return null;
    }
    
    public boolean verificarSeExisteMusicaNoAlbum(int codMusica){
        for(Musica m : mapSongs.values()){
            if(m.getCodigo() == codMusica){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
            return "    ÁLBUM   " + "\n\nCódigo do Álbum: " + codigoAlbum + "\nTítulo do Álbum: "
                    + tituloAlbum + "\nTipo de Álbum: " + tipoAlbum + "\n\nMúsicas: "+ mapSongs  + 
                    "\n\nData de Edição do Álbum: " + dataAlbum + "\nNúmero Sessões do Álbum: " + numSessoesAlbum + 
                    "\nNúmeroSessõesConcluídas: " + numSessoesConcluidas + "\n\nProdutor: " +produtor;
    }
    
}