package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CepTest {

    @Test
    public void umCepDeveTerOitoDigitos(){
        Cep cep = new Cep("12345678");
        assertTrue(cep.validaTamanhoCep());
    }

    @Test
    public void deveRetornarFalsoSeOCepForMenorQueOitoDigitos(){
        Cep cep = new Cep("1234");
        assertFalse(cep.validaTamanhoCep());
    }

    @Test
    public void deveRetornarFalseSeOCepForMaiorQueOitoDigitos() {
        Cep cep = new Cep("1234567890");
        assertFalse(cep.validaTamanhoCep());
    }

    @Test
    public void cepsComValoresIguaisDevemSerIguais() {
        Cep cep1 = new Cep("A", "1", "C", "3", "E", "5", "ola", "", "");
        Cep cep2 = new Cep("A", "1", "C", "3", "E", "5", "ola", "", "");
        assertEquals(cep1, cep2);
    }
}