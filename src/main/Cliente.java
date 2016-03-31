package main;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static boolean login(String username, String senha) {
		Socket socket = null;
				try {
					socket = new Socket("localhost", 8787);
					
					/*conectar com servidor e fazer o login */
					
					socket.close();
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
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scan= new Scanner(System.in);
		
		System.out.println("Insira o usu�rio");
		String user = scan.nextLine();
		
		System.out.println("Insira a senha");
		String senha = scan.nextLine();
		
		scan.close();
		if (login(user,senha)) {

			
		
		}
		else {
			System.out.println("Usuario ou senha invalido");
		}
	}
}
