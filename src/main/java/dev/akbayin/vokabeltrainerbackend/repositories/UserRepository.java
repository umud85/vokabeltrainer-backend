package dev.akbayin.vokabeltrainerbackend.repositories;

import dev.akbayin.vokabeltrainerbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(
            value = "SELECT * FROM USERS u WHERE u.username = ?",
            nativeQuery = true)
    User findByUsername(String username);
}
