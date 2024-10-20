package agrospot.dtos.response;

import java.util.List;

public record ListUserDTO(String name, String email, String external_id, List<String> roles) {
}
