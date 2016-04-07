package main;

import java.io.Serializable;
import java.util.Scanner;

import conexao.ConexaoCliente;

public class Cliente implements Serializable {

	public Cliente(String username, String senha) {
		
	}

	
		
	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
		String user ="";
		String senha ="";
		boolean logado = false;
		do
		{
			System.out.println("Insira o usuario");
			 user = scan.nextLine();
			
			System.out.println("Insira a senha");
			 senha = scan.nextLine();
			
			logado = ConexaoCliente.login(user,senha);
			if(!logado)
			{
			System.out.println("Usuario ou senha invalido");
			}
			
		}while (!logado);
		
		System.out.println("Login efetuado com sucesso");
		String comando = "";
		
			while (!comando.equalsIgnoreCase("sair"))
			{
				
			System.out.println("Insira Listar, Download ou Sair");
			comando = scan.nextLine();
			
			String result;
			result = ConexaoCliente.execomando(comando);
			
			System.out.println("Resultado da operação de "+ comando + " : \n" + result);
			
			}
			
			scan.close();
			
		
		
	}
}