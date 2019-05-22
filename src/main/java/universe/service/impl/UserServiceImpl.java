package universe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import universe.dto.PublicationDTO;
import universe.dto.UserDTO;
import universe.entity.UserEntity;
import universe.repository.UserRepository;
import universe.service.UserService;
import universe.utils.ObjectMapperUtils;

import javax.xml.soap.SAAJResult;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public List<UserDTO> findAll(){
        return modelMapper.mapAll(userRepository.findAll(), UserDTO.class);
    }

    @Override
    public boolean userExist(long id){
        return userRepository.findById(id) != null;
    }

    @Override
    public boolean userExist(String name){
        return userRepository.findByUsername(name) != null;
    }

    @Override
    public void save(UserDTO userDTO){
        userRepository.save(modelMapper.map(userDTO, UserEntity.class));
    }

    @Override
    public UserDTO findUserByName(String string){
        return modelMapper.map(userRepository.findByUsername(string), UserDTO.class);
    }
}
