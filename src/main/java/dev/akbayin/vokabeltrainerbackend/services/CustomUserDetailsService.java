package dev.akbayin.vokabeltrainerbackend.services;

import dev.akbayin.vokabeltrainerbackend.models.User;
import dev.akbayin.vokabeltrainerbackend.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        UserDetails userDetails = new UserDetailsImpl(user);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return userDetails;
    }
}
