package uz.usmon.warehouse.repositorys;

import uz.usmon.warehouse.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepo extends JpaRepository<Warehouse, Integer> {
}
