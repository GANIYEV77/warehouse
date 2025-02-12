package uz.usmon.warehouse.controller;


import uz.usmon.warehouse.dto.UserWarehousedto;
import uz.usmon.warehouse.model.Result;
import uz.usmon.warehouse.model.UserWarehouse;
import uz.usmon.warehouse.service.UserWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userwarehouse")
public class UserWarehouseController {

    @Autowired
    UserWarehouseService userWarehouseService;

    @GetMapping
    public List<UserWarehouse> getUsers() {
        return userWarehouseService.getall();
    }

    @GetMapping("/{id}")
    public UserWarehouse getUser(@PathVariable Integer id) {
        UserWarehouse userWarehouse = userWarehouseService.getuser(id);
        return userWarehouse;
    }

    @PostMapping
    public Result create(@RequestBody UserWarehousedto userWarehousedto) {
        Result result = userWarehouseService.create(userWarehousedto);
        return result;
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody UserWarehousedto userWarehousedto) {
        Result result = userWarehouseService.update(id, userWarehousedto);
        return result;
    }


    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        Result result = userWarehouseService.delete(id);
        return result;
    }

}
