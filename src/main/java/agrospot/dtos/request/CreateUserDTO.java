package agrospot.dtos.request;

import agrospot.enums.RolesEnum;
import agrospot.models.UserModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public record CreateUserDTO(String name, String email, String password) {
    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public CreateUserDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static UserModel convertDtoToModel(CreateUserDTO createUserDTO) {
        return new UserModel(
                createUserDTO.name,
                createUserDTO.email,
                encoder.encode(createUserDTO.password),
                List.of(String.valueOf(RolesEnum.USER)));
    }
}
