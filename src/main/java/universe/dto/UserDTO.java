package universe.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import universe.entity.enums.Role;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String username;
    private String name;
    private String password;
    private boolean enable;
    private Set<Role> roles;
}
