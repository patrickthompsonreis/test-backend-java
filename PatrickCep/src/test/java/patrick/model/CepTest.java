package patrick.model;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class CepTest {

    @Test
    public void seDataDeInclusaoMaiorQue5MinutosRetornaFalse() {
        Cep cep = new Cep();
        cep.setDataIncl(new Date(System.currentTimeMillis() - 360000));
        assertFalse(cep.dataInclValida());
    }

    @Test
    public void seDataDeInclusaoMenorQue5MinutosRetornaTrue() {
        Cep cep = new Cep();
        cep.setDataIncl(new Date(System.currentTimeMillis() - 120000));
        assertTrue(cep.dataInclValida());
    }
}