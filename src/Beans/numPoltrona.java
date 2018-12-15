/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 *
 * @author gabrieldias
 */
public class numPoltrona implements Serializable{
    int fila,poltrona;

    public numPoltrona(int fila, int poltrona) {
        this.fila = fila;
        this.poltrona = poltrona;
    }

    public int getFila() {
        return fila;
    }

    public int getPoltrona() {
        return poltrona;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setPoltrona(int poltrona) {
        this.poltrona = poltrona;
    }
    
    
    
}
