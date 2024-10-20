package agrospot.repositorys;

import agrospot.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);
//    @Query(value = "select UserModel from UserModel where UserModel.externalId=externalId")
    //Optional<UserModel> findByExternalId(UUID externalId);

    @Query("SELECT u FROM UserModel u WHERE u.externalId = :externalId")
    Optional<UserModel> findByExternalId(@Param("externalId") UUID externalId);
}
