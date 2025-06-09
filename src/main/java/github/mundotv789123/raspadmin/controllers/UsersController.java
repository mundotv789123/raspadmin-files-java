package github.mundotv789123.raspadmin.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    
    @GetMapping("users")
    public void users() {
        //TODO return users
    }

}
