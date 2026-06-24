package br.com.tecgraf.desafio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo Desafio 2: Verificação de Dígito Verificador (DV).
 * Valida se o dígito informado no final da série coincide com o cálculo
 * baseado na soma dos valores ASCII e módulo 16.
 * * @author Manoel Dalmo
 */
public class VerificarDV {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("arquivos", "serieParaVerificar.txt");
		List<String> linhas = Files.readAllLines(path);
		List<String> linhasVerificadas = new ArrayList<>();

		for (String linha : linhas) {
			boolean valido = validarSerie(linha);

			if (valido) {
				linhasVerificadas.add(linha + " verdadeiro");
			} else {
				linhasVerificadas.add(linha + " falso");
			}
		}

		Path pathSaida = Paths.get("arquivos", "serieVerificada.txt");
		Files.write(pathSaida, linhasVerificadas);

	}
   
	/**
	 * Realiza a validação da série comparando o dígito informado com o calculado.
	 * @param linha String completa contendo a série e o dígito
	 * @return boolean True se o dígito calculado for igual ao informado.
	 */
	public static boolean validarSerie(String linha) {
		 int soma, resto;
		 String dvCalculado;
		 
		 String serieSemDV = linha.substring(0, linha.length() -2);
		 String dvInformado = linha.substring(linha.length() -1);
		 soma = 0;
		 
		 for (char c : serieSemDV.toCharArray()) {
			    soma += c;
		}
		 
		 resto = soma % 16;
		 dvCalculado = Integer.toHexString(resto).toUpperCase();
		 
		 return dvCalculado.equals(dvInformado);
	}

}
