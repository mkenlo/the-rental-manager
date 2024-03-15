package com.mkenlo.rentalmanager.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mkenlo.rentalmanager.models.LoginUser;
import com.mkenlo.rentalmanager.models.User;
import com.mkenlo.rentalmanager.repositories.RoleRepository;
import com.mkenlo.rentalmanager.repositories.UserRepository;

@Service
public class UserService {

    UserRepository userRepository;
    RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User findById(long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user, BindingResult result) {

        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            result.rejectValue("password", "match", "Confirm Password must Match Password");
        } else if (userRepository.findByUsername(user.getUsername()) != null) {
            result.rejectValue("username", "exist", "Username already exist");
        }
        if (result.hasErrors())
            return null;
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);

        return userRepository.save(user);
    }

    public User doLogin(LoginUser user, BindingResult result) {

        User potentialUser = userRepository.findByUsername(user.getUsername());
        if (potentialUser == null) {
            result.rejectValue("username", "exist", "Username not found");
        } else if (!BCrypt.checkpw(user.getPassword(), potentialUser.getPassword()))
            result.rejectValue("password", "match", "Invalid Password");
        if (result.hasErrors())
            return null;
        return potentialUser;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
