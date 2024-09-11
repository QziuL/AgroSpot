package agrospot.dtos.request;

import agrospot.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public record UserDTO(String name, String email, String password) {
    public UserDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserModel convertDtoToModel(UserDTO userDTO) {
        List<String> roles = new ArrayList<>();
        roles.add("BASIC");
        return new UserModel(this.name, this.email, this.password, roles);
    }
}
