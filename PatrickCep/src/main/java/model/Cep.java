package model;

import java.util.Objects;

public class Cep {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String unidade;
    private String ibge;
    private String gia;

    public Cep(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String unidade, String ibge, String gia) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.unidade = unidade;
        this.ibge = ibge;
        this.gia = gia;
    }

    public Cep(String cep){
        this.cep = cep;
    }

    public boolean validaTamanhoCep() {
        return this.cep.length() == 8;
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
                Objects.equals(uf, cep1.uf) &&
                Objects.equals(unidade, cep1.unidade) &&
                Objects.equals(ibge, cep1.ibge) &&
                Objects.equals(gia, cep1.gia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, logradouro, complemento, bairro, localidade, uf, unidade, ibge, gia);
    }

    @Override
    public String toString() {
        return "Cep{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", unidade='" + unidade + '\'' +
                ", ibge='" + ibge + '\'' +
                ", gia='" + gia + '\'' +
                '}';
    }
}
