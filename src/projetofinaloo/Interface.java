
package projetofinaloo;

import Beans.Administrador;
import Beans.Espectador;
import Beans.Usuario;
import Controladores.Controlador;
import Controladores.ControleBackup;
import java.util.Scanner;

public class Interface {          
    public static void main(String[] args) {
        ControleBackup q=new ControleBackup();
        Controlador sistema= q.lerEstado() ;
        Scanner le=new Scanner(System.in);
        Usuario logado = null;        
        System.out.println("Iniciando Sistema de Teatro");
        //sistema.debug();
        Boolean terminarExecutar=false;        
        while(!terminarExecutar){
            do{//f1
                System.out.println("novo Usuario?");
                System.out.println("sim ou nao");
                System.out.println("digite sair para salvar as mudancas");
                System.out.println("Resposta:");
                String opt=le.next();
                if("sim".equals(opt)){
                    logado = sistema.registraUsuario();
                }else{ 
                    if("nao".equals(opt)){
                        System.out.println("digite seu login:");
                        String login= le.next();                    
                        System.out.println("digite sua senha:");
                        String senha= le.next();  
                        try{
                        logado =  sistema.login(login, senha);
                        }catch(Exception e){
                            System.out.println("o erro será notificado ;-(((");
                        }
                    }else{                        
                        q.salvarEstado(sistema);
                        System.exit(0);
                    }
                }
            }while(logado == null);            
            if(logado instanceof Administrador){//f2
                while(!terminarExecutar){
                    System.out.println("1: editar lista de espetaculos ");//f7
                    System.out.println("2: editar lista de salas ");//f5
                    System.out.println("3: editar lista de artistas ");//f6
                    System.out.println("4: editar lista de apresentaçoes ");//f8
                    System.out.println("5: editar Administrador");//extra
                    System.out.println("6: editar lista de tipos de espetaculos ");//f3
                    System.out.println("7: emitir relatorios");//f13                                        
                    System.out.println("0: finalizar programa ");
                    System.out.println("Opção:");
                    switch(le.nextInt()){
                        case 1:{     
                            sistema.editarEspetaculos();
                        break;    
                        }                    
                        case 2:{   
                            sistema.editarSalas();
                        break;
                        }                    
                        case 3:{
                            sistema.editarArtistas();
                            break;
                        }                    
                        case 4:{        
                            sistema.editarApresentacoes();
                            break;
                        }                    
                        case 5:{    
                            sistema.editarAdministrador();
                            break;
                        }      
                        case 6:{
                            sistema.editarTiposEspetaculos();
                            break;
                        }
                        case 7:{
                            sistema.emitirRelatorio();                            
                            break;
                        }
                        default:{                            
                            logado=null;
                            terminarExecutar=true;
                            break;
                        }
                    }                                    
                }
                terminarExecutar=false;
            }else{
                while(!terminarExecutar){
                    System.out.println("1: Modificar suas preferências  ");//f4
                    System.out.println("2: comprar ingressos ");//f9
                    System.out.println("3: consultar espetaculos  ");//f16
                    System.out.println("4: cancelar compra  ");//f12
                    System.out.println("0: Deslogar ");
                    System.out.println("Opção:");
                    switch(le.nextInt()){
                        case 1: { 
                            sistema.modificarPreferencias((Espectador)logado);
                            break;
                        }
                        case 2: {
                            sistema.comprarIngresso((Espectador)logado);
                            break;
                        }
                        case 3: {
                            sistema.consultaEspetaculos();
                            break;
                            }                                                                            
                        case 4: {
                            System.out.println("Cancelar compras");
                            sistema.cancelarCompra((Espectador) logado);                            
                         break;   
                        }                        
                        default: { logado=null;terminarExecutar=true;break;}                    
                    }
                }
                terminarExecutar=false;
            }        
        }        
    }
}
