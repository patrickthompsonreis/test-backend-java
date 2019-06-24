package patrick.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class CepServiceTest {

    @Test
    public void deveInserirSeparadorNoLocalCorreto() {
        String cepSemSeparador = "29101110";
        String cepComSeparador = "29101-110";

        CepService cepService = new CepService();

        assertEquals(cepComSeparador, cepService.addSeparador(cepSemSeparador));
    }

}