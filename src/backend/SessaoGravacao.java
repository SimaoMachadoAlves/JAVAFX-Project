
package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.SortedMap;
import java.util.TreeMap;

public class SessaoGravacao implements Serializable{
    
    private int codigoSessao;
    private String nomeSessao;                      //(por exemplo: sessão1, sessão2, ...) - é uma String
    private String estadoSessao;                    //(Concluído, Não iniciado, Iniciado)
    private LocalDate dataInicialSessao;
    private LocalDate dataFinalSessao;
    private Album alb;
    private Musica musica;
    private SortedMap<String, Musico> mapMusicos;
    
    // construtor da classe SessaoGravacao
    public SessaoGravacao(){
        mapMusicos = new TreeMap<>();
    }

    // construtor da classe SessaoGravacao
    public SessaoGravacao(int codigoSessao, String nomeSessao, String estadoSessao, LocalDate dataInicialSessao, LocalDate dataFinalSessao, Album alb, Musica musica) {
        this.codigoSessao = codigoSessao;
        this.nomeSessao = nomeSessao;
        this.estadoSessao = estadoSessao;
        this.dataInicialSessao = dataInicialSessao;
        this.dataFinalSessao = dataFinalSessao;
        this.alb = alb;
        this.musica = musica;
        mapMusicos = new TreeMap<>();
    }

    public int getCodigoSessao() {
        return codigoSessao;
    }

    public void setCodigoSessao(int codigoSessao) {
        this.codigoSessao = codigoSessao;
    }

    public String getNomeSessao() {
        return nomeSessao;
    }

    public void setNomeSessao(String nomeSessao) {
        this.nomeSessao = nomeSessao;
    }

    public String getEstadoSessao() {
        return estadoSessao;
    }

    public void setEstadoSessao(String estadoSessao) {
        this.estadoSessao = estadoSessao;
    }

    public LocalDate getDataInicialSessao() {
        return dataInicialSessao;
    }

    public void setDataInicialSessao(LocalDate dataInicialSessao) {
        this.dataInicialSessao = dataInicialSessao;
    }

    public LocalDate getDataFinalSessao() {
        return dataFinalSessao;
    }

    public void setDataFinalSessao(LocalDate dataFinalSessao) {
        this.dataFinalSessao = dataFinalSessao;
    }

    public Album getAlb() {
        return alb;
    }

    public void setAlb(Album alb) {
        this.alb = alb;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }
    
    public SortedMap<String, Musico> getMapMusicos() {
        return mapMusicos;
    }

    public void setMapMusicos(SortedMap<String, Musico> mapMusicos) {
        this.mapMusicos = mapMusicos;
    }
    
    @Override
    public String toString() {
        return "   SessaoGravacao   " + "\nCodigo da Sessao: " + codigoSessao + "\nNome da Sessao: "
                + nomeSessao + "\nEstado da Sessao: " + estadoSessao + "\nData Inicial da Sessao: "
                + dataInicialSessao + "\nDataFinalSessao: " + dataFinalSessao + "\nAlbum: " + alb +
                "Música: " + musica + "Músicos: " +mapMusicos;
    }

}
