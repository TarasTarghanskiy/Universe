package universe.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import universe.entity.enums.Role;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String username;
    private String name;
    private int rating;
    private String password;
    private boolean enable;
    private Set<Role> roles;
    private List<PublicationDTO> publicationEntityList;
    private List<CommentDTO> commentEntityList;
}
