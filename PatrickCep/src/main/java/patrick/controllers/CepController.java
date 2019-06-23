package patrick.controllers;

import patrick.model.Cep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import patrick.service.CepService;

import java.io.IOException;
import java.util.HashMap;

@RestController
public class CepController {

    //Service
    @Autowired
    CepService cepService;

    //Construção do CEP
    @RequestMapping("/cep")
    public Cep cep(@RequestParam(value="numeroCep") String numeroCep) {
        if(cepService.existeCepNoBanco(numeroCep)){
            return cepService.retornaCep(numeroCep);
        } else {
            String cepDoSiteViaCep = cepService.consultaViaCep(numeroCep);
            try {
                cepService.insereCep(cepDoSiteViaCep);
            } catch (IOException e) {

            }
            return cepService.retornaCep(numeroCep);
        }
    }

    @RequestMapping("/iniciaBanco")
    public String iniciaBanco(){
        cepService.iniciaBanco();
        return "O banco de dados foi iniciado com 3 CEP";
    }

    @RequestMapping("/banco")
    public HashMap<String, Cep> banco() {
        return cepService.retornaBanco();
    }
}