package org.reevoo.movie_test.controller;

import org.reevoo.movie_test.entity.User;
import org.reevoo.movie_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping("/test")
    public void test(@RequestParam("id") String id) {
        User user = userService.findById(id);
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getJoinDate());
    }
}
