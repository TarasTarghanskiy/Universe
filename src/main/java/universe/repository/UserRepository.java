package universe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import universe.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity getUserEntityByUsername(String name);
    UserEntity findByUsername(String name);
    UserEntity findById(long id);
}
