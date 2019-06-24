package patrick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrick.model.Log;
import patrick.repository.LogRepository;

import java.util.Date;
import java.util.List;

@Service
public class LogService {

    @Autowired
    LogRepository logRepository;

    public LogService() {

    }

    public List<Log> retornaBanco() {
        return logRepository.findAll();
    }

    public void insereLog(String request, String response) {
        Log log = new Log();
        log.setRequest(request);
        log.setResponse(response);
        log.setDtIncl(new Date());

        logRepository.saveAndFlush(log);
    }
}
