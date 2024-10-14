package agrospot.repositorys;

import agrospot.models.RolesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RolesModel, Long> {
    Optional<RolesModel> findByName(String name);
}
