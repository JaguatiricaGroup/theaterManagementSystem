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
 * @author user
 */
public class Artista implements Serializable{
    private String nomeCompleto, CPF, RG, telefone, celular, email;
    private Data dataNascimento;

    public Artista(String nomeCompleto, String CPF, String RG, String telefone, String celular, String email, Data dataNascimento) {
        this.nomeCompleto = nomeCompleto;
        this.CPF = CPF;
        this.RG = RG;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCPF() {
        return CPF;
    }

    public String getRG() {
        return RG;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
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
        final Artista other = (Artista) obj;
        if (!Objects.equals(this.nomeCompleto, other.nomeCompleto)) {
            return false;
        }
        return true;
    }
    
}
