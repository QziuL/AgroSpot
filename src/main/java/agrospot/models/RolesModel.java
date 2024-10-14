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

//    @Enumerated(EnumType.STRING)
//    @Column(name = "name")
//    private RolesEnum role;

//    public RolesModel(RolesEnum role) {
//        this.role = role;
//    }
    @Column(nullable = false)
    private String name;

    public RolesModel() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
