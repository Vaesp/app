package com.example.app.Services;

import com.example.app.Security.RepositoryJWT.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUser(Long uId){
        boolean exists = userRepository.existsById(uId);
        if(!exists){
            throw new IllegalStateException("El usuario no existe");
        }
        userRepository.deleteById(uId);
    }
}