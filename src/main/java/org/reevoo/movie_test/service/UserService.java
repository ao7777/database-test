package org.reevoo.movie_test.service;

import org.reevoo.movie_test.entity.User;

public interface UserService {
    User findById(String id);
}
