package agrospot.enums;

public enum RolesEnum {
    USER("user"),
    ADMIN("admin"),
    PRODUCER("producer");

    private final String role;

    RolesEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
