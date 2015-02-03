/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ExecutarClientes implements Runnable{
    
    private Socket cliente;
    private Scanner s;
    private String name;
    
    public ExecutarClientes(Socket cliente,String name){
        this.cliente = cliente;
        this.name = name;
        try {
            s = new Scanner(cliente.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ExecutarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while(s.hasNextLine()){
            String linha = s.nextLine();
            String[] desmontarLinha = linha.split(";");
            System.out.println(linha);
        }
    }
    
    public void verificarQuestoes(){
        
    }
    
}
