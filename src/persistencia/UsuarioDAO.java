package persistencia;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
	
	private List<Usuario> usuarios= new ArrayList<Usuario>();
	
	public UsuarioDAO() {
		Usuario user1 = new Usuario("user1", "1234");
		Usuario user2 = new Usuario("user2", "1234");
		
		 
		
		usuarios.add(user1);
		usuarios.add(user2);
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
