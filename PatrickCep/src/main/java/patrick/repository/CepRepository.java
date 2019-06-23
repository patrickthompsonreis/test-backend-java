package patrick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import patrick.model.Cep;

public interface CepRepository extends JpaRepository<Cep, String> {
}
