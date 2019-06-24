package patrick.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cep")
public class Cep implements Serializable {

    public static final int cincoMinutosEmMilisegundos = 300000;

    @Id
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String unidade;
    private String ibge;
    private String gia;
    private Date dataIncl;

    public Cep() {

    }

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

    public String getCep() {
        return cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getIbge() {
        return ibge;
    }

    public String getGia() {
        return gia;
    }

    public Date getDataIncl() {
        return dataIncl;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public void setDataIncl(Date dataIncl) {
        this.dataIncl = dataIncl;
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

    public boolean dataInclValida() {
        return getDataIncl().after(new Date(System.currentTimeMillis() - cincoMinutosEmMilisegundos));
    }
}
