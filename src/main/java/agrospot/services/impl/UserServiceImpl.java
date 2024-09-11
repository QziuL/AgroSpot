package agrospot.services.impl;

import agrospot.dtos.request.UserDTO;
import agrospot.models.UserModel;
import agrospot.repositorys.UserRepository;
import agrospot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Boolean createUser(UserDTO userDto) {
        try{
            userRepository.save(userDto.convertDtoToModel(userDto));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return List.of();
    }

    @Override
    public UserDTO updateUserByEmail(String email) {
        return null;
    }

    @Override
    public Boolean deleteUserById(String id) {
        return null;
    }
}
