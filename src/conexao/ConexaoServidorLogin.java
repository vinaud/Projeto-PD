package conexao;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import persistencia.Usuario;
import utils.Constantes;

public class ConexaoServidorLogin extends Thread {
			
	public void run () {
		try {
			ServerSocket servidorSocket = new ServerSocket(Constantes.PORTA_LOGIN);
			while(true) {
				Socket cliente = servidorSocket.accept();
				ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
				while(true) {
					String resposta = "Aceito";
					Usuario usuario = (Usuario) ois.readObject();
					
					// Verificar se estar no BD
					
					DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
					dos.writeUTF(resposta);
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
