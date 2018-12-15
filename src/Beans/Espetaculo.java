/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Espetaculo implements Serializable {
    private String nome, descrição;
    private TipoDeEspetaculo tipo;
    private int duracao,faixa_etaria;//coloque um custo aqui
    private Data dataInicio,dataFim;
    private LinkedList<Artista> artistas;
    private LinkedList<Apresentacao> apresentacoes;
    private double custo;

    public Espetaculo(TipoDeEspetaculo tipo, String nome, String descrição, int duracao, int faixa_etaria, Data dataInicio, Data dataFim, LinkedList<Artista> artistas, LinkedList<Apresentacao> apresentacoes,double custo) {
        this.tipo = tipo;
        this.nome = nome;
        this.descrição = descrição;
        this.duracao = duracao;
        this.faixa_etaria = faixa_etaria;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.artistas = artistas;
        this.apresentacoes = apresentacoes;
        this.custo = custo;
    }         

    public TipoDeEspetaculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeEspetaculo tipo) {
        this.tipo = tipo;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }        

    public String getNome() {
        return nome;
    }

    public String getDescrição() {
        return descrição;
    }

    public int getDuracao() {
        return duracao;
    }

    public int getFaixa_etaria() {
        return faixa_etaria;
    }

    public Data getDataInicio() {
        return dataInicio;
    }

    public Data getDataFim() {
        return dataFim;
    }

    public LinkedList<Artista> getArtistas() {
        return artistas;
    }

    public LinkedList<Apresentacao> getApresentacoes() {
        return apresentacoes;
    }   

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setFaixa_etaria(int faixa_etaria) {
        this.faixa_etaria = faixa_etaria;
    }

    public void setDataInicio(Data dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Data dataFim) {
        this.dataFim = dataFim;
    }

    public void setArtistas(LinkedList<Artista> artistas) {
        this.artistas = artistas;
    }

    public void setApresentacoes(LinkedList<Apresentacao> apresentacoes) {
        this.apresentacoes = apresentacoes;
    }
    
    public void addArtista(Artista artista){
        artistas.add(artista);
    }
    public void addApresentacao(Apresentacao apresentacao){
        apresentacoes.add(apresentacao);
    } 

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Espetaculo other = (Espetaculo) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }                
}
