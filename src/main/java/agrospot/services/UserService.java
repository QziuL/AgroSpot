package agrospot.services;

import agrospot.dtos.request.CreateUserDTO;
import agrospot.dtos.response.ListUserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    Boolean createUser(CreateUserDTO userDto);
    ListUserDTO findUserByEmail(String email);
    List<ListUserDTO> findAllUsers();
    CreateUserDTO updateUserByEmail(String email);
    Boolean deleteUserByExternalId(UUID id);
}
