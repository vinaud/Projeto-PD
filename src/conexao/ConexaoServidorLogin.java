package conexao;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import persistencia.Usuario;
import persistencia.UsuarioDAO;
import utils.Constantes;

public class ConexaoServidorLogin extends Thread {
			
	private ServerSocket servidorSocket;

	public void run () {
		try {
			servidorSocket = new ServerSocket(Constantes.PORTA_LOGIN);
			while(true) {
				Socket cliente = servidorSocket.accept();
				ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
				while(true) {
					String resposta = "recusado";
					Usuario usuario;
					 usuario = (Usuario) ois.readObject();
					
					UsuarioDAO userDAO = new UsuarioDAO();
					List<Usuario> listUser = userDAO.getUsuarios();
					
					for(int i = 0; i < listUser.size(); i++) {
						if(usuario.getUsername().equals(listUser.get(i).getUsername()) 
								&& usuario.getSenha().equals(listUser.get(i).getSenha())) {
							resposta = "aceito";
						}
					}
					
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
