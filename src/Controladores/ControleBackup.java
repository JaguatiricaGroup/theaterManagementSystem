/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabrieldias
 */
public class ControleBackup implements Serializable{
    
    public void salvarEstado(Controlador sistema ) {
        FileOutputStream f_out = null;
        try {
            // Write to disk with FileOutputStream
            f_out = new 
                FileOutputStream("Backup.Teatro");
            // Write object with ObjectOutputStream
            ObjectOutputStream obj_out = new
                ObjectOutputStream (f_out);
            // Write object out to disk
            obj_out.writeObject ( sistema );
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f_out.close();
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Controlador lerEstado() {
        // Read from disk using FileInputStream
        try {
            FileInputStream f_in = new FileInputStream("Backup.Teatro");
            ObjectInputStream obj_in = new ObjectInputStream (f_in);
            Controlador obj = (Controlador) obj_in.readObject();            
            return obj;
        } catch (FileNotFoundException e) {
            System.out.println("nao achei o arquivo");
            return new Controlador();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }            
        return new Controlador();
    }
}
