/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author gabrieldias
 */
public class TipoDeEspetaculo implements Serializable{
    String nomeAbreviado,descricao;

    public TipoDeEspetaculo(String nomeAbreviado, String descricao) {
        this.nomeAbreviado = nomeAbreviado;
        this.descricao = descricao;
    }

    public String getNomeAbreviado() {
        return nomeAbreviado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setNomeAbreviado(String nomeAbreviado) {
        this.nomeAbreviado = nomeAbreviado;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        final TipoDeEspetaculo other = (TipoDeEspetaculo) obj;
        if (!Objects.equals(this.nomeAbreviado, other.nomeAbreviado)) {
            return false;
        }
        return true;
    }

   
    
}
