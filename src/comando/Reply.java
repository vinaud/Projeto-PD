package comando;

import java.io.Serializable;
import java.util.List;

public class Reply implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8551985180589119184L;
	private String resposta;
	private String path;
	private List<String> listagemArquivos;
	
	public String getResposta() {
		return resposta;
	}
	public List<String> getListagemArquivos() {
		return listagemArquivos;
	}
	public void setListagemArquivos(List<String> listagemArquivos) {
		this.listagemArquivos = listagemArquivos;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
