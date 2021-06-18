package org.reevoo.movie_test.serviceimpl;

import org.reevoo.movie_test.entity.User;
import org.reevoo.movie_test.repository.UserRepository;
import org.reevoo.movie_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }
}
