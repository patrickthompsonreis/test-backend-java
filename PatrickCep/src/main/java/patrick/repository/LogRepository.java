package patrick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import patrick.model.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

}
