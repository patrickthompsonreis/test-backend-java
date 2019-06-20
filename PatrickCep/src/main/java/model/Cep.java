package model;

import java.util.Objects;

public class Cep {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public Cep(String cep, String logradouro, String complemento, String bairro, String localidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public Cep(String cep){
        this.cep = cep;
    }

    public boolean validaTamanhoCep() {
        if(this.cep.length() == 8){
            return true;
        } else {
            return false;
        }
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cep cep1 = (Cep) o;
        return Objects.equals(cep, cep1.cep) &&
                Objects.equals(logradouro, cep1.logradouro) &&
                Objects.equals(complemento, cep1.complemento) &&
                Objects.equals(bairro, cep1.bairro) &&
                Objects.equals(localidade, cep1.localidade) &&
                Objects.equals(uf, cep1.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, logradouro, complemento, bairro, localidade, uf);
    }

    //Escrita das informações do CEP
    @Override
    public String toString() {
        return "Cep{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
