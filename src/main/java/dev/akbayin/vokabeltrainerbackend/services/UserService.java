package dev.akbayin.vokabeltrainerbackend.services;

import dev.akbayin.vokabeltrainerbackend.models.User;
import dev.akbayin.vokabeltrainerbackend.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }
}
