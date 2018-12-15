/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;

public class Sala implements Serializable{
    private int numSala,totalAssentos,x,y;
    private String descrição;
    private boolean mapaAssentos[][];
    

    public Sala(int numSala, int totalAssentos, String descrição, boolean[][] mapaAssentos) {
        this.numSala = numSala;
        this.totalAssentos = totalAssentos;
        this.descrição = descrição;
        this.mapaAssentos = mapaAssentos;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Sala(int numSala, int totalAssentos,int x,int y, String descrição) {
        this.numSala = numSala;
        this.x=x;
        this.y=y;
        this.totalAssentos = x*y;
        this.descrição = descrição;
        mapaAssentos= new boolean[x][y];
        for(int i=0;i<x;i++)
            for(int j=0;j<y;j++)
                mapaAssentos[i][j]=false;        
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
        final Sala other = (Sala) obj;
        if (this.numSala != other.numSala) {
            return false;
        }
        return true;
    }        

    public int getNumSala() {
        return numSala;
    }

    public int getTotalAssentos() {
        return totalAssentos;
    }

    public String getDescrição() {
        return descrição;
    }

    public boolean[][] getMapaAssentos() {
        return mapaAssentos;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public void setTotalAssentos(int totalAssentos) {
        this.totalAssentos = totalAssentos;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public void setMapaAssentos(boolean[][] mapaAssentos) {
        this.mapaAssentos = mapaAssentos;
    }     
    
    public void imprimeListaPoltronasVagas(){
        for(int i=0; i <this.x;i++ ){
                for(int j=0;j<this.y;j++){
                    if(!mapaAssentos[i][j])
                        System.out.print(i+":"+j+"\t");
                    else
                        System.out.println("X");
                }
                System.out.println();
        }
    }
    
    public int numpoltronasVagas(){
        int vagas=0;
        for(int i=0; i <this.x;i++ ){
                for(int j=0;j<this.y;j++){
                    if(!mapaAssentos[i][j])
                        ++vagas;
                }                               
        }
        return vagas;
    }
    
    public Boolean PoltronasOcupada(int i,int j){
        if(i >=0 && i< x && j >=0 && j< y)
            return mapaAssentos[i][j];
        else 
            throw new RuntimeException();
    }
    
    public void ocupaPoltrona(int i,int j){
        if(i >=0 && i < x && j >=0 && j< y)
            mapaAssentos[i][j]=true;
    }
    
    public void desocupaPoltrona(int i,int j)
    {
        if(i >=0 && i< x && j >=0 && j< y)
            mapaAssentos[i][j]=false;
    }

    
    
    
}
