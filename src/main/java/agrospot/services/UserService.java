package agrospot.services;

import agrospot.dtos.request.CreateUserDTO;
import agrospot.dtos.response.ListUserDTO;

import java.util.List;

public interface UserService {
    Boolean createUser(CreateUserDTO userDto);
    CreateUserDTO findUserByEmail(String email);
    List<ListUserDTO> findAllUsers();
    CreateUserDTO updateUserByEmail(String email);
    Boolean deleteUserById(String id);
}
