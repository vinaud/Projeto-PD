package conexao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import comando.Reply;
import comando.Request;
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
					if (resultado.equals("aceito"))
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
				FileInputStream down;
				ObjectOutputStream send = new ObjectOutputStream(socket.getOutputStream());
				Request request = new Request(comando);
				
				ObjectInputStream get = new ObjectInputStream(socket.getInputStream());
				Reply reply;
				
				if (comando.equalsIgnoreCase("listar"))
				{
					try {
						send.writeObject(request);
						System.out.println("Requisi��o enviada ao servidor");
						
						reply =(Reply) get.readObject();
						System.out.println("Resposta obtida");
						System.out.println("Arquivos no diret�rio: ");
						ArrayList<File> l = reply.getListagemArquivos();
						
						for(int i = 0; i < l.size();i++)
						{
							System.out.println(l.get(i).getName());
						}
						return reply.getResposta();
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if (comando.equalsIgnoreCase("download"))
				{
					
				}
				else if (comando.equalsIgnoreCase("upload"))
				{
					
				}
				else
				{
					return("ERROW!!!!1!!!! Comando inv�lido");
				}
				
			
				
				
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultado;
			
		}
}
