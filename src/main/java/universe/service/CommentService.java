package universe.service;

import universe.dto.CommentDTO;
import universe.dto.PublicationDTO;

import java.util.List;

public interface CommentService {
    void save(CommentDTO commentDTO);
    CommentDTO findByCommentEntity(CommentDTO commentDTO);
    List<CommentDTO> findAll();
    List<CommentDTO> findByPublicationDTO(PublicationDTO publicationDTO);
    List<CommentDTO> findByPublication(long id);
    void createWithPublication(String text, long parentPublicationID, long userID);
    void createWithComment(String text, long parentPublicationID, long userID);
}
