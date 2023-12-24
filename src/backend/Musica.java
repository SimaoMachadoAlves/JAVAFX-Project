package backend;

import java.io.Serializable;
import java.util.SortedMap;
import java.util.TreeMap;

public class Musica implements Serializable{
    private int codigo;
    private String tituloMusica;
    private String duracao;
    private SortedMap<String, Musico> mapMusicos;

    public Musica() {
        mapMusicos = new TreeMap<>();
    }

    public Musica(int codigo, String tituloMusica, String duracao) {
        this.codigo = codigo;
        this.tituloMusica = tituloMusica;
        this.duracao = duracao;
        mapMusicos = new TreeMap<>();
    }

    //getters e setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTituloMusica() {
        return tituloMusica;
    }

    public void setTituloMusica(String tituloMusica) {
        this.tituloMusica = tituloMusica;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public SortedMap<String, Musico> getMapMusicos() {
        return mapMusicos;
    }

    public void setMapMusicos(SortedMap<String, Musico> mapMusicos) {
        this.mapMusicos = mapMusicos;
    }

    public void addMusico(Musico musico){
        mapMusicos.put(musico.getUsername(), musico);
    }

    public boolean naoDeixarMesmoMusico(String usernameMusico){
        for(Musico m : mapMusicos.values()){
            if(m.getUsername().equals(usernameMusico))
                return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "\nCodigo: " + codigo + "\nTitulo da Musica: " + tituloMusica + "\nDuracao: " + duracao + "\n\nMusicos: " + mapMusicos +"\n\n"; 
    }
}