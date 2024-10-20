package agrospot.dtos.response;

import java.util.UUID;

public record ProductResponseDTO(String name, String description, String pathImage, UUID externalId) {
}
