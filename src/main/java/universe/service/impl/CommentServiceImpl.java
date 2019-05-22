package universe.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import universe.dto.CommentDTO;
import universe.dto.PublicationDTO;
import universe.entity.CommentEntity;
import universe.entity.PublicationEntity;
import universe.repository.CommentRepository;
import universe.repository.PublicationRepository;
import universe.repository.UserRepository;
import universe.service.CommentService;
import universe.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    ObjectMapperUtils mapperUtils;


    @Override
    public void save(CommentDTO commentDTO){
        commentRepository.save(mapperUtils.map(commentDTO, CommentEntity.class));
    }

    @Override
    public void createWithComment(String text, long parentCommentID, long userID){
        CommentEntity commentEntity = new CommentEntity();
            commentEntity.setText(text);
            commentEntity.setCommentEntity(commentRepository.findById(parentCommentID));
            commentEntity.setUserEntity(userRepository.findById(userID));
            commentRepository.save(commentEntity);
    }

    @Override
    public void createWithPublication(String text, long parentPublicationID, long userID){
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setText(text);
        commentEntity.setPublicationEntity(publicationRepository.findById(parentPublicationID));
        commentEntity.setUserEntity(userRepository.findById(userID));
        commentRepository.save(commentEntity);
    }

    @Override
    public List<CommentDTO> findAll(){
        return mapperUtils.mapAll(commentRepository.findAll(), CommentDTO.class);
    }


    @Override
    public CommentDTO findByCommentEntity(CommentDTO commentDTO){
        return mapperUtils.map(
                commentRepository.findByCommentEntity(
                        mapperUtils.map(commentDTO, CommentEntity.class)
                ), CommentDTO.class);
    }

    @Override
    public List<CommentDTO> findByPublicationDTO(PublicationDTO publicationDTO){
        return mapperUtils.mapAll(
                commentRepository.findByPublicationEntity(
                        mapperUtils.map(publicationDTO, PublicationEntity.class)), CommentDTO.class);
    }

    @Override
    public List<CommentDTO> findByPublication(long id){
        return mapperUtils.mapAll(
                commentRepository.findByPublicationEntity(publicationRepository.findById(id)), CommentDTO.class);
    }
}
