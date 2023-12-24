package backend;

import java.io.Serializable;
import java.util.SortedMap;
import java.util.TreeMap;


public class MapInstrumentos implements Serializable{
     private SortedMap<Integer, Instrumento> mapI;                            
    
    public MapInstrumentos(){                                        
        mapI = new TreeMap<>();
    }
    
    public void inserir(Instrumento inst){                            
        mapI.put(inst.getCodInstrumento(), inst);
    }
    
    public void remover(int codigo){                            
        mapI.remove(codigo);
    }

    public boolean verificarSeExisteInst(int codigo){
        return mapI.containsKey(codigo);
    }
    
    public boolean verificarSeNaoExisteInst(){
        return mapI.isEmpty();
    }
    
    public int numeroInstrumentos(){
        return mapI.size();
    }
    
    public Instrumento devolverInstrumento(int cod){
        for(Instrumento i : mapI.values()){
            if(i.getCodInstrumento() == cod){
                return i;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "" + mapI;
    }
    
}
