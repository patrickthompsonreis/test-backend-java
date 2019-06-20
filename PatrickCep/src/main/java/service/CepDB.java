package service;

import model.Cep;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CepDB {

    private HashMap<String, Cep> banco;

    public CepDB() {
        this.banco = new HashMap<>();
    }

    public Cep consultaCep(String Cep){
        return this.banco.get(Cep);
    }

    public void insereCep(String valorDoCep, Cep informacoesDoCep) {
        this.banco.put(valorDoCep, informacoesDoCep);
    }

    public void criaExemplos() {
        this.banco.put("29781555", new Cep("29781555", "Rua 1", "casa", "Bairro A", "Vila Velha", "ES"));
        this.banco.put("30500123", new Cep("30500123", "Rua 40", "apto 303", "Bairro Nobre", "Vitoria", "ES"));
        this.banco.put("77888999", new Cep("77888999", "Rua Nova", "s/n", "Bairro Central", "São Paulo", "SP"));
    }

    public boolean existeCep(String cep) {
        return this.banco.containsKey(cep);
    }
}
