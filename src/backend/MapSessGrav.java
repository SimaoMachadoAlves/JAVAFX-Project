package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapSessGrav implements Serializable{
    
    private SortedMap<Integer, SessaoGravacao> mapSessGrav;

    public MapSessGrav(){
        mapSessGrav = new TreeMap<>();
    }

    public void inserir(SessaoGravacao sessGrav){
        mapSessGrav.put(sessGrav.getCodigoSessao(), sessGrav);
    }
    
    public void inserirAuxiliar(int cod, SessaoGravacao sessGrav){
        mapSessGrav.put(cod, sessGrav);
    }
    
    public void remover(int codSessao){
        mapSessGrav.remove(codSessao);
    }
    
    public void removerTodasSessoesAlbum(int codAlbum){
        for(SessaoGravacao s : mapSessGrav.values()){
            if(s.getAlb().getCodigoAlbum() == codAlbum)
                remover(s.getCodigoSessao());
        }
    }
    
    public boolean verificarSeNaoExistemSessaoGrav(){
        return mapSessGrav.isEmpty();
    }
    
    public boolean verificarSeExisteSessaoGrav(int cod){
        return mapSessGrav.containsKey(cod);
    }
    
    public int devolverTamanhoDoMapSG() {
       return mapSessGrav.size();
    }
    
    public SessaoGravacao devolverSessaoGravacaoPorEstado(int i, String username){
        for (SessaoGravacao s : mapSessGrav.values()){
            for(Utilizador m : s.getMapMusicos().values()){
                if (s.getEstadoSessao().equals("Concluído") && m.getUsername().equals(username))
                    return s;
                if ( (s.getEstadoSessao().equals("Não iniciado") || (s.getEstadoSessao().equals("Iniciado") ) ) 
                        && m.getUsername().equals(username))
                    return s;
            }
        }
        return null;
    }
    
    public SessaoGravacao getProximaSessaoARealizarAlbum(int codAlbum){
        for (SessaoGravacao s : mapSessGrav.values()){
            if(s.getAlb().getCodigoAlbum() == codAlbum && !s.getEstadoSessao().equals("Concluído"))
                return s;
        }
        return null;
    }
    
    public SessaoGravacao getProximaSessaoAConcluirAlbum(int codAlbum){
        for (SessaoGravacao s : mapSessGrav.values()){
            if(s.getAlb().getCodigoAlbum() == codAlbum && s.getEstadoSessao().equals("Iniciado"))
                return s;
        }
        return null;
    }
    
    public SessaoGravacao devolverSessaoGravacao(int cod){
        if(verificarSeExisteSessaoGrav(cod)){
            SessaoGravacao s = mapSessGrav.get(cod);
            return s;
        }
        return null;
    }
    
    public LocalDate devolverDataSessaoGravacao(int cod, int aux){
        SessaoGravacao s = mapSessGrav.get(cod);
        if(s == null) return null;
        
        if(aux == 1){
            return s.getDataFinalSessao();
        }
        else{
            return s.getDataInicialSessao();
        }
    }
    
    public String devolverEstadoSessao(int codSessao){
        if(verificarSeExisteSessaoGrav(codSessao)){
            SessaoGravacao s = mapSessGrav.get(codSessao);
            return s.getEstadoSessao();
        }
        return null;
    }
    
    public SortedMap<Integer, SessaoGravacao> devolverSessaoDataEspecifica(LocalDate date, String username, int tipoUser){
        switch (tipoUser){
            case 1:
                SortedMap<Integer, SessaoGravacao> sessoesData1 = new TreeMap();
                for (SessaoGravacao s : mapSessGrav.values()){
                    if(s.getDataInicialSessao().isEqual(date) && s.getAlb().getProdutor().getUsername().equals(username)
                            && !s.getEstadoSessao().equals("Concluído"))
                        sessoesData1.put(s.getCodigoSessao(), s);
                    
                }
                return sessoesData1;
            
            case 2:
                SortedMap<Integer, SessaoGravacao> sessoesData2 = new TreeMap();
                for(SessaoGravacao s : mapSessGrav.values()){
                    for(Utilizador m : s.getMapMusicos().values()){
                        if(m.getUsername().equals(username) && s.getDataInicialSessao().isEqual(date)
                                && !s.getEstadoSessao().equals("Concluído"))
                            sessoesData2.put(s.getCodigoSessao(), s);
                        }
                }
                return sessoesData2;
        }
        return null;
    }
    
    public boolean verificarSeMusicoNaSessao(String username){
        for(SessaoGravacao s : mapSessGrav.values()){
            for(Utilizador m : s.getMapMusicos().values()){
                if(m.getUsername().equals(username))
                    return true;
            }
        }
        return false;
    }
    
    public int devolverNumSessoesConcluidas(){
        int count = 0;
        for(SessaoGravacao s : mapSessGrav.values()){
            if(s.getEstadoSessao().equals("Concluído"))
                count++;
        }
        return count;
    }
    
    public ArrayList<String> devolverEstadosSessoesDeUmAlbum(int codAlbum){
        ArrayList<String> estados = new ArrayList();
        int count = 1;
        for(SessaoGravacao s : mapSessGrav.values()){
            if(s.getAlb().getCodigoAlbum() == codAlbum){
                estados.add("Sessão "+count+": " + s.getEstadoSessao());
                count ++;
            }
        }
        return estados;
    }
    
    @Override
    public String toString() {
        return "\n   Map Sessão de Gravação   " + "\nMap Sessão de Gravação: " + mapSessGrav;
    }

}