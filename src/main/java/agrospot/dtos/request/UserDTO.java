package agrospot.dtos.request;

import agrospot.models.UserModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public record UserDTO(String name, String email, String password) {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = encoder.encode(password);
    }

    public UserModel convertDtoToModel(UserDTO userDTO) {
        return new UserModel(this.name, this.email, this.password);
    }
}
