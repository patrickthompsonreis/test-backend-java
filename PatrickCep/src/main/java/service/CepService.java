package service;

import model.Cep;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CepService {

    @Autowired
    CepDB cepDB;

    Logger logger = LoggerFactory.getLogger(CepService.class);

    public CepService(){

    }

    public boolean existeCepNoBanco(String cep){
        return cepDB.existeCep(cep);
    }

    public Cep retornaCep(String cep){
        return cepDB.consultaCep(cep);
    }

    public void iniciaBanco(){
        cepDB.criaExemplos();
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
}
