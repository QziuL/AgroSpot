package agrospot.services.impl;

import agrospot.dtos.request.UserDTO;
import agrospot.models.UserModel;
import agrospot.repositorys.UserRepository;
import agrospot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        List<UserModel> users = userRepository.findAll();
        List<UserDTO> userDtos = new ArrayList<>();
        for (UserModel user : users) {
            UserDTO userDto = new UserDTO(user.getName(), user.getEmail(), user.getPassword());
            userDtos.add(userDto);
            System.out.println(user);
            System.out.println(user.getRoles());
        }

        return userDtos;
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
