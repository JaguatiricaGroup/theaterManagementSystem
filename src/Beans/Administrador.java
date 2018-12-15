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
public class Administrador extends Usuario implements Serializable{

    public Administrador(String nome, String login, String senha) {
        super(nome, login, senha);
    }                
}
