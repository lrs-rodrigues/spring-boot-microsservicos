package com.lrsrodrigues.user.services;

import com.lrsrodrigues.user.dto.UserDTO;
import com.lrsrodrigues.user.entities.User;
import com.lrsrodrigues.user.repositories.UserRepository;
import com.lrsrodrigues.user.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(UserDTO user) {
        User obj = fromData(null, user);
        return userRepository.save(obj);
    }

    public User update(Integer userId, UserDTO user){
        User obj = fromData(userId, user);
        return userRepository.save(obj);
    }

    public void delete(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        userRepository.deleteById(user.getId());
    }

    public User fromData(Integer id, UserDTO obj) {
        User user;

        if (id == null) {
            user = new User();
        } else {
            user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        }

        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setCpf(obj.getCpf());

        return user;
    }

}