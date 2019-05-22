package universe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import universe.dto.PublicationDTO;
import universe.entity.PublicationEntity;
import universe.repository.PublicationRepository;
import universe.service.PublicationService;
import universe.utils.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicationServiceLmpl implements PublicationService {
    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;


    @Override
    public PublicationDTO findById(long id){
        return modelMapper.map(publicationRepository.findById(id), PublicationDTO.class);
    }

    @Override
    public void save(PublicationDTO publicationDTO){
        publicationRepository.save(modelMapper.map(publicationDTO, PublicationEntity.class));
    }

    @Override
    public List<PublicationDTO> findAll(){
        return modelMapper.mapAll(publicationRepository.findAll(), PublicationDTO.class);
    }

    @Override
    public List<PublicationDTO> findAllByPage(Pageable pageable){
        Page page = publicationRepository.findAll(pageable);
        List<PublicationEntity> publicationEntityList = new ArrayList<>();
        for (Object o : page) {
            publicationEntityList.add((PublicationEntity) o);
        }
        return modelMapper.mapAll(publicationEntityList, PublicationDTO.class);
    }
}
