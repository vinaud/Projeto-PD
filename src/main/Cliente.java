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
	
		public static String execomando(String comando)
		{
			return comando;
			
		}
		
	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
		String user ="";
		String senha ="";
		
		while (!login(user,senha))
		{
			System.out.println("Insira o usuï¿½rio");
			 user = scan.nextLine();
			
			System.out.println("Insira a senha");
			 senha = scan.nextLine();
			
			scan.close();
			
			
			
			System.out.println("Usuario ou senha invalido");
		}
		
		String comando = "";
		
			while (!comando.equalsIgnoreCase("sair"))
			{
				
			System.out.println("Insira Listar, Download ou Sair");
			comando = scan.nextLine();
			
			String result;
			result = execomando(comando);
			
			System.out.println("Resultado da operação: \n" + result);
			
			}
			
		
		
	}
}
