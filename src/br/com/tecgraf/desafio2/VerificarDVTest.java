package br.com.tecgraf.desafio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Testes unitários para o Desafio 2.
 * Valida a consistência entre o Dígito Verificador (DV) informado 
 * e o cálculo baseado na série de caracteres.
 */
class VerificarDVTest {

	@Test
	public void deveValidarSerieCorreta() {
		String serieValida = "A-1";
		assertTrue(VerificarDV.validarSerie(serieValida), "Deveria retornar verdadeiro para A-1");
		
	}
	
	@Test
	public void deveRejeitarSerieIncorreta() {
		String serieInvalida = "A-2";
		assertFalse(VerificarDV.validarSerie(serieInvalida), "Deveria validar corretamente o dígito A-2");
	}
	
	@Test
	public void deveValidarHexadecimalLetra() {
		String serieHex = "?-F";
		assertTrue(VerificarDV.validarSerie(serieHex), "Deveria validar corretamente o dígito F");
	}

}
