package patrick.service;

import patrick.model.Cep;
import org.junit.Test;

import static org.junit.Assert.*;

public class CepDBTest {
    private CepDB bancoTeste = new CepDB();
    private Cep cepDoPatrick = new Cep("29780000", "Rua A", "apto 1", "Bairro Modelo", "Sao Diego do Java", "ES", "", "", "");
    Cep cepDoDiego = new Cep("12345678", "Rua do Metal", "casa", "bairro Darkness", "Colonia", "kl", "", "", "");

    @Test
    public void retornaOCepSeExistir(){
        this.bancoTeste.insereCep("29780000", cepDoPatrick);
        Cep cepRetiradoDoBanco = bancoTeste.consultaCep("29780000");
        assertEquals("Rua A", cepRetiradoDoBanco.getLogradouro());
        assertEquals(cepDoPatrick,cepRetiradoDoBanco);
    }

    @Test
    public void criaExemplosDeveRetornarCep() {
        CepDB cepDB = new CepDB();
        cepDB.criaExemplos();
        Cep cepRetiradoDoBanco = cepDB.consultaCep("29781555");
        assertEquals("Rua 1", cepRetiradoDoBanco.getLogradouro());
    }
}