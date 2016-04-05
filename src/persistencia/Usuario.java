package persistencia;

import java.io.Serializable;

import utils.Constantes;

public class Usuario implements Serializable {
	private String username;
	private String senha;
	private Estado estado;
	
	public Usuario(String username, String senha) {
		this.username = username;
		this.senha = senha;
		estado.setEstado(Constantes.DESLOGADO);
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
		if (estado.getEstado() == Constantes.LOGADO) {
			return true;
		}
		else {
			return false;
		}
	}

	public void setEstadoLogado() {
		estado.setEstado(Constantes.LOGADO);
	}
	
	public void setEstadoDeslogado() {
		estado.setEstado(Constantes.DESLOGADO);
	}

}
