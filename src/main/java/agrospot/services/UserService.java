package agrospot.services;

import agrospot.dtos.request.CreateUserDTO;

import java.util.List;

public interface UserService {
    Boolean createUser(CreateUserDTO userDto);
    CreateUserDTO findUserByEmail(String email);
    List<CreateUserDTO> findAllUsers();
    CreateUserDTO updateUserByEmail(String email);
    Boolean deleteUserById(String id);
}
