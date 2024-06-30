package dev.akbayin.vokabeltrainerbackend.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@Setter
public class User {

    @Id
    private Long id;

    private String username;

    private String password;

}
