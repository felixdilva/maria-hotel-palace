package pi.palace.hotel.maria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.palace.hotel.maria.enums.Status;
import pi.palace.hotel.maria.models.quartos.QuartoMaster;

public interface QuartoMasterRepository extends JpaRepository <QuartoMaster, Long> {
    List<QuartoMaster> findByStatus(Status status);

}
