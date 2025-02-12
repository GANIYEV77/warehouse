package uz.usmon.warehouse.service;


import uz.usmon.warehouse.dto.Warehousedto;
import uz.usmon.warehouse.model.Result;
import uz.usmon.warehouse.model.Warehouse;
import uz.usmon.warehouse.repositorys.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepo warehouseRepo;

    public List<Warehouse> getall(){
        return warehouseRepo.findAll();
    }

    // get by id
    public WarehouseRepo getuser(Integer id){
        Optional<Warehouse> byId = warehouseRepo.findById(id);
        return (WarehouseRepo) byId.get();
    }


    // Create
    public Result create(Warehousedto warehousedto) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(warehousedto.getName());
        warehouse.setActive(warehousedto.getActive());
        warehouseRepo.save(warehouse);
        return new Result(true, "Warehouse created");
    }

    public Result update(Integer id, Warehousedto warehousedto) {
        Optional<Warehouse> warehouseOptional = warehouseRepo.findById(id);

        if(warehouseOptional.isPresent()) {
            Warehouse warehouse = warehouseOptional.get();
            warehouse.setName(warehousedto.getName());
            warehouse.setActive(warehousedto.getActive());
            warehouseRepo.save(warehouse);

            return new Result(true, "Warehouse updated");
        }
        return new Result(false, "Warehouse not found");
    }



    public Result delete(Integer id) {
        warehouseRepo.deleteById(id);
        return new Result(true, "Warehouse deleted");
    }
}
