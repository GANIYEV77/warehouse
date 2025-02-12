package uz.usmon.warehouse.controller;


import uz.usmon.warehouse.dto.Usersdto;
import uz.usmon.warehouse.model.Result;
import uz.usmon.warehouse.model.Users;
import uz.usmon.warehouse.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UsersService usersService;

    @GetMapping
    public List<Users> getUsers() {
        List<Users> users = usersService.getUsers();
        return users;
    }

    @GetMapping("/{id}")
    public Users getUserid(@PathVariable Integer id) {
        return usersService.getUserbyid(id);
    }


    @PostMapping
    public Result addUser(@RequestBody Usersdto usersdto) {
        Result result = usersService.create(usersdto);
        return result;
    }

    @PutMapping("/{id}")
    public Result updateUser(@PathVariable Integer id, @RequestBody Usersdto usersdto) {
        Result result = usersService.update(id, usersdto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Integer id) {
        Result result = usersService.delete(id);
        return result;
    }
}
