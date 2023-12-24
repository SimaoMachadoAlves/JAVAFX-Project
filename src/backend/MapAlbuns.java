package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapAlbuns implements Serializable {

    private SortedMap<Integer, Album> mapAlb;

    public MapAlbuns() {
        mapAlb = new TreeMap<>();
    }

    public void inserir(Album alb) {
        mapAlb.put(alb.getCodigoAlbum(), alb);
    }

    public void remover(int cod) {
        mapAlb.remove(cod);
    }

    public void inserirDadosAlbum(int cod, LocalDate data, int numSessoes) {
        for (Album a : mapAlb.values()) {
            if (a.getCodigoAlbum() == cod) {
                a.setDataAlbum(data);
                a.setNumSessoesAlbum(numSessoes);
            }
        }
    }

    public int retornarTamanhoMapAlbuns(){
        return mapAlb.size();
    }
    
    public boolean verificarSeExisteAlbum(int cod) {
        return mapAlb.containsKey(cod);
    }

    public boolean verificarSeNaoExistemAlbum() {
        return mapAlb.isEmpty();
    }
    
    public Album devolverAlbum(int cod) {
        if (verificarSeExisteAlbum(cod)) {
            Album a = mapAlb.get(cod);
            return a;
        }
        return null;
    }

    public int devolverNumSessoesAlbum(int cod) {
        if (verificarSeExisteAlbum(cod)) {
            Album a = mapAlb.get(cod);
            return a.getNumSessoesAlbum();
        }
        return 0;
    }

    public String devolverUsernameProdutorAlbum(int cod) {
        if (verificarSeExisteAlbum(cod)) {
            Album a = mapAlb.get(cod);
            return a.getProdutor().getUsername();
        }
        return null;
    }

    public String devolverUsernameMusicoAlbum(int cod) { //obter os musicos que participam nas musicas do album
        if (verificarSeExisteAlbum(cod)) {
            Album a = mapAlb.get(cod);
            return a.getProdutor().getUsername();
        }
        return null;
    }
    
    public SortedMap<Integer, Album> devolverAlbunsDeUmProdutorOuMusico(String username, int numParaProduzidosOuEmProducao, int tipoUser){
        switch (tipoUser){
            case 1:
                if(numParaProduzidosOuEmProducao == 1){
                    SortedMap<Integer, Album> albunsProdutor = new TreeMap();
                    for(Album a : mapAlb.values()){
                        if(a.getProdutor().getUsername().equals(username) && a.obterEstado() == 100)
                            albunsProdutor.put(a.getCodigoAlbum(), a);
                    }
                    return albunsProdutor;
                } 
                    
                else{
                    SortedMap<Integer, Album> albunsProdutor = new TreeMap();
                    for(Album a : mapAlb.values()){
                        if(a.getProdutor().getUsername().equals(username) && a.obterEstado() >= 0)
                            albunsProdutor.put(a.getCodigoAlbum(), a);
                    }
                    return albunsProdutor;
                }
                
            case 2:
                if(numParaProduzidosOuEmProducao == 1){
                    SortedMap<Integer, Album> albunsMusico = new TreeMap();
                    for(Album a : mapAlb.values()){
                        if(a.obterEstado() == 100){
                            SortedMap<Integer, Musica> musicasAlbum = new TreeMap();
                            musicasAlbum = a.getMapSongs();
                            for(Musica m : musicasAlbum.values()){
                                SortedMap<String, Musico> musicosMusica = new TreeMap();
                                musicosMusica = m.getMapMusicos();
                                for(Musico mu : musicosMusica.values()){
                                    if(mu.getUsername().equals(username))
                                        albunsMusico.put(a.getCodigoAlbum(), a);
                                }
                            }
                        }
                    } 
                    return albunsMusico;
                }
                else{
                    SortedMap<Integer, Album> albunsMusico = new TreeMap();
                    for(Album a : mapAlb.values()){
                        if(a.obterEstado() >= 0){
                            SortedMap<Integer, Musica> musicasAlbum = new TreeMap();
                            musicasAlbum = a.getMapSongs();
                            for(Musica m : musicasAlbum.values()){
                                SortedMap<String, Musico> musicosMusica = new TreeMap();
                                musicosMusica = m.getMapMusicos();
                                for(Musico mu : musicosMusica.values()){
                                    if(mu.getUsername().equals(username))
                                        albunsMusico.put(a.getCodigoAlbum(), a);
                                }
                            }
                        }
                    }
                    return albunsMusico;
                }
        }
        return null;
    }
    
    public boolean verificarSeProdutorNoAlbum(String username, int codAlbum){
        for(Album a : mapAlb.values()){
            if(a.getProdutor().getUsername().equals(username) && a.getCodigoAlbum() == codAlbum)
                return true;
        }
        return false;
    }
    
    public boolean verificarSeMusicoNoAlbum(String username, int codAlbum){
        for(Album a : mapAlb.values()){
            if(a.getCodigoAlbum() == codAlbum){
                SortedMap<Integer, Musica> musicasAlbum = new TreeMap();
                for(Musica m : musicasAlbum.values()){
                    SortedMap<String, Musico> musicosMusica = new TreeMap();
                    musicosMusica = m.getMapMusicos();
                    for(Musico mu : musicosMusica.values()){
                        if(mu.getUsername().equals(username))
                            return true;
                    }
                }
            }
        }
        return false;
    }
    
    public ArrayList<String> devolverRegistoAlbum(){
        ArrayList<String> regAlbum = new ArrayList();
        for(Album a : mapAlb.values()){
                regAlbum.add("\n\nCódigo do álbum: " + a.getCodigoAlbum() + 
                        "\nTítulo do álbum: " + a.getTituloAlbum() + 
                        "\nProdutor do álbum: " + a.getProdutor().getNome() + 
                        "\nTipo do Álbum: " + a.getTipoAlbum());
        }
        return regAlbum;
    }
    
    public ArrayList<String> printAlbunsProdutor(String username, int esc){
        switch (esc){
            case 1:
                ArrayList<String> albunsProdutor = new ArrayList();
                SortedMap<Integer, Musica> musicas = new TreeMap();
                for(Album a : mapAlb.values()){
                    if(a.getProdutor().getUsername().equals(username)){
                        musicas = a.getMapSongs();
                    }
                }
                for(Album a : mapAlb.values()){
                    if(a.getProdutor().getUsername().equals(username) && a.obterEstado() == 100){
                        albunsProdutor.add("\n\nCódigo do álbum: " + a.getCodigoAlbum() + 
                                "\nTítulo do álbum: " + a.getTituloAlbum() + 
                                "\nProdutor do álbum: " + a.getProdutor().getNome() + 
                                "\nTipo do álbum: " + a.getTipoAlbum() +
                                "\nNúmero de sessões: " + a.getNumSessoesAlbum() +
                                "\nNúmero de sessões concluídas: " + a.getNumSessoesConcluidas() +
                                "\nMúsicas: "+musicas);
                    }
                }
                return albunsProdutor;
                
            case 2:
                albunsProdutor = new ArrayList();
                musicas = new TreeMap();
                for(Album a : mapAlb.values()){
                    if(a.getProdutor().getUsername().equals(username)){
                        musicas = a.getMapSongs();
                    }
                }
                for(Album a : mapAlb.values()){
                    if(a.getProdutor().getUsername().equals(username) && a.obterEstado() >= 0){
                        albunsProdutor.add("\n\nCódigo do álbum: " + a.getCodigoAlbum() + 
                                "\nTítulo do álbum: " + a.getTituloAlbum() + 
                                "\nProdutor do álbum: " + a.getProdutor().getNome() + 
                                "\nTipo do álbum: " + a.getTipoAlbum() +
                                "\nNúmero de sessões: " + a.getNumSessoesAlbum() +
                                "\nNúmero de sessões concluídas: " + a.getNumSessoesConcluidas() +
                                "\nMúsicas: "+musicas);
                    }
                }
                return albunsProdutor;
        }
        return null;
    }
    
    public ArrayList<String> printAlbunsMusico(String username, int esc){
        switch (esc){
            case 1:
                ArrayList<String> albunsMusico = new ArrayList();
                SortedMap<Integer, Musica> musicas= new TreeMap();
                for(Album a : mapAlb.values()){
                    musicas = a.getMapSongs();
                    for(Musica m : musicas.values()){
                        SortedMap<String, Musico> musicosMusica = new TreeMap();
                        musicosMusica = m.getMapMusicos();
                        for(Musico mu : musicosMusica.values()){
                            if(mu.getUsername().equals(username))
                                musicas = a.getMapSongs();
                        }
                    }
                }
                for(Album a : mapAlb.values()){
                    if(a.getProdutor().getUsername().equals(username) && a.obterEstado() == 100){
                        albunsMusico.add("\n\nCódigo do álbum: " + a.getCodigoAlbum() + 
                                "\nTítulo do álbum: " + a.getTituloAlbum() + 
                                "\nTipo do álbum: " + a.getTipoAlbum() +
                                "\nNúmero de sessões: " + a.getNumSessoesAlbum() +
                                "\nNúmero de sessões concluídas: " + a.getNumSessoesConcluidas() +
                                "\nMúsicas: "+musicas);
                    }
                }
                return albunsMusico;
            
            case 2:
                albunsMusico = new ArrayList();
                musicas= new TreeMap();
                for(Album a : mapAlb.values()){
                    musicas = a.getMapSongs();
                    for(Musica m : musicas.values()){
                        SortedMap<String, Musico> musicosMusica = new TreeMap();
                        musicosMusica = m.getMapMusicos();
                        for(Musico mu : musicosMusica.values()){
                            if(mu.getUsername().equals(username))
                                musicas = a.getMapSongs();
                        }
                    }
                }
                for(Album a : mapAlb.values()){
                    if(a.getProdutor().getUsername().equals(username) && a.obterEstado() >= 0){
                        albunsMusico.add("\n\nCódigo do álbum: " + a.getCodigoAlbum() + 
                                "\nTítulo do álbum: " + a.getTituloAlbum() + 
                                "\nTipo do álbum: " + a.getTipoAlbum() +
                                "\nNúmero de sessões: " + a.getNumSessoesAlbum() +
                                "\nNúmero de sessões concluídas: " + a.getNumSessoesConcluidas() +
                                "\nMúsicas: "+musicas);
                    }
                }
                return albunsMusico;
        }
        return null;
    }
    
    public int devolverNumAlbunsEmEdicao(){
        int cont = 0;
        for(Album a : mapAlb.values()){
            if(a.getNumSessoesConcluidas() < a.getNumSessoesAlbum())
                cont++;
        }
        return cont;
    }
    
    public int devolverNumAlbunsProduzidos(){
        int cont = 0;
        for(Album a : mapAlb.values()){
            if(a.getNumSessoesConcluidas() == a.getNumSessoesAlbum() && a.getNumSessoesConcluidas() > 0)
                cont++;
        }
        return cont;
    }
    
    @Override
    public String toString() {
        return "" + mapAlb;
    }

}