package universe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import universe.entity.PublicationEntity;

import java.awt.print.Pageable;
import java.util.List;


public interface PublicationRepository extends JpaRepository<PublicationEntity, Long> {
    PublicationEntity findById(long id);
}
