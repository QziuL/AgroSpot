package agrospot.repositorys;

import agrospot.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    Optional<ProductModel> findByExternalId(UUID externalId);
}
