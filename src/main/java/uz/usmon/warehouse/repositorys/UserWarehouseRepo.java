package uz.usmon.warehouse.repositorys;

import uz.usmon.warehouse.model.UserWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWarehouseRepo extends JpaRepository<UserWarehouse, Integer> {
}
