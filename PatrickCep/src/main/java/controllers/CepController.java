package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.CepService;

@RestController
public class CepController {

    //Service
    @Autowired
    CepService cepService;

    //Construção do CEP
    @RequestMapping("/cep")
    public String cep(@RequestParam(value="numeroCep") String numeroCep) {
        if(cepService.existeCepNoBanco(numeroCep)){
            return cepService.retornaCep(numeroCep).toString();
        } else {
            return cepService.consultaViaCep(numeroCep);
        }
    }

    @RequestMapping("/iniciaBanco")
    public String iniciaBanco(){
        cepService.iniciaBanco();
        return "O banco de dados foi iniciado com 3 CEP";
    }
}