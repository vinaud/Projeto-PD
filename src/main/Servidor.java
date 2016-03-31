package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import conexao.Conexao;

public class Servidor {

	static int porta = 8787;
	
	public static void main(String[] args) { 
		try {
			ServerSocket servidorSocket = new ServerSocket(porta);
			while(true) {
				Socket cliente = servidorSocket.accept();
				Conexao conexao = new Conexao(cliente);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na porta: " + e.getMessage());
		}
	}

}
