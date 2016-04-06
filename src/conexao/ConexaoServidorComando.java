package conexao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import arquivos.LeitorDiretorios;
import comando.Reply;
import comando.Request;
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
					Reply reply = new Reply();
					if(request.getComando().equals("listar")) {
						
					reply.setListagemArquivos(LeitorDiretorios.listagemArquivos(request.getPath()));	
					reply.setResposta("ok");
						
					} else if (request.getComando().equals("download")) {
						
					} else if (request.getComando().equals("upload")){
						
					}
					dos.writeObject(reply);
					System.out.println("Resposta enviada ao cliente");
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
