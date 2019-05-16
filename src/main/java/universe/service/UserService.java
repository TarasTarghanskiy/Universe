package universe.service;

import universe.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();
    void save(UserDTO userDTO);
}
