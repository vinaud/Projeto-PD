package conexao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Conexao extends Thread {
	DataInputStream input;
	DataOutputStream output;
	Socket socket;

	public Conexao(Socket socket) {
		try {
			this.socket = socket;
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
			this.start();
		} catch (IOException e) {
			
		}
	}
	
	public void run () {
		
	}
}
