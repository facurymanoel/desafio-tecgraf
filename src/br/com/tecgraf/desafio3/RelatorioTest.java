package br.com.tecgraf.desafio3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * Testes unitários para o Desafio 3.
 * Valida o filtro de tipo de veículo (Automóvel 'A') e a correta 
 * associação das siglas aos nomes dos países.
 */
class RelatorioTest {

	@Test
	public void deveContarApenasAutomoveis() {
		Relatorio relatorio = new Relatorio();
		List<String> series = Arrays.asList("1920ARGXXA1420-E", "0707BRAXXM1699-9");
		Map<String, String>paisesFake = new HashMap<>();
		paisesFake.put("ARG", "Argentina");
		paisesFake.put("BRA", "Brazil");
		Map<String, Integer> resultado = relatorio.contarAutomoveis(series, paisesFake);
		assertEquals(1, resultado.getOrDefault("Argentina", 0));
		assertFalse(resultado.containsKey("Brazil"));
	}

}
