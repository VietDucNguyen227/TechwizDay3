package com.example.healthassistant.service;

import com.example.healthassistant.model.Users;
import com.example.healthassistant.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public void saveUsers(Users user) {
        usersRepository.save(user);
    }

    @Override
    public List<Users> listsUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users findUserById(Long id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Users findByUsername(String name) {
        return usersRepository.findByUsername(name);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return usersRepository.existsByUsername(username);
    }
}
