/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketTCP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Bruno
 */
public class Funcao {
    private static final String CAMINHO_DOS_ARQUIVOS = "C:\\Users\\Bruno\\Desktop\\";
    private String[] nomeGabarito = {"Gabarito.txt"};    
    private String[] nomesArquivos = {"Cliente01.txt","Cliente02.txt","Cliente03.txt","Cliente04.txt","Cliente05.txt","Cliente06.txt","Cliente07.txt"};    
    private Socket socket;

    public void enviaArquivo() {
        
        String path = CAMINHO_DOS_ARQUIVOS + nomesArquivos[tipoCliente];

        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        PrintStream ps = new PrintStream(socket.getOutputStream());
        String linha = "";
        while (true) {
            if (linha != null) {
                ps.println(linha);
            } else {
                break;
            }
            linha = buffRead.readLine();
        }
        buffRead.close();

    }

}
