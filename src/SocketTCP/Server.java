/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketTCP;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author João
 */
public class Server {

    public static void main(String args[]) {
        try {
            int porta = 6789; // porta do serviço
            if (args.length > 0) {
                porta = Integer.parseInt(args[0]);
            }
            ServerSocket escuta = new ServerSocket(porta);
            System.out.println("*** Servidor ***");
            System.out.println("*** Inicio - porta de escuta (listen): " + porta);
            while (true) {
                // accept bloqueia ateh que chegue um pedido de conexao de um cliente
                // qdo chega, cria um novo socket = cliente
                Socket cliente = escuta.accept();
                System.out.println("*** Socket de escuta (listen): " + escuta.getLocalSocketAddress().toString());
                System.out.println("*** Conexao aceita de (remoto): " + cliente.getRemoteSocketAddress().toString());
                // quando chega, cria nova thread para atender em especial o cliente
                Conexao c = new Conexao(cliente);
          //      Consulta l = new Consulta();
             //   String resposta = l.fazConsulta();
              //  System.out.println(resposta);
            }
        } catch (IOException e) {
            System.out.println("Erro na escuta: " + e.getMessage());
        }
    }
}
