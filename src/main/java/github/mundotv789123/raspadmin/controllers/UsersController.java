package github.mundotv789123.raspadmin.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github.mundotv789123.raspadmin.models.UserModel;
import github.mundotv789123.raspadmin.models.enums.UserRole;
import github.mundotv789123.raspadmin.repositories.UsersRepository;

@RestController
@RequestMapping("/api/admin/users")
public class UsersController {

    private UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public ResponseEntity<Object> listUsers() {
        Iterable<UserModel> users = this.usersRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> post() {
        //TODO remover teste
        UserModel newUser = new UserModel("teste", "senha", UserRole.USER, true);
        usersRepository.save(newUser);

        return ResponseEntity.ok(newUser.getId());

    }
}
