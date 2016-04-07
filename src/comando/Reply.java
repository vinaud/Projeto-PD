package comando;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Reply implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8551985180589119184L;
	private String resposta;
	private String path;
	private ArrayList<File> listagemArquivos;
	
	public String getResposta() {
		return resposta;
	}
	public ArrayList<File> getListagemArquivos() {
		return listagemArquivos;
	}
	public void setListagemArquivos(ArrayList<File> listaArquivos) {
		this.listagemArquivos = listaArquivos;
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
