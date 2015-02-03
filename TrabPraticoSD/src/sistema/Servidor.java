/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class Servidor {
    
    private ServerSocket ss;
    
    public Servidor(){
        try {
            ss = new ServerSocket(5001);
            System.out.println("Servidor Iniciado!");
            iniciar();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void iniciar() throws IOException{
        while(true){
            Socket cliente = ss.accept();
            new Thread(new ExecutarClientes(cliente,"Bruno")).start();
        }
    }
    
    public static void main(String[] args) {
        new Servidor();
    }
}
