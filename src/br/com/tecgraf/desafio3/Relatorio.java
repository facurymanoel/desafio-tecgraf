package br.com.tecgraf.desafio3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *Classe responsável pelo Desafio 3: Gera um relatório onde são válidos apenas 
 *séries com os países com o caracter A de automóvel
 *Valida apenas series de paises com seus respectivos nomes onde é gerado uma lista
 *filtrada apenas com automoveis
 *@author Manoel Dalmo
 */
public class Relatorio {

	public static void main(String[] args) throws IOException {
		Relatorio app = new Relatorio();
		Path pathPaises = Paths.get("arquivos", "paises.txt");
		Map<String, String> mapaPaises = new HashMap<>();
		List<String> linhas = Files.readAllLines(pathPaises);
		
		for (String linha : linhas) {
			 if(!linha.isEmpty()) {
				  String partes[] = linha.split(";");
				  if(partes.length >= 2) {
					  mapaPaises.put(partes[0].trim(), partes[1].trim());
				  }
			 }
		}
		
		Path pathRelatorio = Paths.get("arquivos", "serieParaRelatorio.txt");
		List<String> series = Files.readAllLines(pathRelatorio);
		
		Map<String, Integer> contagemPorPais = 
				     app.contarAutomoveis(series, mapaPaises);
		
		List<String> linhasSaida = new ArrayList<>();
		
		for (Map.Entry<String, Integer> entry : contagemPorPais.entrySet()) {
			  
			linhasSaida.add(entry.getKey() + "=" + entry.getValue());
		}
		
		Path pathSaida = Paths.get("arquivos", "listaTotais.txt");
		Files.write(pathSaida, linhasSaida);
		 

	}
	
	/**
	 * Processa uma lista de séries e retorna a contagem consolidada por país.
	 * Filtra apenas registros onde o 10º caractere é 'A' (Automóvel).
	 * * @param series Lista de strings com os códigos das séries.
	 * @param mapaPaises Mapa de referência para conversão de sigla em nome.
	 * @return Map ordenado alfabeticamente (TreeMap) com Totais por País.
	 */
     public Map<String, Integer> contarAutomoveis(List<String> series, Map<String, String> mapaPaises) {
		 
    	 Map<String, Integer> contagem = new TreeMap<>();
    	 
    	 for (String serie : series) {
			if(serie.length() >= 10 && serie.charAt(9) == 'A') {
				String sigla = serie.substring(4,7);
				String nomePais = mapaPaises.get(sigla);
				if(nomePais != null) {
					contagem.put(nomePais, contagem.getOrDefault(nomePais, 0) + 1);
				}
			}
		}
		return contagem;
	}

}
