/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aularmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


/**
 *
 * @author João
 */
public interface InterfaceClienteRemoto extends Remote{
    
    void criarCliente(Cliente cliente) throws RemoteException;
    
    List<Cliente> listarClientes() throws RemoteException;
    
    Cliente getClienteCPF(String cpf) throws RemoteException;
    
}
