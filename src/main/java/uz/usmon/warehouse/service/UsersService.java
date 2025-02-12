package uz.usmon.warehouse.service;


import uz.usmon.warehouse.dto.Usersdto;
import uz.usmon.warehouse.model.Result;
import uz.usmon.warehouse.model.Users;
import uz.usmon.warehouse.repositorys.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UserRepo userRepo;


    public List<Users> getUsers() {
        return userRepo.findAll();
    }

    public Users getUserbyid(Integer id) {
        Optional<Users> usersOptional = userRepo.findById(id);
        return usersOptional.get();
    }

    // create

    public Result create(Usersdto usersdto) {
        Users users = new Users();
        users.setFirstname(usersdto.getFirstname());
        users.setLastname(usersdto.getLastname());
        users.setCode(usersdto.getCode());
        users.setPassword(usersdto.getPassword());
        userRepo.save(users);
        return new Result(true,"user created");
    }

    // update
    public Result update(Integer id, Usersdto usersdto) {
        Optional<Users> usersOptional = userRepo.findById(id);

        if(usersOptional.isPresent()) {
            Users users = usersOptional.get();
            users.setFirstname(usersdto.getFirstname());
            users.setLastname(usersdto.getLastname());
            users.setCode(usersdto.getCode());
            users.setPassword(usersdto.getPassword());
            userRepo.save(users);
            return new Result(true,"user updated");
        }
        return new Result(false,"user not found");
    }

    // Delete
    public Result delete(Integer id) {
        userRepo.deleteById(id);
        return new Result(true,"user deleted");
    }
}
