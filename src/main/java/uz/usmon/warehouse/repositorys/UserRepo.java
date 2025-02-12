package uz.usmon.warehouse.repositorys;

import uz.usmon.warehouse.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {
}
