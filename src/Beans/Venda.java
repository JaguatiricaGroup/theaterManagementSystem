/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author user
 */
public abstract class Venda implements Serializable {    
    private Espectador espectador;
    private Apresentacao apresentacao;    
    private LinkedList<numPoltrona> poltronas;
    private double preco;
    //numero de reserva é a posição no vetor co controle
    public Venda(Espectador espectador, Apresentacao apresentacao, LinkedList<numPoltrona> poltronas) {
        this.espectador = espectador;
        this.apresentacao = apresentacao;
        this.poltronas=poltronas;
    }

    public Venda(Espectador espectador, Apresentacao apresentacao, LinkedList<numPoltrona> poltronas, double preco) {
        this.espectador = espectador;
        this.apresentacao = apresentacao;
        this.poltronas = poltronas;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    
    public Espectador getEspectador() {
        return espectador;
    }

    public Apresentacao getApresentacao() {
        return apresentacao;
    }

    public int getpoltronas() {
        return poltronas.size();
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }

    public void setApresentacao(Apresentacao apresentacao) {
        this.apresentacao = apresentacao;
    }   

    public LinkedList<numPoltrona> getPoltronas() {
        return poltronas;
    }

    public void setPoltronas(LinkedList<numPoltrona> poltronas) {
        this.poltronas = poltronas;
    }
   
    public void cancelarVenda(){
        //devolve poltronas
    }
    
}
