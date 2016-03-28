package main;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Usuario {

	public static boolean login(String username, String senha)
	{
		Socket s = null;
				
				try {
					s = new Socket("localhost", 6789);
					
					/*conectar com servidor e fazer o login */
					
					s.close();
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
		
		System.out.println("Insira o usuário");
		String user = scan.nextLine();
		
		System.out.println("Insira a senha");
		String senha = scan.nextLine();
		
		scan.close();
		if (login(user,senha))
		{

			
		
		}
		else
		{
			System.out.println("Usuario ou senha invalido");
		}
		
	}

}
