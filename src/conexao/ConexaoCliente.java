package conexao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import main.Cliente;
import utils.Constantes;

public abstract class ConexaoCliente {

	
	public static boolean login(String username, String senha) {
		Socket socket = null;
				try {
					socket = new Socket("localhost", Constantes.PORTA_LOGIN);
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					Cliente cliente = new Cliente(username, senha);
					oos.writeObject(cliente);
					
					DataInputStream in = new DataInputStream(socket.getInputStream());
					String resultado = in.readUTF();
					
					socket.close();
					if (resultado.equals("true"))
					return true;
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return false;
		
		
	}
	
		public static String execomando(String comando)
		{
			Socket socket = null;
			String resultado = "";
			try {
				socket = new Socket("localhost", Constantes.PORTA_SERVICO);
				
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				DataInputStream in = new DataInputStream(socket.getInputStream());
				FileInputStream down;
				out.writeUTF(comando);
				resultado = in.readUTF();
				
			
				socket.close();
				
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultado;
			
		}
}
