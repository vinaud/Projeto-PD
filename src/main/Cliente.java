package main;

import java.util.Scanner;

import conexao.ConexaoCliente;

public class Cliente {

	public Cliente(String username, String senha) {
		
	}

	
		
	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
		String user ="";
		String senha ="";
		
		while (!ConexaoCliente.login(user,senha))
		{
			System.out.println("Insira o usuario");
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
			result = ConexaoCliente.execomando(comando);
			
			System.out.println("Resultado da operação de "+ comando + " : \n" + result);
			
			}
			
		
		
	}
}
