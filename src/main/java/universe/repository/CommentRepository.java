package universe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import universe.entity.CommentEntity;
import universe.entity.PublicationEntity;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    CommentEntity findByCommentEntity(CommentEntity commentEntity);
    CommentEntity findById(long id);
    List<CommentEntity> findByPublicationEntity(PublicationEntity publicationEntity);
}
