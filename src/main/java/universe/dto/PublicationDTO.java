package universe.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PublicationDTO {
    private long id;
    private String name;
    private String text;
    private UserDTO userDTO;
    private List<CommentDTO> commentDTOList;
}
