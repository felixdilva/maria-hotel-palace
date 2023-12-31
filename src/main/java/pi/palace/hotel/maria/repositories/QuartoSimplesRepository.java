package pi.palace.hotel.maria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.palace.hotel.maria.enums.Status;
import pi.palace.hotel.maria.models.quartos.QuartoSimples;

public interface QuartoSimplesRepository extends JpaRepository <QuartoSimples, Long> {
        List<QuartoSimples> findByStatus(Status status);

}
