/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Beans.Administrador;
import Beans.Apresentacao;
import Beans.Artista;
import Beans.Cartao;
import Beans.Data;
import Beans.Espectador;
import Beans.Espetaculo;
import Beans.Ficha;
import Beans.Sala;
import Beans.TipoDeEspetaculo;
import Beans.Usuario;
import Beans.Venda;
import Beans.numPoltrona;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Controlador  implements Serializable{
    LinkedList<Usuario> usuarios;
    Teatro teatro;
    LinkedList<Venda> vendas;  
    Data dataSistema;

    public Controlador() {
        //super();
        this.usuarios= new LinkedList<>();
        this.vendas = new LinkedList<>();
        this.teatro= new Teatro();        
        dataSistema=new Data(13, 12,1822,0);
    }
    
    public void cancelarCompra(Espectador user){
        Scanner ler=new Scanner(System.in);        
        System.out.println("Qual a data do seu ingresso: ");       
        Data data= new Data();
        data.insereData();
        for(Venda k:vendas){
            if(k.getApresentacao().getData().equals(data)){
                if(k.getEspectador() == user){
                    for(numPoltrona l:k.getPoltronas()){
                        k.getApresentacao().getSala().desocupaPoltrona(l.getFila(),l.getPoltrona());
                    }
                    System.out.println("Compra Cancelada.");
                    return;
                }
            }
        }
        System.out.println("nao existe essa venda");
    }
            
    
    public Usuario login(String login, String senha) {
        for(Usuario l:usuarios){
            if(l.getLogin().equals(login)){
                if(l.getSenha().equals(senha))
                    return l;
                else{
                    System.out.println("senha errada");
                    throw new RuntimeException("senha nao encontrada");
                }
            }            
        }         
        System.out.println("login nao encontrado");        
        return null;
    }
    
    public void registraUsuario(String nome, String login,String senha){
        Usuario newUser= new Administrador(nome, login, senha);            
        usuarios.add(newUser);
    }
    
    public void registraUsuario(String endereco,String telefone,String local,String endComercial,Data dataNasc,String cpf,String rg,String dataEmissao,String orgao,String nome,String login,String senha){
        Usuario newUser = new Espectador(endereco, telefone, local, endComercial, dataNasc, cpf, rg, dataEmissao, orgao, nome, login, senha);                        
        usuarios.add(newUser);
    }
    
    public void registraAdm(){
        Scanner ler=new Scanner(System.in);
        System.out.println("Novo Administrador");
        System.out.println("insira o nome");
        String nome = ler.next();
        System.out.println("insira o login");
        String login = ler.next();
        for(Usuario k:usuarios){
            if(k.getLogin().equals(login)){                
                System.out.println("login ja usado, ponha outro");
                login = ler.next();
            }            
        } 
        System.out.println("insira a senha");
        String senha = ler.next();        
        Usuario newUser= new Administrador(nome, login, senha);            
        usuarios.add(newUser);
    }
    
    public Usuario registraUsuario(){                
                Scanner ler=new Scanner(System.in);
                //olhar os ler.next();
        Usuario newUser;                
        System.out.println("insira o nome");
        String nome = ler.nextLine();
        String login = auxSetLogin();
        System.out.println("insira a senha");
        String senha = ler.next();        
        System.out.println("insira o endereco completo");
        ler.nextLine();
        String endereco = ler.nextLine();        
        System.out.println("insira o telefone");
        String telefone = ler.next();
        System.out.println("insira a local de trabalho");
        ler.nextLine();
        String local = ler.nextLine();
        System.out.println("insira o endereco comercial");       
        String endComercial  = ler.nextLine();
        System.out.println("data de nascimento");
        Data dataNasc=new Data();
        dataNasc.insereData();
        System.out.println("insira o cpf");
        String cpf = ler.next();
        System.out.println("insira o RG");
        String rg  = ler.next();
        System.out.println("insira a data de emissao");
        ler.nextLine();
        String dataEmissao = ler.next();
        System.out.println("insira o orgao emissor");
        ler.nextLine();
        String orgao = ler.next();
        newUser = new Espectador(endereco, telefone, local, endComercial,
                dataNasc, cpf, rg, dataEmissao, orgao, nome, login, senha);                        
        usuarios.add(newUser);
        return newUser;        
    }
    
    
    
    public void vender(Espectador espectador, Apresentacao apresentacao,
        LinkedList<numPoltrona> poltronas,double custo){
        Scanner ler=new Scanner(System.in);        
        Venda novaVenda;
        boolean deuCerto=false;
        System.out.println("Gostaria de comprar por cartao ou ficha? ");
        if("cartao".equals(ler.nextLine())){               
            System.out.println("tipo:");
            String tipo=ler.nextLine();
            System.out.println("numero:");
            String numero= ler.nextLine();       
            System.out.println("mes e ano de validade");
            System.out.println("mes");
            int mes = ler.nextInt();
            System.out.println("ano");
            int ano = ler.nextInt();
            Data validade= new Data(mes, ano);        
            novaVenda= new Cartao(tipo, numero, validade, espectador, apresentacao, poltronas,custo);                                
            vendas.add(novaVenda);
            deuCerto=true;

        }else{//por ficha
            System.out.println("Gostaria de Ficha de compensaçao: sim ou não");
            if(verificaDataCompensacao(apresentacao.getData())){
                if("sim".equals(ler.next())){
                    System.out.println("Boleto:");
                    System.out.println(apresentacao.getData().getDia()+ " dia da apresentacao");
                    System.out.println("cpf : "+espectador.getCPF());
                    System.out.println("nome : "+espectador.getNome());
                    System.out.println("preco : "+  custo);
                }
                novaVenda=new Ficha(espectador, apresentacao, poltronas,custo);
                vendas.add(novaVenda);
                deuCerto=true;
            }
            else
                System.out.println("Data para a compra por ficha de compsensação expirada.");
        }
        if(deuCerto)
        {
            System.out.println("seu codigo é:" + (vendas.size()-1));
            
        }
        else
        {
            for(numPoltrona k:poltronas)
                apresentacao.getSala().desocupaPoltrona(k.getFila(),k.getPoltrona());
        }
    }
    private boolean verificaDataCompensacao(Data date)
    {
        if(date.getAno()>dataSistema.getAno())
            return false;
        else
            if(date.getAno()<dataSistema.getAno())
                return true;
            else   
                if(date.getMes()>dataSistema.getMes())
                    return false;
                else
                    if(date.getMes()<dataSistema.getMes())
                        return true;
                    else
                        if(date.getDia()>dataSistema.getDia())
                            return false;
                        else
                            if(date.getDia()<dataSistema.getDia())
                                return true;
                            else
                                return false;
                                
        
            
    }
    private String auxSetLogin(){
        Scanner ler=new Scanner(System.in);
        System.out.println("insira o novo login");
        String login = ler.next();
        for(Usuario k:usuarios){
            if(k.getLogin().equals(login)){                
                System.out.println("login ja usado");
                auxSetLogin();  
            }            
        } 
        return login;
    }
    
    public void editarApresentacoes(){
        Scanner ler=new Scanner(System.in);
        while(true){
            System.out.println("Editando Apresentacoes");
            System.out.println("1: incluir");
            System.out.println("2: alterar");
            System.out.println("3: excluir");            
            System.out.println("0: sair ");
            switch(ler.nextInt()){
                case 1:{
                    teatro.criarApresentacao();
                    break;
                }
                case 2:{
                    teatro.alteraApresentação();
                    break;
                } 
                case 3:{
                    teatro.deleteApresentacao();
                    break;
                }                
                default:{
                    return;       
                }                            
            }
        }  
    }
    
    public void editarArtistas(){
        Scanner ler=new Scanner(System.in);
        while(true){
            System.out.println("Editando artistas");
            System.out.println("1: incluir");
            System.out.println("2: alterar");
            System.out.println("3: excluir");
            System.out.println("4: listar");
            System.out.println("0: sair ");
            switch(ler.nextInt()){
                case 1:{
                    teatro.novoArtista();
                    break;
                }
                case 2:{
                    teatro.alteraArtista();
                    break;
                } 
                case 3:{
                    teatro.deleteArtista();
                    break;
                }
                case 4:{
                    teatro.imprimeListaArtistas();
                    break;
                }
                default:{
                    return;       
                }                            
            }
        }  
    }
    
    public void editarSalas(){
        Scanner ler=new Scanner(System.in);
        while(true){
            System.out.println("Editando Salas");
            System.out.println("1: incluir");
            System.out.println("2: alterar");
            System.out.println("3: excluir");
            System.out.println("4: listar");
            System.out.println("0: sair ");
            switch(ler.nextInt()){
                case 1:{
                    teatro.novaSala();
                    break;
                }
                case 2:{
                    teatro.alteraSala();
                    break;
                } 
                case 3:{
                    teatro.deleteSala();
                    break;
                }
                case 4:{
                    teatro.imprimeListaSalas();
                    break;
                }
                default:{
                    return;       
                }                            
            }
        }  
    }
    
    public void editarEspetaculos(){
        Scanner ler=new Scanner(System.in);
        while(true){
            System.out.println("Editando Espetaculos");
            System.out.println("1: incluir");
            System.out.println("2: alterar");
            System.out.println("3: excluir");
            System.out.println("4: listar");
            System.out.println("0: sair ");
            switch(ler.nextInt()){
                case 1:{
                    teatro.novoEspetaculo();
                    break;
                }
                case 2:{
                    teatro.alteraEspetaculo();
                    break;
                } 
                case 3:{
                    teatro.deleteEspetaculo();
                    break;
                }
                case 4:{
                    teatro.imprimeListaEspetaculos();
                    break;
                }
                default:{
                    return;       
                }                            
            }
        }  
    }
    
    public void editarAdministrador(){
        Scanner ler=new Scanner(System.in);
        while(true){
            System.out.println("Editando Administradores");
            System.out.println("1: incluir");//f3
            System.out.println("2: alterar");//f5
            System.out.println("3: excluir");//f6
            System.out.println("4: listar");//f6
            System.out.println("0: sair ");
            switch(ler.nextInt()){
                case 1:{
                    System.out.println("Novo Administrador");
                    System.out.println("insira o nome");
                    String nome = ler.next();
                    String login= auxSetLogin();
                    System.out.println("insira a senha");
                    String senha = ler.next();        
                    Usuario newUser= new Administrador(nome, login, senha);            
                    usuarios.add(newUser);
                    break;
                }
                case 2:{
                    System.out.println("qual o login do usuario");
                    String login=ler.next();
                    Usuario aux;
                    for(Usuario k:usuarios){
                        if(login.equals(k.getLogin())){
                            aux=k;
                        }
                    }                    
                    System.out.println("1: nome");
                    System.out.println("2: login");
                    System.out.println("3: senha");                    
                    break;
                } 
                case 3:{
                    System.out.println("qual o login do usuario para excluir");
                    String login=ler.next();
                    Usuario aux;
                    for(Usuario k:usuarios){
                        if(login.equals(k.getLogin())){
                            if(usuarios.remove(k))
                                break;
                            else throw new RuntimeException("tentando excluir usuario inexistente");
                        }
                    }  
                    break;
                }
                case 4:{
                    System.out.println("listando todos usuarios");                                        
                    for(Usuario k:usuarios){
                        System.out.println(k.getLogin()+" ");
                    }  
                    break;
                }
                default:{
                    return;       
                }                            
            }
        }  
    }    
    public void editarTiposEspetaculos(){
        Scanner ler=new Scanner(System.in);
        while(true){
            System.out.println("Editando Tipos de Espetaculos");
            System.out.println("1: incluir");
            System.out.println("2: alterar");
            System.out.println("3: excluir");
            System.out.println("4: listar");
            System.out.println("0: sair ");
            switch(ler.nextInt()){
                case 1:{
                    teatro.novoTipo();
                    break;
                }
                case 2:{
                    teatro.alteraTipo();
                    break;
                } 
                case 3:{
                    teatro.deleteTipo();
                    break;
                }
                case 4:{
                    teatro.imprimeListaTipos();
                    break;
                }
                default:{
                    return;       
                }                            
            }
        }    
    }
    
    public void modificarPreferencias(Espectador logado){
        Scanner ler= new Scanner(System.in);
        System.out.println("Selecione os seus tipos de interesse");
        teatro.imprimeListaTipos();
        System.out.println("digite sair para terminar");
        System.out.println("Resposta:");
        String tipo=ler.next();
        while(!"sair".equals(tipo)){
            try {
                logado.addInteresse(teatro.retornaEspetaculosDaLista(tipo));
            } catch (Exception e) {
                System.out.println("nao existe sua preferencia");
                break;
            }            
            tipo=ler.next();
        }    
        //cada vez que adcionar algum espetaculo do tipo manda email pro usuario
    }
    
    public void comprarIngresso(Espectador logado){
        Scanner le = new Scanner(System.in);
        System.out.println("Lista de espetáculos");
        teatro.imprimeListaEspetaculos();
        System.out.println("Qual espetaculo desejaria comprar");
        String nomeEspetaculo = le.nextLine();
        System.out.println("qual a data ?");
        Data escolhida = new Data();        
        escolhida.insereData();
        Apresentacao apresentacao=null;
        try {
            apresentacao= teatro.retornaApresentacao(escolhida);// = funcao de busca por data                     
        } catch (Exception e) {
            return;
        }      
        System.out.println("escolha as poltronas, digite sair");
        String sair;       
        LinkedList<numPoltrona> poltronas_escolhidas;
        poltronas_escolhidas = new LinkedList<>();
        apresentacao.getSala().imprimeListaPoltronasVagas();
        do {    
            try{
            System.out.println("qual a poltrona ?");
            System.out.println("qual a linha?");
            le.nextLine();
            int aux=le.nextInt();
            System.out.println("qual a coluna?");
            le.nextLine();
            int auy=le.nextInt();
            numPoltrona nov=new numPoltrona(aux,auy);
            if(apresentacao.getSala().PoltronasOcupada(aux,auy)){
                System.out.println("Poltrona ocupada");
                System.out.println("deseja sair ?");
                continue;
                
            }
            apresentacao.getSala().ocupaPoltrona(aux,auy);
            poltronas_escolhidas.add(nov);
            System.out.println("Para parar de comprar digite sair:");
            }catch(InputMismatchException w){
                continue;
            }
        }    while (!("sair".equals(le.next())));        
        Espetaculo espetaculo=null;
        try{
             espetaculo = teatro.retornaEspetaculo(nomeEspetaculo);
        }catch(RuntimeException e){
            System.out.println("espetaculo invalido");
            return;
        }
        double custo= poltronas_escolhidas.size()*espetaculo.getCusto();
        System.out.println("Custo: " + custo + " confirmar: sim ou nao");
        if("sim".equals(le.next())){                    
            vender((Espectador) logado,apresentacao,poltronas_escolhidas,custo);
        }  
    }
    
    public void consultaEspetaculos(){
        Scanner le = new Scanner(System.in);
        System.out.println("Consultar Espetaculos de hoje");
        System.out.println("tipo, artista, faixa_etária:");
        String ler=le.next();
        if("tipo".equals(ler)){
            teatro.imprimeListaTipos();            
            teatro.imprimeListaEspetaculosTipo(dataSistema);
        }else{
            if("artista".equals(ler)){
                teatro.imprimeListaArtistas();
                teatro.imprimeListaEspetaculosArtista(dataSistema);
            }else{
                if("Faixa etária".equals(ler))
                    teatro.imprimeListaEspetaculosFaixaEtaria(dataSistema);
            }
        }
    }
    
    public void emitirRelatorio(){
        Scanner ler=new Scanner(System.in);
        System.out.println("Qual relatório gostaria ?");
        System.out.println("1: Ocupacao");
        System.out.println("2: Valor arrecadado em espetaculo");
        System.out.println("3: Valor arrecadado em tipos espetaculo");
        System.out.println("4: relatorios de quantidades");
        System.out.println("0: sair");
        while(true){
            switch( ler.nextInt()){
                case 1 : {
                    teatro.imprimeListaEspetaculos();                            
                    try{
                        teatro.RelatorioOcupacao();
                    }catch(Exception e){
                        System.out.println("espetaculo invalido");                    
                        
                    }
                    return;
                }
                case 2 : {
                    teatro.RelatorioArrecadacao();
                    return;
                }
                case 3 : {
                    teatro.RelatorioArrecadacaoTipo(dataSistema);
                    return;
                }
                case 4 : {
                    System.out.println("relatorios de quantidades");
                    System.out.println("Relatorio de Funcionamento");
                    System.out.println("Data ");
                    System.out.println( dataSistema.getHora() + " horas " +  dataSistema.getDia()+ " dia "+ dataSistema.getMes()+" mes " + dataSistema.getAno()+ " ano");        
                    System.out.println("existem "+ usuarios.size() + " usuarios");
                    System.out.println("existem "+ vendas.size() + " vendas");
                    System.out.println("existem "+ teatro.getArtistas().size() + " artistas");
                    System.out.println("existem "+ teatro.getEspetaculos().size() + " espetaculos");
                    System.out.println("existem "+ teatro.getSalas().size() + " salas");
                    System.out.println("existem "+ teatro.getTipos().size() + " tipos diferentes");
                    System.out.println("existem "+ teatro.getApresentacoes().size() + " apresentacoes");
                    return;
                }         
                default: return;
            }       
        }        
    }    
    
    public void debug(){
        usuarios.add(new Espectador("qwe", "qwe", "asda", "asdas", dataSistema, "wee", "asd", "sadad", "sada", "jao", "jao", "jao"));
        registraUsuario("root","root","root");//debug 
        teatro.getArtistas().add(new Artista("jao", "asdas", "asdas", "asdas", "asdas", "asdas", dataSistema));
        teatro.getSalas().add(new Sala(1, 12, 12, 12, "wdsadas"));
        teatro.getTipos().add(new TipoDeEspetaculo("fantasia", "asdasd"));
        Sala s=teatro.getSalas().get(0);
        Apresentacao p=new Apresentacao(s, dataSistema);
        teatro.getApresentacoes().add(p);
        teatro.getEspetaculos().add(new Espetaculo(teatro.getTipos().get(0), "bela e fera", "nada", 12,12 , dataSistema, dataSistema,(LinkedList<Artista>) teatro.getArtistas(),(LinkedList<Apresentacao>) teatro.getApresentacoes(), 21));
    }
}

    