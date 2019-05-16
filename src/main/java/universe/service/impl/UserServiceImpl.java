package universe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import universe.dto.UserDTO;
import universe.entity.UserEntity;
import universe.repository.UserRepository;
import universe.service.UserService;
import universe.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    public List<UserDTO> findAll(){
        return modelMapper.mapAll(userRepository.findAll(), UserDTO.class);
    }

    public void save(UserDTO userDTO){
        userRepository.save(modelMapper.map(userDTO, UserEntity.class));
    }
}
