package uz.usmon.warehouse.service;


import uz.usmon.warehouse.dto.UserWarehousedto;
import uz.usmon.warehouse.model.Result;
import uz.usmon.warehouse.model.UserWarehouse;
import uz.usmon.warehouse.model.Users;
import uz.usmon.warehouse.model.Warehouse;
import uz.usmon.warehouse.repositorys.UserRepo;
import uz.usmon.warehouse.repositorys.UserWarehouseRepo;
import uz.usmon.warehouse.repositorys.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserWarehouseService {
    @Autowired
    UserWarehouseRepo userWarehouseRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    WarehouseRepo warehouseRepo;

    // get all
    public List<UserWarehouse> getall(){
        return userWarehouseRepo.findAll();
    }

    // get by id
    public UserWarehouse getuser(Integer id){
        Optional<UserWarehouse> byId = userWarehouseRepo.findById(id);
        return byId.get();
    }

    // create
    public Result create(UserWarehousedto userWarehousedto) {
        UserWarehouse userWarehouse = new UserWarehouse();
        Optional<Warehouse> optionalWarehouse = warehouseRepo.findById(userWarehousedto.getWarehouse());
        Warehouse warehouse = optionalWarehouse.get();
        Optional<Users> optionalUsers = userRepo.findById(userWarehousedto.getUsers());
        Users users = optionalUsers.get();
        userWarehouse.setWarehouse(warehouse);
        userWarehouse.setUsers((List<Users>) users);
        userWarehouseRepo.save(userWarehouse);
        return new Result(true,"saqlandi");
    }

    // update



    public Result update(Integer id, UserWarehousedto userWarehouseDto) {
        Optional<UserWarehouse> userWarehouseOptional = userWarehouseRepo.findById(id);

        if (userWarehouseOptional.isPresent()) {
            UserWarehouse userWarehouse = userWarehouseOptional.get();
            Optional<Warehouse> warehouseOptional = warehouseRepo.findById(userWarehouseDto.getWarehouse());
            Warehouse warehouse = warehouseOptional.get();
            userWarehouse.setWarehouse(warehouse);

            Optional<Users> optionalUsers = userRepo.findById(userWarehouseDto.getUsers());
            Users users = optionalUsers.get();
            userWarehouse.setUsers((List<Users>) users);

            userWarehouseRepo.save(userWarehouse);
            return new Result(true, "saqlandi");
        }

        return new Result(false, "Warehouse not found");
    }



    // Delete

    public Result delete(Integer id) {
         userWarehouseRepo.deleteById(id);
        return new Result(true, "Deleted");
    }

}
