package patrick.service;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;
import patrick.model.Cep;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrick.repository.CepRepository;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CepService {

    @Autowired
    private CepRepository cepRepository;

    Logger logger = LoggerFactory.getLogger(CepService.class);

    Moshi moshi = new Moshi.Builder()
            .add(Date.class, new Rfc3339DateJsonAdapter())
            .build();
    JsonAdapter<Cep> cepAdapter = moshi.adapter(Cep.class);

    public CepService(){
    }

    public List<Cep> retornaBanco() {
        return cepRepository.findAll();
    }

    public Cep retornaCep(String cep) throws IOException {

        String cepComSeparador = addSeparador(cep);

        Optional<Cep> possivelCep = cepRepository.findById(cepComSeparador);

        if(possivelCep.isPresent() && possivelCep.get().dataInclApos5Minutos()) {
            logger.info("Encontrou o Cep no banco");
            return possivelCep.get();
        } else {
            logger.info("Nao encontrou o Cep ou Cep est[a vencido");
            Cep novoCep = cepAdapter.fromJson(consultaViaCep(cep));
            novoCep.setDataIncl(new Date());
            cepRepository.saveAndFlush(novoCep);
            return novoCep;
        }
    }

    //Realiza consulta no site viacep
    public String consultaViaCep(String numeroCep) {
        String viaCepUrl = String.format("http://viacep.com.br/ws/%s/json/", numeroCep);
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(viaCepUrl)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String resultado = response.body().string();
            logger.info("Request: {}, Response: {}", request, resultado);
            return resultado;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public String addSeparador(String cep) {
        StringBuilder sb = new StringBuilder(cep);
        sb.insert(5, "-");
        return sb.toString();
    }
}