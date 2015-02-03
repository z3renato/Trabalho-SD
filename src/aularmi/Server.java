/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aularmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author João
 */
public class Server {
    
    public static void main(String[] args){
        try {
            Registry registry = LocateRegistry.createRegistry(5001);
            ServidorClientes servidorClientes = new ServidorClientes();
            registry.bind("Servidor", servidorClientes);
            System.out.println("Servidor Ativo =)");
         } catch (Exception e) {
             e.printStackTrace();
        }
    }
    
}
