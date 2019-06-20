package service;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import model.Cep;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

@Service
public class CepService {

    @Autowired
    CepDB cepDB;

    Logger logger = LoggerFactory.getLogger(CepService.class);

    Moshi moshi = new Moshi.Builder().build();
    JsonAdapter<Cep> cepAdapter = moshi.adapter(Cep.class);

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

    public HashMap<String,Cep> retornaBanco() {
        return this.cepDB.getDb();
    }

    public void insereCep(String cep) throws IOException {
        Cep novoCep = cepAdapter.fromJson(cep);
        this.cepDB.insereCep(novoCep.getCep().replace("-", ""), novoCep);
    }
}
