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
public class Cartao extends Venda implements Serializable{    
    String tipo, número ;
    Data validade;

    public Cartao(String tipo, String número, Data validade, Espectador espectador, Apresentacao apresentacao, LinkedList<numPoltrona> poltronas,double custo) {
        super(espectador, apresentacao, poltronas,custo);
        this.tipo = tipo;
        this.número = número;
        this.validade = validade;
    }

    

    public String getTipo() {
        return tipo;
    }

    public String getNúmero() {
        return número;
    }

    public Data getValidade() {
        return validade;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNúmero(String número) {
        this.número = número;
    }

    public void setValidade(Data validade) {
        this.validade = validade;
    }
    
}
