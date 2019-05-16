package universe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import universe.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
