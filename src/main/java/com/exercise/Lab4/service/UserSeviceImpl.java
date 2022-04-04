package com.exercise.Lab4.service;

import com.exercise.Lab4.domain.Post;
import com.exercise.Lab4.domain.User;
import com.exercise.Lab4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserSeviceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

//    @Autowired
//     ModelMapper modelMapper;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Post> findUserPosts(long id) {
        return userRepository.findUserPosts(id);
    }
}
