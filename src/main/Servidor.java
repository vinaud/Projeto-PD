package main;



import conexao.ConexaoServidorComando;
import conexao.ConexaoServidorLogin;

public class Servidor {

	
	public static void main(String[] args) { 
		
	ConexaoServidorLogin c1 = new ConexaoServidorLogin();
	ConexaoServidorComando c2 = new ConexaoServidorComando();
	
	c1.start();
	c2.start();
			
	}
}
