package pi.palace.hotel.maria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.palace.hotel.maria.models.User;
import java.util.List;
import pi.palace.hotel.maria.enums.Papel;


public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByPapel(Papel papel);
}
