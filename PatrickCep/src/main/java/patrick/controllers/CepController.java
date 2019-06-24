package patrick.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import patrick.model.Cep;
import org.springframework.beans.factory.annotation.Autowired;
import patrick.service.CepService;

import java.io.IOException;
import java.util.List;

@RestController
public class CepController {

    //Service
    @Autowired
    CepService cepService;

    Logger logger = LoggerFactory.getLogger(CepService.class);

    @GetMapping("/cep")
    public List<Cep> findAll() {
        return cepService.retornaBanco();
    }

    @GetMapping("/cep/{cep}")
    public Cep findByCep(@PathVariable("cep") String cep) {
        try {
            return cepService.retornaCep(cep);
        } catch (IOException e) {
            logger.warn("Erro retornando o Cep");
            return null;
        }
    }
}