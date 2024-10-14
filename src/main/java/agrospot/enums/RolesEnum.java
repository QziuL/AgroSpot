package agrospot.enums;

public enum RolesEnum {
    USER("USER"),
    ADMIN("ADMIN"),
    PRODUCER("PRODUCER");

    private final String role;

    RolesEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
