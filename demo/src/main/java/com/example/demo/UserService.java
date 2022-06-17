package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleEntityRepository roleEntityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<String> saveUser(User userEntity) {
        User user = userRepository.findByLogin(userEntity.getLogin());
        if (user == null) {
            RoleEntity userRole = roleEntityRepository.findByName("ROLE_USER");
            userEntity.setRole(userRole.getName());
            userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
            userRepository.save(userEntity);
            return new ResponseEntity<>("User created: " + userEntity.getLogin(), HttpStatus.CREATED );
        }

        return new ResponseEntity<>("User already Exist" , HttpStatus.CONFLICT );
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User getByLogin(String login) {
        return userRepository.getByLogin(login);
    }
    public User findByLoginAndPassword(String login, String password) {
        User userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }
}
