package uz.usmon.warehouse.controller;


import uz.usmon.warehouse.dto.Warehousedto;
import uz.usmon.warehouse.model.Result;
import uz.usmon.warehouse.model.Warehouse;
import uz.usmon.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/werhouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @GetMapping
    public List<Warehouse> getall(){
        return warehouseService.getall();
    }

    @GetMapping("/{id}")
    public Warehouse getWarehouse(@PathVariable Integer id) {
        Warehouse warehouse = (Warehouse) warehouseService.getuser(id);
        return warehouse;
    }

    @PostMapping
    public Result addWarehouse(@RequestBody Warehousedto warehousedto) {
        Result result = warehouseService.create(warehousedto);
        return result;
    }

    @PutMapping("/{id}")
    public Result updateWarehouse(@PathVariable Integer id, @RequestBody Warehousedto warehousedto) {
        Result result = warehouseService.update(id, warehousedto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleteWarehouse(@PathVariable Integer id) {
        Result result = warehouseService.delete(id);
        return result;
    }
}
