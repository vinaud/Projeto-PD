package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import conexao.Conexao;
import utils.Constantes;

public class Servidor {
	
	public static void aceitarLogin() {
		try {
			ServerSocket servidorSocket = new ServerSocket(Constantes.PORTA_LOGIN);
			while(true) {
				Socket cliente = servidorSocket.accept();
				Conexao conexao = new Conexao(cliente);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na porta: " + e.getMessage());
		}
	}
	
	public static void aceitarServico() {
		try {
			ServerSocket servidorSocket = new ServerSocket(Constantes.PORTA_SERVICO);
			while(true) {
				Socket cliente = servidorSocket.accept();
				Conexao conexao = new Conexao(cliente);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na porta: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) { 
		aceitarLogin();
		aceitarServico();
	}

}
