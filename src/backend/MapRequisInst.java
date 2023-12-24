package backend;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapRequisInst implements Serializable{

    private SortedMap<Integer, RequisicaoInstrumentos> mapRqInst;

    public MapRequisInst() {
        mapRqInst = new TreeMap<>();
    }

    public void inserir(RequisicaoInstrumentos rqInst) {
        mapRqInst.put(rqInst.getCodigoRq(), rqInst);
    }

    public void remover(int codigoRq) {
        mapRqInst.remove(codigoRq);
    }

    public boolean verificarSeExisteReqInst(int cod) {
        return mapRqInst.containsKey(cod);
    }
    
    public boolean verificarSeNaoExistemReqInst(){
        return mapRqInst.isEmpty();
    }

    public int devolverTamanhoMapRqInst(){
        return mapRqInst.size();
    }
    
    public boolean validacaoParaRealizarSessaoGrav(int codSessao) {
        for (RequisicaoInstrumentos rI : mapRqInst.values()) {
            if (rI.getSessao().getCodigoSessao() == codSessao && rI.getEstadoRequisicao().equals("Atribuído")) {
                return true;
            }
        }
        return false;
    }
    
    public SortedMap<Integer, RequisicaoInstrumentos> escreverRequisicoes(int opcao) {
        switch (opcao) {
            case 1: 
                SortedMap<Integer, RequisicaoInstrumentos> listaPedidosPendentes = new TreeMap<>();
                for(RequisicaoInstrumentos rI : mapRqInst.values()){
                    if(rI.getEstadoRequisicao().equals("Pendente")){
                        listaPedidosPendentes.put(rI.getCodigoRq(), rI);
                    }
                }
                return listaPedidosPendentes;

            case 2:
                SortedMap<Integer, RequisicaoInstrumentos> listaPedidosAtribuidos = new TreeMap<>();
                
                for(RequisicaoInstrumentos rI : mapRqInst.values()){
                    if(rI.getEstadoRequisicao().equals("Atribuído")){
                        listaPedidosAtribuidos.put(rI.getCodigoRq(), rI);
                    }
                }
                return listaPedidosAtribuidos;

            case 3:
                SortedMap<Integer, RequisicaoInstrumentos> listaPedidosRecusados = new TreeMap<>();
                
                for(RequisicaoInstrumentos rI : mapRqInst.values()){
                    if(rI.getEstadoRequisicao().equals("Recusado")){
                        listaPedidosRecusados.put(rI.getCodigoRq(), rI);
                    }
                }
                return listaPedidosRecusados;

        }
        return null;
    }
    
    public ArrayList<String> printPedidos (int esc){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ArrayList<String> pendentes = new ArrayList(); 
        ArrayList<String> atribuidos = new ArrayList();
        ArrayList<String> concluidos = new ArrayList();
        switch (esc) {
            case 1:
                for (RequisicaoInstrumentos r : mapRqInst.values()){
                    if (r.getEstadoRequisicao().equals("Pendente"))
                        pendentes.add("Código pedido: " +r.getCodigoRq() +
                                        "\n Álbum: "+ r.getSessao().getAlb().getTituloAlbum() +
                                        "\n Músico: "+ r.getMusico().getNome() +
                                        "\n Código sessão: "+ r.getSessao().getCodigoSessao() +
                                        "\n Data pedido: "+dtf.format(r.getDataRequisicao()));
                }
                return pendentes;
            case 2:
                for (RequisicaoInstrumentos r : mapRqInst.values()){
                    if (r.getEstadoRequisicao().equals("Atribuído")){
                        pendentes.add("Código pedido: " +r.getCodigoRq() +
                                        "\n Álbum: "+ r.getSessao().getAlb().getTituloAlbum() +
                                        "\n Músico: "+ r.getMusico().getNome() +
                                        "\n Código sessão: "+ r.getSessao().getCodigoSessao());
                    }
                }
                return atribuidos;
            case 3:
                for (RequisicaoInstrumentos r : mapRqInst.values()){
                    if (r.getEstadoRequisicao().equals("Concluido")){
                        pendentes.add("Código pedido: " +r.getCodigoRq() +
                                        "\n Álbum: "+ r.getSessao().getAlb().getTituloAlbum() +
                                        "\n Músico: "+ r.getMusico().getNome() +
                                        "\n Código sessão: "+ r.getSessao().getCodigoSessao());
                    }
                }
                return concluidos;
            default:
                break;
        }
        return null;
    }
    
    public RequisicaoInstrumentos devolverReqIns(int codReqIns){
        if(verificarSeExisteReqInst(codReqIns)){
            RequisicaoInstrumentos rI = mapRqInst.get(codReqIns);
            return rI;
        }
        return null;
    }
    
    public int devolverMaiorCodigo(){
        int cod = 0;
        for(RequisicaoInstrumentos rI : mapRqInst.values()){
           if(rI.getCodigoRq() > cod)
               cod = rI.getCodigoRq();
        }
        return cod;
    }
    
    @Override
    public String toString() {
        return "" + mapRqInst;
    }
    
}
