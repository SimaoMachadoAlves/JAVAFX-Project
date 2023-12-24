package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.SortedMap;
import java.util.TreeMap;

public class RequisicaoInstrumentos implements Serializable {

    private static int numMaxRqIns;
    private int codigoRq;
    private Musico musico;
    private SessaoGravacao sessao;
    private SortedMap<Integer, Instrumento> mapInst;
    private LocalDate dataRequisicao;
    private String estadoRequisicao; // (pendente, atribuido, recusado)

    public RequisicaoInstrumentos() {
        mapInst = new TreeMap<>();
    }

    public RequisicaoInstrumentos(int codigoRq, Musico musico, SessaoGravacao sessao, LocalDate dataRequisicao, String estadoRequisicao) {
        this.codigoRq = codigoRq;
        this.musico = musico;
        this.sessao = sessao;
        this.dataRequisicao = dataRequisicao;
        this.estadoRequisicao = estadoRequisicao;
        mapInst = new TreeMap<>();
    }

    public static int getNumMaxRqIns() {
        return numMaxRqIns;
    }

    public static void setNumMaxRqIns(int numMaxRqIns) {
        RequisicaoInstrumentos.numMaxRqIns = numMaxRqIns;
    }

    public int getCodigoRq() {
        return codigoRq;
    }

    public void setCodigoRq(int codigoRq) {
        this.codigoRq = codigoRq;
    }

    public Musico getMusico() {
        return musico;
    }

    public void setMusico(Musico musico) {
        this.musico = musico;
    }

    public SessaoGravacao getSessao() {
        return sessao;
    }

    public void setSessao(SessaoGravacao sessao) {
        this.sessao = sessao;
    }

    public SortedMap<Integer, Instrumento> getMapInst() {
        return mapInst;
    }

    public void setMapInst(SortedMap<Integer, Instrumento> mapInst) {
        this.mapInst = mapInst;
    }

    public LocalDate getDataRequisicao() {
        return dataRequisicao;
    }

    public void setDataRequisicao(LocalDate dataRequisicao) {
        this.dataRequisicao = dataRequisicao;
    }

    public String getEstadoRequisicao() {
        return estadoRequisicao;
    }

    public void setEstadoRequisicao(String estadoRequisicao) {
        this.estadoRequisicao = estadoRequisicao;
    }

    public void addInstrumento(Instrumento inst){
        mapInst.put(inst.getCodInstrumento(), inst);
    }
    
    @Override
    public String toString() {
        return "\n   RequisicaoInstrumentos   " + "\nCodigo de Requisição: " + codigoRq + "\nMusico: " + musico
                + "\nSessao: " + sessao + "\nInstrumento: " + mapInst
                + "\nData de Requisicao: " + dataRequisicao + "\nEstadoRequisicao: " + estadoRequisicao;
    }

}
