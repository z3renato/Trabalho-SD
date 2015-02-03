/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import static java.lang.System.out;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author João
 */
public class Client {
    
   static String arg[] = {"192.168.0.102", "6789", "Informações do sistema:"+"\n"};
   public static void main(String args[]) {

        Socket s = null;
        try {
            s = new Socket(arg[0], Integer.parseInt(arg[1])); // conecta o socket aa porta remota
            DataInputStream  ent = new DataInputStream(s.getInputStream());
            DataOutputStream sai = new DataOutputStream(s.getOutputStream());
            sai.writeUTF(arg[2]);
            String recebido = ent.readUTF();
            while (recebido != null) {
                System.out.println(recebido);
                recebido = ent.readUTF();
            }
        } catch (UnknownHostException e) {
            System.out.println("Servidor desconhecido: " + e.getMessage());
        } catch (EOFException e) {
            System.out.println("--- FIM DA TRANSFERENCIA ---");
        } catch (IOException e) {
            System.out.println("E/S: " + e.getMessage());
        } finally {
            if (s!=null)
                try {
                    s.close();
                } catch (IOException e){
                    System.out.println("Encerramento do socket falhou: " + e.getMessage());
                }
        }
    }
}
