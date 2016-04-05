package conexao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import comando.Reply;
import comando.Request;
import persistencia.Usuario;
import utils.Constantes;

public class ConexaoServidorComando extends Thread {
	
	public void run () {
		try {
			@SuppressWarnings("resource")
			ServerSocket servidorSocket = new ServerSocket(Constantes.PORTA_SERVICO);
			while(true) {
				Socket cliente = servidorSocket.accept();
				ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
				ObjectOutputStream dos = new ObjectOutputStream(cliente.getOutputStream());
				while(true) {
					Request request = (Request) ois.readObject();
					if(request.getComando().equals("listar")) {
						Reply reply = new Reply();
						
						dos.writeObject(reply);
					} else if (request.getComando().equals("download")) {
						
					} else {
						
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na porta: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
