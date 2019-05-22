package universe.service;

import org.springframework.data.domain.Pageable;
import universe.dto.PublicationDTO;

import java.util.List;

public interface PublicationService {
    void save(PublicationDTO publicationDTO);
    PublicationDTO findById(long id);
    List<PublicationDTO> findAll();
    List<PublicationDTO> findAllByPage(Pageable pageable);
}
