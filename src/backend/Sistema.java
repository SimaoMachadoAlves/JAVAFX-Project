package backend;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Sistema implements Serializable{
    
    private MapUtilizadores utilizadores;
    private MapInstrumentos instrumentos;
    private MapAlbuns albuns;
    private MapMusicas musicas;
    private MapSessGrav sessoesGrav;
    private MapRequisInst requisicaoInstrumentos;
    private Utilizador utilizadorLigado;

    public Sistema() {
        utilizadores = new MapUtilizadores();
        instrumentos = new MapInstrumentos();
        albuns = new MapAlbuns();
        musicas = new MapMusicas();
        sessoesGrav = new MapSessGrav();
        requisicaoInstrumentos = new MapRequisInst();
    }
    
    //getters que devolvem os Maps
    public MapUtilizadores getUtilizadores() {
        return utilizadores;
    }

    public MapInstrumentos getInstrumentos() {
        return instrumentos;
    }

    public MapAlbuns getAlbuns() {
        return albuns;
    }

    public MapMusicas getMusicas() {
        return musicas;
    }

    public MapSessGrav getSessoesGrav() {
        return sessoesGrav;
    }

    public MapRequisInst getRequisicaoInstrumentos() {
        return requisicaoInstrumentos;
    }
    
    public Utilizador getUtilizadorLigado() {
        return utilizadorLigado;
    }

    //método para verificar se o login é válido
    public boolean autenticar(String username, String password, int cod, Utilizador ut){
        switch (cod){
            case 1: if(utilizadores.verificarSeExiste(username) && ut instanceof Administrador){
                        try{
                            ut = (Administrador)utilizadores.get(username);                     // casting para Administrador
                            if(ut.getPassword().equals(password)){
                                utilizadorLigado = ut;
                                return true;
                            }
                        }catch (Exception e) {};
                    }
                    //return false;
        
            case 2: if(utilizadores.verificarSeExiste(username) && ut instanceof Produtor){
                        try{
                            ut = (Produtor)utilizadores.get(username);                          // casting para Produtor
                            if(ut.getPassword().equals(password)){
                                utilizadorLigado = ut;
                                return true;
                            }
                        }catch (Exception e) {};
                    }
                    //return false;
            
            case 3: if(utilizadores.verificarSeExiste(username) && ut instanceof Musico){
                        try{
                            ut = (Musico)utilizadores.get(username);                            // casting para Musico
                            if(ut.getPassword().equals(password)){
                                utilizadorLigado = ut;
                                return true;
                            }
                        }catch (Exception e) {};
                    }
                    //return false;
        }
        return false;
    }
    
    //método para guardar dados em ficheiro
    public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(utilizadores);
        oos.writeObject(instrumentos);
        oos.writeObject(albuns);
        oos.writeObject(musicas);
        oos.writeObject(sessoesGrav);
        oos.writeObject(requisicaoInstrumentos);

        oos.close();
        fos.close();
    }
    
    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileInputStream file = new FileInputStream(nomeFicheiro);
        ObjectInputStream oin = new ObjectInputStream(file);
        
        utilizadores = (MapUtilizadores) oin.readObject();
        instrumentos = (MapInstrumentos) oin.readObject();
        albuns = (MapAlbuns) oin.readObject();
        musicas = (MapMusicas) oin.readObject();
        sessoesGrav = (MapSessGrav) oin.readObject();
        requisicaoInstrumentos = (MapRequisInst) oin.readObject();
        
        oin.close();
        file.close();
    }
}