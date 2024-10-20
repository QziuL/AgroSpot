package agrospot.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private UUID externalId;
    private String pathImage;

    public ProductModel(String name, String description, String pathImage) {
        this.name = name;
        this.description = description;
        this.pathImage = pathImage;
        this.externalId = UUID.randomUUID();
    }

    public ProductModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public void setExternalId(UUID externalId) {
        this.externalId = externalId;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    @Override
    public String toString() {
        return "Product: " + id +
                ", " + name +
                ", " + description +
                ", " + externalId +
                ", " + pathImage;
    }
}
