/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Data implements Serializable{
    int dia,mes,ano,hora;

    public Data(int dia, int mes, int ano, int hora) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public Data(int mes, int ano) {
        this.mes = mes;
        this.ano = ano;
    }

    public Data() {
    }
    
    

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Data: \n" + this.hora +" " +this.dia + " " + this.mes + " " + this.ano ;
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
        final Data other = (Data) obj;
        if (this.dia != other.dia) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        if (this.ano != other.ano) {
            return false;
        }
        if (this.hora != other.hora) {
            return false;
        }
        return true;
    }

   
    
    public void insereData(){
            Scanner ler=new Scanner(System.in);        
            try{
            System.out.println("Dia:");                                    
            String aux = ler.next();
            this.dia = Integer.parseInt(aux);
            System.out.println("Mes:");
             aux = ler.next();
            this.mes = Integer.parseInt(aux);
            System.out.println("Ano:");            
             aux = ler.next();
            this.ano = Integer.parseInt(aux);
            System.out.println("Horário:");
            this.hora=ler.nextInt();        
            }catch(NumberFormatException e){
                insereData();
            }
    }
    
}
