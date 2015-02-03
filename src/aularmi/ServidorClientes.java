/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aularmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author João
 */
public class ServidorClientes extends UnicastRemoteObject implements InterfaceClienteRemoto {

    private List<Cliente> clientes = new ArrayList<Cliente>();

    protected ServidorClientes() throws RemoteException {
        super();
    }

    @Override
    public void criarCliente(Cliente cliente) throws RemoteException {
        if (this.clientes.contains(cliente)) {
            System.out.println("Cliente já existe!!");
        } else {
            this.clientes.add(cliente);
        }
    }

    @Override
    public List<Cliente> listarClientes() throws RemoteException {
       return this.clientes;
    }

    @Override
    public Cliente getClienteCPF(String cpf) {
        Cliente retorno = null;
        
        Iterator<Cliente> i = this.clientes.iterator();
        
        while( retorno == null && i.hasNext()){
            Cliente c = i.next();
            if (cpf.equalsIgnoreCase(c.getCpf()))
                retorno = c;
            
        }
        
        return null;
    }

}
