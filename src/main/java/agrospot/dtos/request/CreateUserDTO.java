package agrospot.dtos.request;

import agrospot.models.RolesModel;
import agrospot.models.UserModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

public record CreateUserDTO(String name, String email, String password, String role) {
    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public CreateUserDTO(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public static UserModel convertDtoToModel(CreateUserDTO createUserDTO, RolesModel role) {
        return new UserModel(
                createUserDTO.name,
                createUserDTO.email,
                encoder.encode(createUserDTO.password),
                Set.of(role));
    }
}
