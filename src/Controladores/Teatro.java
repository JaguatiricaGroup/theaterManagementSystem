/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Beans.Apresentacao;
import Beans.Artista;
import Beans.Data;
import Beans.Espetaculo;
import Beans.Sala;
import Beans.TipoDeEspetaculo;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Teatro implements Serializable{
    List<Espetaculo> espetaculos;
    List<Sala> salas;
    List<Artista> artistas;
    List<Apresentacao> apresentacoes;
    List<TipoDeEspetaculo> tipos;

    public Teatro(LinkedList<Espetaculo> espetaculos, LinkedList<Sala> salas, LinkedList<Artista> artistas) {
        this.espetaculos = espetaculos;        
        this.salas = salas;
        this.artistas = artistas;
    }

    public Teatro() {
        this.espetaculos = new LinkedList<>();
        this.salas = new LinkedList<>();
        this.artistas = new LinkedList<>();
        this.apresentacoes= new LinkedList<>();
        this.tipos=new LinkedList<>();
    }    

    public List<Espetaculo> getEspetaculos() {
        return espetaculos;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setEspetaculos(LinkedList<Espetaculo> espetaculos) {
        this.espetaculos = espetaculos;
    }

    public void setSalas(LinkedList<Sala> salas) {
        this.salas = salas;
    }

    public void setArtistas(LinkedList<Artista> artistas) {
        this.artistas = artistas;
    }
    
    public void novaSala(){
        Scanner ler=new Scanner(System.in);
        System.out.println("Inserindo nova sala");
        System.out.println("Digite o numero?");
        int numSala= ler.nextInt();        
        for(Sala k:salas){
            if(k.getNumSala()==numSala){
                System.out.println("Sala já existente.");
                return;
            }
        }           
        System.out.println("digite uma descricao:");
        ler.next();
        String descricao=ler.nextLine();
        System.out.println("Digite o numero de fileiras:");
        int x=ler.nextInt();
        System.out.println("Digite o numero de colunas:");
        int y=ler.nextInt();
        salas.add(new Sala(numSala, x,x,y, descricao));
    }
    
    public void imprimeListaSalas(){
        for(Sala l:salas){
            System.out.println(l.getNumSala()+ " ");
        }
    }
    
    public void deleteSala(){
        System.out.println("Deletando sala");
        Scanner ler=new Scanner(System.in);
        System.out.println("insira o numero da sala:");
        int numeroSala = ler.nextInt();
        for(Sala k:salas){
            if(k.getNumSala()==numeroSala){
                salas.remove(k);
                System.out.println("sala removida");
                return;
            }
        }
        System.out.println("nao existe essa sala");        
    }

    public List<Apresentacao> getApresentacoes() {
        return apresentacoes;
    }

    public List<TipoDeEspetaculo> getTipos() {
        return tipos;
    }
    
    public void alteraSala()
    {
        System.out.println("Alterando sala");
        Scanner ler=new Scanner(System.in);
        System.out.println("insira o numero da sala:");
        int numeroSala = ler.nextInt();
        for(Sala k:salas){
            if(k.getNumSala()==numeroSala){
                System.out.println("O que deseja alterar?");
                System.out.println("\n1-Número da sala");
                System.out.println("\n2-Descrição da sala");
                System.out.println("\n3-Mapa de assentos da sala");
                int op=ler.nextInt();
                switch(op){
                    case 1:
                        System.out.println("\nAlerando o número da sala.Informe o novo número:");
                        int novo=ler.nextInt();
                      
                        for(Sala p:salas)
                            if(p.getNumSala()==novo)
                            {
                                System.out.println("Número já existente.");
                                return;
                            }                       
                            k.setNumSala(novo);
                        break;
                    case 2:
                        ler.next();
                        System.out.println("\nAlerando a descrição da sala.Informe a nova descrição:");
                        String nova=ler.nextLine();
                        k.setDescrição(nova);
                        break;
                    case 3:
                        System.out.println("\nAlerando o mapa de assentos da sala.");
                        int sair=0;
                        while(sair!=-1)
                        {
                            System.out.println("\nInforme a linha:");
                            int x=ler.nextInt();
                            System.out.println("\nInforme a coluna:");
                            int y=ler.nextInt();
                            System.out.println("\n1-Ocupar o assento.\n2-Desocupar.\nOpção:");
                            int o=ler.nextInt();
                            if(o==1)
                                k.ocupaPoltrona(x, y);
                            else
                                k.desocupaPoltrona(x,y);
                            
                            System.out.println("Deseja parar de alterar o mapa?\n-1-Sim\n1-Não");
                            sair=ler.nextInt();   
                        }
                }
                System.out.println("Sala alterada com sucesso!");
                return;
            }
        }
        System.out.println("nao existe essa sala"); 
        
    }
    
    public void novoArtista(){
        Scanner ler=new Scanner(System.in);
        System.out.println("inserindo novo artista");
        System.out.println("digite o nome");
        String nome= ler.nextLine();        
        for(Artista k:artistas){
            if(Objects.equals(k.getNomeCompleto(),nome)){
                System.out.println("impossivel inserir artista ja existe");
                return;
            }
        }        
        System.out.println("Digite o CPF:");
        String cpf =ler.next();
        System.out.println("Digite o RG:");                
        String rg =ler.next();
        System.out.println("Digite o telefone:");
        String telefone =ler.next();
        System.out.println("Digite o celular:");
        String celular =ler.next();
        System.out.println("Digite o email:");
        String email =ler.next();
        Data data=new Data();
        data.insereData();
        artistas.add(new Artista(nome, cpf, rg, telefone , celular, email, data));         
    }
    
    public void imprimeListaArtistas(){
        for(Artista l:this.artistas){
            System.out.println(l.getNomeCompleto()+ " ");
        }
    }
    
    public void deleteArtista(){
        System.out.println("Deletando artista..");
        Scanner ler=new Scanner(System.in);
        System.out.println("Insira o nome completo do artista:");
        String nome=ler.nextLine();
        for(Artista k:this.artistas){
            if(Objects.equals(k.getNomeCompleto(),nome)){
                artistas.remove(k);
                System.out.println("Artista removido.");
                return;
            }
        }
        System.out.println("Não existe esse artista.");        
    }
    public void alteraArtista(){
        System.out.println("Alterando artista..");
        Scanner ler=new Scanner(System.in);
        System.out.println("Insira o nome completo do artista:");
        String nome=ler.nextLine();
        for(Artista k:this.artistas){
            if(Objects.equals(k.getNomeCompleto(),nome)){
                System.out.println("O que deseja alterar?");
                System.out.println("\n1-Nome completo.");
                System.out.println("\n2-CPF.");
                System.out.println("\n3-RG.");
                System.out.println("\n4-Telefone.");
                System.out.println("\n5-Celular.");
                System.out.println("\n6-Email.");
                System.out.println("\n7-Data de nascimento.");
                int op=ler.nextInt();
                String novo;
                switch(op)
                {
                    case 1:
                        System.out.println("Informe o novo nome:");
                        novo=ler.next();
                        for(Artista p:artistas)
                            if(p.getNomeCompleto().equals(novo))
                            {
                                System.out.println("Artista já existente.");
                                return;
                            }
                        k.setNomeCompleto(novo);
                        break;
                    case 2:
                        System.out.println("Informe o novo CPF:");
                        novo=ler.next();
                        k.setCPF(novo);
                        break;
                    case 3:
                        System.out.println("Informe o novo RG:");
                        novo=ler.next();
                        k.setRG(novo);
                        break;
                    case 4:
                        System.out.println("Informe o novo telefone:");
                        novo=ler.next();
                        k.setTelefone(novo);
                        break;
                    case 5:
                        System.out.println("Informe o novo celular:");
                        novo=ler.next();
                        k.setCelular(novo);
                        break;
                    case 6:
                        System.out.println("Informe o novo email:");
                        novo=ler.next();
                        k.setEmail(novo);
                        break;
                    case 7:
                        System.out.println("Informe o novo dia:");
                        int dia=ler.nextInt();
                        System.out.println("Informe o novo mes:");
                        int mes=ler.nextInt();
                        System.out.println("Informe o novo ano:");
                        int ano=ler.nextInt();
                        Data nova=new Data(dia,mes,ano,0);
                        k.setDataNascimento(nova);
                        break;
                        
                }
                System.out.println("Alteração feita com sucesso!");
                return;
            }
        }
        System.out.println("Não existe esse artista.");        
        
        
    }
    
    public void novoEspetaculo(){
        Scanner ler=new Scanner(System.in);
        System.out.println("Inserindo novo espetaculo..");
        System.out.println("Digite o nome:");
        String nome= ler.nextLine();        
        for(Espetaculo k:this.espetaculos){
            if(Objects.equals(k.getNome(),nome)){
                System.out.println("Impossivel inserir espetaculo ja existe.");
                return;
            }
        }        
        //ler.next();
        System.out.println("Digite o tipo:");
        String tipo =ler.next();
        TipoDeEspetaculo tipoDesse = null;   //ver aqui     
        for(TipoDeEspetaculo k:this.tipos){
            if(Objects.equals(tipo,k.getNomeAbreviado())){
                tipoDesse=k;
            }
        }
        if(tipoDesse==null){
            System.out.println("Tipo invalido");
            return;
        }
        System.out.println("Digite  descricao:");
        ler.next();
        String descricao =ler.nextLine();
        System.out.println("Digite a duracao:");
        int duracao =ler.nextInt();
        System.out.println("Digite faixa etaria:");
        int faixaEtaria =ler.nextInt();
        Data datainicio= new Data();
        System.out.println("Insira a data de inicio:");
        datainicio.insereData();
        System.out.println("Insira a data de fim:");
        Data dataFim=new Data();
        dataFim.insereData();
        System.out.println("Digite o custo a ser cobrado:");
        double custo =ler.nextDouble();
        Espetaculo espetaculo;        
        espetaculo = new Espetaculo(tipoDesse, nome, descricao, duracao, faixaEtaria, datainicio , dataFim, new LinkedList<>(), new LinkedList<>(),custo);
        this.espetaculos.add(espetaculo);    
        insereArtistaEspetaculo(espetaculo);
        int sair=0;
        while(sair!=-1){
            System.out.println("criar apresentacao digite -1 para sair:");
            sair=ler.nextInt();
            if(sair!=-1)
            {   try{
                Apresentacao nov=criarApresentacao();
                espetaculo.addApresentacao(nov);
                apresentacoes.add(nov);
                 }catch(RuntimeException e)
                 {
                     System.err.println(e.getMessage());
                 }
            }
            
        }
    }
    
    public void insereArtistaEspetaculo(Espetaculo espetaculo){
        Scanner ler= new Scanner(System.in);    
        while(true){
            System.out.println("digite o nome completo do artista, caso queira sair digite sair");
            String nome=ler.nextLine();
            if(Objects.equals(nome,"sair"))break;
            for(Artista k:artistas){
                if(k.getNomeCompleto().equals(nome)){                        
                    espetaculo.addArtista(k);
                    return;
                }
            }
        } System.err.println("Não existe esse artista nesse espetaculo");
    }
    public void excluiArtistaEspetaculo(Espetaculo espetaculo){
        Scanner ler= new Scanner(System.in);    
        while(true){
            System.out.println("digite o nome completo do artista, caso queira sair digite sair");
            String nome=ler.nextLine();
            if(Objects.equals(nome,"sair"))break;
            for(Artista k:artistas){
                if(Objects.equals(k.getNomeCompleto(),nome)){                        
                    espetaculo.getArtistas().remove(k);
                    return;
                }
            }
            System.err.println("Não existe esse artista nesse espetaculo");
        } 
    }
    
    
    public Apresentacao criarApresentacao(){
        Scanner ler=new Scanner(System.in);
        System.out.println("digite a data da apresentacao:");
        Data data=new Data();
        data.insereData();
        Apresentacao apresentacao= new Apresentacao(data);
        Sala j=insereSalaEmApresentacao(apresentacao);
        for(Apresentacao k:apresentacoes){
            if(j.getNumSala()==k.getSala().getNumSala() && k.getData().equals(data)){
                System.out.println("impossivel criar ja tem a apresentacao");
                throw new RuntimeException("Apresentacao ja existe");
            }            
        }
        System.out.println("MDS.");
        return apresentacao;
    }
    
    
    public void deleteApresentacao(){
        Scanner ler=new Scanner(System.in);
        System.out.println("digite a data da apresentacao:");
        Data data=new Data();
        data.insereData();
        System.out.println("digite a sala da apresentacao:");
        int numSala= ler.nextInt();
        for(Apresentacao k:apresentacoes){
            if(numSala==k.getSala().getNumSala() && data==k.getData()){
                apresentacoes.remove(k);
            }
        }
        System.out.println("impossivel excluir nao existe");
        throw new RuntimeException("Apresentacao nao existe");                                
    }
    public void alteraApresentação()
    {
        Scanner ler=new Scanner(System.in);
        System.out.println("digite a data da apresentacao:");
        Data data=new Data();
        data.insereData();
        System.out.println("digite a sala da apresentacao:");
        int numSala= ler.nextInt();
        for(Apresentacao k:apresentacoes){
            if(numSala==k.getSala().getNumSala() && data==k.getData()){
                System.out.println("\nO que deseja alterar?");
                System.out.println("\n1-Data\n2-Sala");
                int op=ler.nextInt();
                switch (op)
                {
                    case 1:
                        Data n=new Data();
                        data.insereData();
                        for(Apresentacao p:apresentacoes)
                            if(n.equals(p.getData())&&k.getSala().equals(p.getSala()))
                            {
                                System.out.println("Não é possivel mudar para essa data.");
                                return;
                            }
                        System.out.println("Alteração concluida!");
                        k.setData(n);
                        break;
                    case 2:
                        System.out.println("Informe a nova sala");
                        int x=ler.nextInt();
                        for(Apresentacao p:apresentacoes)
                            if(k.getData().equals(p.getData())&&x==p.getSala().getNumSala())
                            {
                                System.out.println("Não é possivel mudar para essa sala.");
                                return;
                            }
                        for(Sala nova:salas )
                            if(nova.getNumSala()==x)
                            {
                                k.setSala(nova);
                                System.out.println("Alteração concluida!");
                                break;
                            }
            }
        }
        System.out.println("impossivel alterar, nao existe");
        throw new RuntimeException("Apresentacao nao existe");               
    }
    }
    
    
    public Sala insereSalaEmApresentacao(Apresentacao apresentacao){
        Scanner ler=new Scanner(System.in);
        System.out.println("qual o numero da sala a inserir");
        int numSala=ler.nextInt();
        for(Sala k:salas){
            if(k.getNumSala()==numSala){
                Sala j;
                j=new Sala(k.getNumSala(), k.getTotalAssentos(),k.getX(),k.getY(),k.getDescrição());
                apresentacao.setSala(j);
                return j;
            }
        }
        System.out.println("nao existe essa sala");
        return null;
    }
    public void excluiApresentcaoEspetaculo(Espetaculo g )
    {
        Scanner ler=new Scanner(System.in);
        System.out.println("Informe a Data.");
        Data remo=new Data();
        remo.insereData();
        boolean achou=false;
        System.out.println("Informe o numero da sala:");
        int x=ler.nextInt();
        for(Apresentacao k:g.getApresentacoes())
            if(remo.equals(k.getData())&&k.getSala().getNumSala()==x)
            {
                g.getApresentacoes().remove(k);
                System.out.println("Apresentação excluida.");
                achou=true;
            }
        if(!achou)
            System.out.println("Não existe essa apresentação");
    }
    
    public void imprimeListaEspetaculos(){
        
        for(Espetaculo l:espetaculos){
            int i=1;
            System.out.println("Espetaculo "+i);
            System.out.println("Nome:"+l.getNome()+"\nFaixa Etaria:"+l.getFaixa_etaria()+"\nDuração:"+l.getDuracao()+"\nData Inicio:"+l.getDataInicio().getDia()
            +"/"+l.getDataInicio().getMes()+"/"+l.getDataInicio().getAno()
            +"\nData Fim:"+l.getDataFim().getDia()
            +"/"+l.getDataFim().getMes()+"/"+l.getDataFim().getAno()+"\nDescrição"+l.getDescrição());
            i++;
            System.out.println("\nArtistas");
            for(Artista p:l.getArtistas())
                System.out.println(p.getNomeCompleto()+"   ");
            System.out.println("\nApresentações");
            for(Apresentacao t:l.getApresentacoes())
                System.out.println("Data:"+t.getData().getDia()+"/"+t.getData().getMes()
                +"/"+t.getData().getAno()+" Horario:"+t.getData().getHora()+"\nSala:"+t.getSala().getNumSala());
        }
    }
    
    public void deleteEspetaculo(){  
        System.out.println("deletando espetaculo");
        Scanner ler=new Scanner(System.in);
        System.out.println("insira o nome do espetaculo");
        String nome=ler.nextLine();
        for(Espetaculo k:espetaculos){
            if(Objects.equals(k.getNome(),nome)){
                espetaculos.remove(k);
                System.out.println("Espetaculo removido.");
                break;
            }
        }        
        System.out.println("Nao existe esse espetaculo.");        
    }
    public void alteraEspetaculo()
    {
        System.out.println("Alterando espetaculo");
        Scanner ler=new Scanner(System.in);
        System.out.println("Insira o nome do espetaculo");
        String nome=ler.nextLine();
        for(Espetaculo k:espetaculos){
            if(Objects.equals(k.getNome(),nome)){
                System.out.println("O que deseja alterar?");
                System.out.println("\n1-Nome.");
                System.out.println("\n2-Tipo.");
                System.out.println("\n3-Descrição.");
                System.out.println("\n4-Duração.");
                System.out.println("\n5-Faixa etária.");
                System.out.println("\n6-Data início.");
                System.out.println("\n7-Data fim.");
                System.out.println("\n8-Artistas.");
                System.out.println("\n9-Apresentações.");
                int op=ler.nextInt();
                String novo;
                switch(op)
                {
                    case 1:
                        System.out.println("Informe o novo nome:");
                        novo=ler.next();
                        k.setNome(novo);
                        break;
                    case 2:
                        System.out.println("Informe o novo Tipo:");
                        String nomeAbreviado=ler.next();
                        boolean achou=false;
                        for(TipoDeEspetaculo p:tipos){
                            if(Objects.equals(nomeAbreviado,p.getNomeAbreviado())){
                                k.setTipo(p);
                                achou=true; 
                            }           
                        }
                        if(!achou)
                            System.out.println("tipo nao existe");  
                        break;
                    case 3:
                        System.out.println("Informe a nova descrição:");
                        novo=ler.nextLine();
                        k.setDescrição(novo);
                        break;
                    case 4:
                        System.out.println("Informe a nova duração:");
                        int n=ler.nextInt();
                        k.setDuracao(n);
                        break;
                    case 5:
                        System.out.println("Informe a nova faixa etária:");
                        int n1=ler.nextInt();
                        k.setFaixa_etaria(n1);
                        break;
                    case 6:{
                        Data nova=new Data();
                        nova.insereData();                        
                        k.setDataInicio(nova);
                        break;
                    }
                    case 7:{
                        Data nova=new Data();
                        nova.insereData();                        
                        k.setDataInicio(nova);
                        break;
                    }
                    case 8:
                        System.out.println("O que deseja alterar nos artistas desse espetáculo?");
                        System.out.println("\n1-Adicionar\n2-Excluir");
                        int opp=ler.nextInt();
                        switch(opp)
                        {
                            case 1:
                                insereArtistaEspetaculo(k);
                                break;
                            case 2:
                                excluiArtistaEspetaculo(k);
                                break;
                        }
                        break;
                    case 9:
                        System.out.println("O que deseja alterar nas apresentações desse espetáculo?");
                        System.out.println("\n1-Adicionar\n2-Excluir");
                        int op1=ler.nextInt();
                        switch(op1)
                        {
                            case 1:
                                try{
                                Apresentacao nov=criarApresentacao();
                                apresentacoes.add(nov);
                                k.getApresentacoes().add(nov);                                
                                break;
                                }catch(RuntimeException e)
                                {
                                    System.out.println(e.getMessage());
                                }
                            case 2:
                                excluiApresentcaoEspetaculo(k);
                                break;
                        }
                        break;     
                        
                }
               return; 
            }
        }
        System.out.println("Nao existe esse espetaculo."); 
        
    }
    
    public void novoTipo(){
        Scanner ler=new Scanner(System.in);
        System.out.println("Adcionando novo tipo");
        System.out.println("digite o nome abreviado do tipo");
        String nomeAbreviado=ler.next();
        for(TipoDeEspetaculo k:tipos){
            if(nomeAbreviado.equals(k.getNomeAbreviado())){
                System.out.println("tipo ja existe");
                return;
            }           
        }
        System.out.println("digite a descricao do tipo");
        ler.nextLine();
        String descricao= ler.nextLine();
        tipos.add(new TipoDeEspetaculo(nomeAbreviado, descricao));
    }
    
    public void deleteTipo(){
        Scanner ler=new Scanner(System.in);
        System.out.println("deletando tipo");
        System.out.println("digite o nome abreviado do tipo");
        String nomeAbreviado=ler.next();
        for(TipoDeEspetaculo k:tipos){
            if(nomeAbreviado.equals(k.getNomeAbreviado())){
                tipos.remove(k);                
                return;
            }           
        }
        System.out.println("tipo nao existe");                
    }
    
    public void alteraTipo()
    {
        Scanner ler=new Scanner(System.in);
        System.out.println("Alterando tipo");
        System.out.println("Digite o nome abreviado do tipo:");
        String nomeAbreviado=ler.next();
        for(TipoDeEspetaculo k:tipos){
            if(Objects.equals(nomeAbreviado,k.getNomeAbreviado())){
                System.out.println("O que deseja alterar?");
                System.out.println("\n1-Nome abreviado");
                System.out.println("\n2-Descrição");
                int op=ler.nextInt();
                switch(op)
                {
                    case 1:
                        System.out.println("Informe o novo nome:");
                        ler.next();
                        String novo=ler.nextLine();
                        k.setNomeAbreviado(novo);
                        break;
                    case 2:
                        System.out.println("Informe a nova descrição:");
                        ler.next();
                        String nova=ler.nextLine();
                        k.setDescricao(nova);
                        break;
                }
                System.out.println("Alteração feita com sucesso!");
                return;
            }           
        }
        System.out.println("tipo nao existe");   
        
    }
    
    public void imprimeListaTipos(){
        for(TipoDeEspetaculo k:tipos){
            System.out.println(k.getNomeAbreviado()+" ");
        }
    }
    
    public TipoDeEspetaculo retornaEspetaculosDaLista(String nomeAbreviado){
        for(TipoDeEspetaculo k:tipos){
            if(nomeAbreviado.equals(k.getNomeAbreviado())){
                return k;                
            }           
        }
        throw new RuntimeException("nao tem o espetaculo");
    }    
    
    public Apresentacao retornaApresentacao(Data data){
        for(Apresentacao k:apresentacoes){
            if(data.equals(k.getData())){
                return k;
            }
        }
        throw new RuntimeException("nao existe apresentacao nessa data");
    }
    
     public Espetaculo retornaEspetaculo(String nome){
        for(Espetaculo k:espetaculos){
            if(nome.equals(k.getNome())){
                return k;
            }
        }
        throw new RuntimeException("nao existe espetaculo");
    }
    
    public void imprimeListaEspetaculosTipo(Data hoje){
        Scanner ler=new Scanner(System.in);
        System.out.println("Qual o tipo ?");
        String tipo = ler.next();
        for(Espetaculo k:espetaculos){
            if(k.getTipo().getNomeAbreviado().equals(tipo)){
                for(Apresentacao u:k.getApresentacoes()){
                    if(u.getData()==hoje)
                        System.out.println(k.getNome() + " ");
                }                
            }
        }
    }
    
    public void imprimeListaEspetaculosArtista(Data hoje){
        Scanner ler=new Scanner(System.in);
        System.out.println("Qual o nome completo do Artista ?");
        String nome = ler.next();
        for(Espetaculo k:espetaculos){
            for(Apresentacao y:k.getApresentacoes()){
                if(y.getData()==hoje)
                    for(Artista u:k.getArtistas()){                
                        if(u.getNomeCompleto().equals(nome) ){
                                System.out.println(k.getNome() + " ");        
                    }                                
                }                
            }            
        }
    }
    
    public void imprimeListaEspetaculosFaixaEtaria(Data hoje){
        Scanner ler=new Scanner(System.in);
        System.out.println("Qual a Faixa etaria?");
        int faixa = ler.nextInt();
        for(Espetaculo k:espetaculos){
            if(k.getFaixa_etaria()==faixa){
                for(Apresentacao u:k.getApresentacoes()){
                    if(u.getData()==hoje)
                        System.out.println(k.getNome() + " ");
                }                    
            }
        }
    }    
    
    public void RelatorioOcupacao() throws Exception{
        Scanner ler= new Scanner(System.in);
        System.out.println("Qual espetáculo gostaria de checar ?");
        String escolhido = ler.nextLine();    
        Espetaculo selecionado=null;
        for(Espetaculo k:espetaculos){
            if(escolhido.equals(k.getNome())){
                selecionado=k;
                break;
            }            
        }
        if(selecionado == null) throw new Exception();
        System.out.println("qual apresentacao gostaria ?");
        for( Apresentacao k:selecionado.getApresentacoes()){
            System.out.println(k.getData() + " ");
        }
        Data data = new Data();
        data.insereData();        
        Apresentacao apresentacao = retornaApresentacao(data);
        int i = apresentacao.getSala().numpoltronasVagas();
        int j = apresentacao.getSala().getTotalAssentos();        
        System.out.println(((double)(double)i/(double)j)*100+" % de poltronas livres");
    }
    
    public void RelatorioArrecadacao() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Valor de arrecadacao");
        System.out.println("qual o espetaculo?");
        String nome= ler.nextLine();
        double custo=0;
        Espetaculo espetaculo=null ;
        for(Espetaculo k:espetaculos){
            if(nome.equals(k.getNome())){
                espetaculo = k;
                break;
            }
        }
        if(espetaculo == null){
            try {
                throw new Exception("nao existe apresentacao nessa data");
            } catch (Exception ex) {
                System.out.println(" nao existe nessa data ");
                RelatorioArrecadacao();
            }
        }
        for(Apresentacao j:espetaculo.getApresentacoes()){
            custo += (j.getSala().getTotalAssentos() - 
                    j.getSala().numpoltronasVagas())*espetaculo.getCusto();
        }
        System.out.println("arrecadados: " + custo + " reais." );
    }
    
    public void RelatorioArrecadacaoTipo(Data data){
        Scanner ler = new Scanner(System.in);
        System.out.println("Valor de arrecadacao por tipo");
        System.out.println("qual o nomeAbreviado do tipo de espetaculo?");
        String nome= ler.next();
        double custo=0;
        Espetaculo espetaculo;
        for(Espetaculo k:espetaculos){
            if(nome.equals(k.getTipo().getNomeAbreviado())){
                espetaculo = k;                
                for(Apresentacao j:espetaculo.getApresentacoes()){
                    if(j.getData().getMes() == data.getMes())
                        custo += (j.getSala().getTotalAssentos() - j.getSala().numpoltronasVagas())*espetaculo.getCusto();        
                }
            }
        }                
        System.out.println("custo: " + custo );
    }
    
}
