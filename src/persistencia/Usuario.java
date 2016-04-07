package persistencia;

import java.io.Serializable;

import utils.Constantes;

public class Usuario implements Serializable {
	/**
	 * 
	 */

	private String username;
	private String senha;
	private int estado;
	
	public Usuario(String username, String senha) {
		this.username = username;
		this.senha = senha;
		 setEstadoDeslogado();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Boolean estarLogado() {
		if (estado == Constantes.LOGADO) {
			return true;
		}
		else {
			return false;
		}
	}

	public void setEstadoLogado() {
		this.estado=Constantes.LOGADO;
	}
	
	public void setEstadoDeslogado() {
		this.estado=Constantes.DESLOGADO;
	}

}
