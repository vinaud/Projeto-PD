package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class LeitorDiretorios {

	private File diretorio1;
	private File diretorio2;
		
	public LeitorDiretorios(File diretorio1, File diretorio2) {
		this.diretorio1 = diretorio1;
		this.diretorio2 = diretorio2;
	}
	
	public void capturarDiferencas(File diretorio1, File diretorio2) throws IOException {
		File[] listaArquivos1 = diretorio1.listFiles();
		File[] listaArquivos2 = diretorio2.listFiles();
		
		Arrays.sort(listaArquivos1);
		Arrays.sort(listaArquivos2);
		HashMap<String, File> hashMap;
		hashMap = new HashMap<String, File>();
		
		if(listaArquivos1.length < listaArquivos2.length) {
			for(int i = 0; i < listaArquivos1.length; i++) {
				hashMap.put(listaArquivos1[i].getName(), listaArquivos1[i]);
			}
			comparar(listaArquivos2, hashMap);
		} else {
			for(int i = 0; i < listaArquivos2.length; i++) {
				hashMap.put(listaArquivos2[i].getName(), listaArquivos2[i]);
			}
			comparar(listaArquivos1, hashMap);
		}
	}
	
	public void comparar(File[] listaArquivo, HashMap<String, File> hashMap) throws IOException {
		for(int i = 0; i < listaArquivo.length; i++) {
			String nomeArquivo = listaArquivo[i].getName();
			File arquivo = hashMap.get(nomeArquivo);
			hashMap.remove(nomeArquivo);
			
			if(arquivo != null) {
				if(arquivo.isDirectory()) {
					capturarDiferencas(listaArquivo[i], arquivo);
				} else {
					String checksum1 = checksum(listaArquivo[i]);
					String checksum2 = checksum(arquivo);
					if(!checksum1.equals(checksum2)) {
						System.out.println(listaArquivo[i].getName()+"\t\t"+ "diferente");
					} else {
						System.out.println(listaArquivo[i].getName()+"\t\t"+ "igua");
					}
				}
			} else {
				if(listaArquivo[i].isDirectory()) {
					percorrerDiretorio(listaArquivo[i]);
				} else {
					System.out.println(listaArquivo[i].getName()+"\t\t"+"apenas em "+ listaArquivo[i].getParent());
				}
			}
		}
		
		Set<String> set = hashMap.keySet();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String n = it.next();
			File arquivoHashMap = hashMap.get(n);
			hashMap.remove(n);
			if(arquivoHashMap.isDirectory()) {
				percorrerDiretorio(arquivoHashMap);
			} else {
				System.out.println(arquivoHashMap.getName() +"\t\t"+"apenas em "+ arquivoHashMap.getParent());
			}
		}
	}
	
	public void percorrerDiretorio(File diretorio) {
		File[] list = diretorio.listFiles();
		for(int k=0;k<list.length;k++)
		{
			if(list[k].isDirectory())
			{
				percorrerDiretorio(list[k]);
			}
			else
			{
				System.out.println(list[k].getName() +"\t\t"+"apenas em "+ list[k].getParent());
			}
		}
		
	}

	public String checksum(File arquivo) {
		try {
		    InputStream fin = new FileInputStream(arquivo);
		    java.security.MessageDigest md5er = MessageDigest.getInstance("MD5");
		    byte[] buffer = new byte[1024];
		    
		    int read;
		    do {
		    	read = fin.read(buffer);
		    	if (read > 0)
		    		md5er.update(buffer, 0, read);
		    } while (read != -1);
		    fin.close();
		    byte[] digest = md5er.digest();
		    if (digest == null)
		      return null;
		    String strDigest = "0x";
		    for (int i = 0; i < digest.length; i++)  {
		    	strDigest += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1).toUpperCase();
		    }
		    return strDigest;
		} 
		catch (Exception e) {
		    return null;
		}
	}
	
	
	
	public void listarDiretorio(String nomeDiretorio, ArrayList<File> arquivos) {
		File diretorio = new File(nomeDiretorio);
		File[] listaArquivos = diretorio.listFiles();
		
		for(File arquivo : listaArquivos) {
			if(arquivo.isFile()) {
				arquivos.add(arquivo);
			} else if (arquivo.isDirectory()){
				listarDiretorio(arquivo.getAbsolutePath(), arquivos);
			}
		}
	}
	
	public void adicionarArquivo(Path caminho, File arquivo) {
		
	}
	
	public void removerArquivo(Path caminho, File arquivo) {
		
	}
	
	public void atualizarArquivo(Path caminho, File arquivo) {
		
	}

	public File getDiretorio1() {
		return diretorio1;
	}

	public void setDiretorio1(File diretorio1) {
		this.diretorio1 = diretorio1;
	}

	public File getDiretorio2() {
		return diretorio2;
	}

	public void setDiretorio2(File diretorio2) {
		this.diretorio2 = diretorio2;
	}


		
}
