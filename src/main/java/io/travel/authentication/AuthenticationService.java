package io.travel.authentication;

import io.travel.model.User;
import io.travel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {
        boolean authenticated = false;
        List<User> users = userRepository.findByUsername(username);
        if ((!users.isEmpty())  &&  (users.getFirst() != null) && PasswordEncryptor.authenticate(password, users.getFirst().getPassword())) {
            authenticated = true;
            SessionContext.setCurrentUser(users.getFirst());
        }

        return authenticated;
    }

    public void initializeUser(String name, String username, String password, String currency) {
        String encrypted = PasswordEncryptor.encrypt(password);
        User user = new User(name, username, encrypted, currency);
        userRepository.save(user);
    }
}
