package agrospot.models;

import agrospot.enums.RolesEnum;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "roles")
public class RolesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RolesEnum role;

    public RolesModel(RolesEnum role) {
        this.role = role;
    }

    public RolesModel() {}
}
