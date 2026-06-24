package br.com.tecgraf.desafio1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Testes unitários para a lógica de geração de Dígito Verificador (Desafio 1).
 * Garante que a soma ASCII e a conversão hexadecimal estão operando conforme o esperado.
 */
class GerarDVTest {

	@Test
	public void deveCalcularDVCorretamente() {
		GerarDV gerador = new GerarDV();
		
		String serieTeste = "A";
		String dvEsperado = "1";
		
		String dvResultado = gerador.calcularDiferencial(serieTeste);
		
		assertEquals(dvEsperado, dvResultado, "O cálculo do DV para 'A' deveria ser 1");
	}
	 
}
