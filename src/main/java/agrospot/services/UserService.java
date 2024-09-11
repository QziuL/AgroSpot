package agrospot.services;

import agrospot.dtos.request.UserDTO;

import java.util.List;

public interface UserService {
    Boolean createUser(UserDTO userDto);
    UserDTO findUserByEmail(String email);
    List<UserDTO> findAllUsers();
    UserDTO updateUserByEmail(String email);
    Boolean deleteUserById(String id);
}
