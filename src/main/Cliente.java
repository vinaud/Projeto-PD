package main;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import persistencia.Usuario;
import utils.Constantes;

public class Cliente {

	public static boolean login(String username, String senha) {
		Socket socket = null;
			try {
				socket = new Socket("localhost", Constantes.PORTA_LOGIN);
				ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
				Usuario usuario = new Usuario(username, senha);
				outputStream.writeObject(usuario);
				
				socket.close();
				return true;
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						System.out.println("Falha ao fechar o socket: " + e.getMessage());
					}
				}
			}
			
		return false;
	}
	
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scan= new Scanner(System.in);
		
		System.out.println("Insira o usu�rio");
		String usuario = scan.nextLine();
		
		System.out.println("Insira a senha");
		String senha = scan.nextLine();
		
		scan.close();
		if (login(usuario,senha)) {
			System.out.println("Bem-vindo!");
		}
		else {
			System.out.println("Usuario ou senha invalido");
		}
	}
}
