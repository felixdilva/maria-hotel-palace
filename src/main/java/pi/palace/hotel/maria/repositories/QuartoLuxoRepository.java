package pi.palace.hotel.maria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.palace.hotel.maria.enums.Status;
import pi.palace.hotel.maria.models.quartos.QuartoLuxo;
import java.util.List;


public interface QuartoLuxoRepository extends JpaRepository <QuartoLuxo, Long> {
    List<QuartoLuxo> findByStatus(Status status);
}
