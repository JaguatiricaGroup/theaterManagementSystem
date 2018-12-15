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
public class Espectador extends Usuario implements Serializable{
    private String  endereco_completo, telefones, local_de_trabalho, 
            endereco_comercial , CPF, RG, data_de_emissao,
            orgao_emissor;
    Data data_de_nascimento;
    LinkedList<TipoDeEspetaculo> interesse;

    public Espectador(String endereco_completo, String telefones, 
            String local_de_trabalho, String endereco_comercial,
            Data data_de_nascimento, String CPF, String RG,
            String data_de_emissao, String orgao_emissor, String nome,
            String login, String senha) {
        super(nome, login, senha);
        this.endereco_completo = endereco_completo;
        this.telefones = telefones;
        this.local_de_trabalho = local_de_trabalho;
        this.endereco_comercial = endereco_comercial;
        this.data_de_nascimento = data_de_nascimento;
        this.CPF = CPF;
        this.RG = RG;
        this.data_de_emissao = data_de_emissao;
        this.orgao_emissor = orgao_emissor;
        interesse= new LinkedList<>();
    }        
    
    public void addInteresse(TipoDeEspetaculo interessante){
        interesse.add(interessante);
    }
    
    public void removeInteresse(TipoDeEspetaculo interessante){
        interesse.remove(interessante);
    }
        
    public String getEndereco_completo() {
        return endereco_completo;
    }

    public String getTelefones() {
        return telefones;
    }

    public String getLocal_de_trabalho() {
        return local_de_trabalho;
    }

    public String getEndereco_comercial() {
        return endereco_comercial;
    }

    public Data getData_de_nascimento() {
        return data_de_nascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public String getRG() {
        return RG;
    }

    public String getData_de_emissao() {
        return data_de_emissao;
    }

    public String getOrgao_emissor() {
        return orgao_emissor;
    }

    public void setEndereco_completo(String endereco_completo) {
        this.endereco_completo = endereco_completo;
    }

    public void setTelefones(String telefones) {
        this.telefones = telefones;
    }

    public void setLocal_de_trabalho(String local_de_trabalho) {
        this.local_de_trabalho = local_de_trabalho;
    }

    public void setEndereco_comercial(String endereco_comercial) {
        this.endereco_comercial = endereco_comercial;
    }

    public void setData_de_nascimento(Data data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public void setData_de_emissao(String data_de_emissao) {
        this.data_de_emissao = data_de_emissao;
    }

    public void setOrgao_emissor(String orgao_emissor) {
        this.orgao_emissor = orgao_emissor;
    }

    public boolean equals(Espectador o) {
        if(this.orgao_emissor.equals(o.getOrgao_emissor())){
            if(this.getLogin().equals(o.getLogin())){
                if(o.getNome().equals(this.getNome())){
                    if(this.data_de_nascimento.equals(o.getData_de_nascimento())){
                        if(this.getSenha().equals(o.getSenha())){
                            if(this.endereco_completo.equals(o.getEndereco_completo())){
                                if(this.telefones.equals(o.getTelefones())){
                                    if(this.local_de_trabalho.equals(o.getLocal_de_trabalho())){
                                        if(this.endereco_comercial.equals(o.getEndereco_comercial())){
                                            if(this.CPF.equals(o.getCPF())){
                                                if(this.RG.equals(o.getRG())){
                                                    if(this.data_de_emissao.equals(o.getData_de_emissao())){
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }        
}
