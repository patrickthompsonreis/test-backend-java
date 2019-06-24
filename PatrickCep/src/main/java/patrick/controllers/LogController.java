package patrick.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import patrick.model.Log;
import patrick.service.LogService;

import java.util.List;

@RestController
public class LogController {

    @Autowired
    LogService logService;

    @GetMapping("/log")
    public List<Log> findAll() {
        return logService.retornaBanco();
    }
}
