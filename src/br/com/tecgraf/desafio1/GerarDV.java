package br.com.tecgraf.desafio1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo Desafio 1: Geração de Dígito Verificador (DV).
 * Lê séries incompletas e gera o diferencial baseado na tabela ASCII.
 * * @author Manoel Dalmo
 */
public class GerarDV {

	public static void main(String[] args) throws IOException {
		GerarDV app = new GerarDV();
		Path path = Paths.get("arquivos", "serieSemDV.txt");
		List<String> linhas = Files.readAllLines(path);
		List<String> linhasComDv = new ArrayList<>();

		for (String linha : linhas) {
			String dv = app.calcularDiferencial(linha);
			linhasComDv.add(linha + "-" + dv);
		}

		Path pathSaida = Paths.get("arquivos", "serieComDV.txt");
		Files.write(pathSaida, linhasComDv);

	}

	public String calcularDiferencial(String linha) {
		int soma = 0;
		for (char c : linha.toCharArray()) {
			soma += c;
		}
		int resto = soma % 16;
		return Integer.toHexString(resto).toUpperCase();

	}

}
