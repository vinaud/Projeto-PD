package comando;

import java.io.Serializable;

public class Request implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String path;
	private String comando;

	public Request (String comando)
	{
		this.comando = comando;
	}
	
	public Request (String comando, String path)
	{
		this.comando = comando;
		this.path = path;
	}
	public String getComando() {
		return comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
