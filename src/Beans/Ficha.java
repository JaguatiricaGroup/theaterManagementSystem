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
public class Ficha extends Venda implements Serializable {

    public Ficha(Espectador espectador, Apresentacao apresentacao, LinkedList<numPoltrona> poltronas,double custo) {
        super(espectador, apresentacao, poltronas,custo);
    }   
}
