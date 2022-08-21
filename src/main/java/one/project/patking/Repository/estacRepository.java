package one.project.patking.Repository;

import one.project.patking.Model.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface estacRepository extends JpaRepository<Estacionamento, Long> {
    List<Estacionamento> findByLicenca(String licenca);

}
