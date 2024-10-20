package agrospot.services.impl;

import agrospot.dtos.request.CreateUserDTO;
import agrospot.dtos.response.ListUserDTO;
import agrospot.models.RolesModel;
import agrospot.models.UserModel;
import agrospot.repositorys.RoleRepository;
import agrospot.repositorys.UserRepository;
import agrospot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Boolean createUser(CreateUserDTO userDto) {
        try{
            RolesModel roleModel = roleRepository.findByName(userDto.role()).orElseThrow();
            userRepository.save(CreateUserDTO.convertDtoToModel(userDto, roleModel));
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public ListUserDTO findUserByEmail(String email) {
        try {
            UserModel user = userRepository.findByEmail(email).orElseThrow();
            return new ListUserDTO(user.getName(),
                    user.getEmail(),
                    user.getExternalId().toString(),
                    user.getRoles().stream().map(RolesModel::getName).toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<ListUserDTO> findAllUsers() {
        List<UserModel> users = userRepository.findAll();
        List<ListUserDTO> userDtos = new ArrayList<>();
        for (UserModel user : users) {
            ListUserDTO userDto = new ListUserDTO(user.getName(),
                    user.getEmail(),
                    user.getExternalId().toString(),
                    user.getRoles().stream().map(RolesModel::getName).toList());
            userDtos.add(userDto);
//            System.out.println(user);
//            System.out.println("User: "+user.getUsername()+" - Roles: "+user.getRoles());
        }

        return userDtos;
    }

    @Override
    public CreateUserDTO updateUserByEmail(String email) {
        return null;
    }

    @Override
    public Boolean deleteUserByExternalId(UUID externalId) {
        try{
            UserModel user = userRepository.findByExternalId(externalId).orElseThrow();
            userRepository.delete(user);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
