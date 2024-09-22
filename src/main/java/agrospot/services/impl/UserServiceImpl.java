package agrospot.services.impl;

import agrospot.dtos.request.CreateUserDTO;
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
    public Boolean createUser(CreateUserDTO userDto) {
        try{
            userRepository.save(CreateUserDTO.convertDtoToModel(userDto));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public CreateUserDTO findUserByEmail(String email) {
        return null;
    }

    @Override
    public List<CreateUserDTO> findAllUsers() {
        List<UserModel> users = userRepository.findAll();
        List<CreateUserDTO> userDtos = new ArrayList<>();
        for (UserModel user : users) {
            CreateUserDTO userDto = new CreateUserDTO(user.getName(), user.getEmail(), user.getPassword());
            userDtos.add(userDto);
            System.out.println(user);
            System.out.println(user.getRoles());
        }

        return userDtos;
    }

    @Override
    public CreateUserDTO updateUserByEmail(String email) {
        return null;
    }

    @Override
    public Boolean deleteUserById(String id) {
        return null;
    }
}
