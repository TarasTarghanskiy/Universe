package universe.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {
    private long id;
    private String text;
    private PublicationDTO publicationDTO;
    private CommentDTO commentDTO;
    private List<CommentDTO> commentDTOList;
    private UserDTO userDTO;
    private List<UserDTO> userDTOLikes;
}
