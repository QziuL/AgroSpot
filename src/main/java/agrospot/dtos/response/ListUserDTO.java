package agrospot.dtos.response;

import java.util.List;

public record ListUserDTO(String name, String email, String password, List<String> roles) {
}
