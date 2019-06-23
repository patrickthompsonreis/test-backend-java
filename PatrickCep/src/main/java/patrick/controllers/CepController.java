package patrick.controllers;

import org.springframework.web.bind.annotation.*;
import patrick.model.Cep;
import org.springframework.beans.factory.annotation.Autowired;
import patrick.repository.CepRepository;
import patrick.service.CepService;

import java.util.List;

@RestController
public class CepController {

    //Service
    @Autowired
    CepService cepService;

    @Autowired
    CepRepository cepRepository;

    @GetMapping("/cep")
    public List<Cep> findAll() {
        return cepRepository.findAll();
    }

    @GetMapping("/cep/{cep}")
    public Cep findByUserId(@PathVariable("cep") String cep) {
        return cepRepository.getOne(cep);
    }

    @PostMapping("/cep")
    public Cep create(@RequestBody Cep cep) {
        return cepRepository.save(cep);
    }
}