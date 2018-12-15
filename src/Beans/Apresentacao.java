/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;


/**
 *
 * @author user
 */
public class Apresentacao implements Serializable {
    
    private Sala sala;
    private Data data;

    public Apresentacao(Sala sala, Data data) {
        this.sala = sala;
        this.data = data;
    }

    public Apresentacao(Data data) {
        this.data = data;
    }

    
    public Sala getSala() {
        return sala;
    }

    public Data getData() {
        return data;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setData(Data data) {
        this.data = data;
    }
   
 
    
}
