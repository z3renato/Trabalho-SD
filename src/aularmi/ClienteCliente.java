/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aularmi;

import java.rmi.Naming;
import java.util.List;

/**
 *
 * @author João
 */
public class ClienteCliente {

    public static void main(String[] args) {

        try {
            InterfaceClienteRemoto repo = (InterfaceClienteRemoto) Naming.lookup("rmi://localhost:5001/Servidor");
                      
            System.out.println("Conectado ao servidor.");
            
            
            Cliente cliente = new Cliente("ze", "11731640650");
            System.out.println("Cadastrando Cliente: "+ cliente.getNome()+ " CPF: "+cliente.getCpf());
            repo.criarCliente(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
            
            Cliente cliente2 = new Cliente("Antonio", "2222222");
            System.out.println("Cadastrando Cliente: "+ cliente2.getNome()+ " CPF: "+cliente2.getCpf());
            repo.criarCliente(cliente2);
            System.out.println("Cliente cadastrado com sucesso!");
                            
            
            System.out.println("Lista de clientes:");
            
            List<Cliente> clientes = repo.listarClientes();
            
            for(Cliente c : clientes){
                System.out.println("Cliente: " + c.getNome() + "CPF:" +c.getCpf() );                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
