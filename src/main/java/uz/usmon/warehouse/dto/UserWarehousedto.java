package uz.usmon.warehouse.dto;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

public class UserWarehousedto {
    private Integer users;

    private Integer warehouse;

    public UserWarehousedto(Integer users, Integer warehouse) {
        this.users = users;
        this.warehouse = warehouse;
    }

    public UserWarehousedto() {
    }

    public Integer getUsers() {
        return users;
    }

    public void setUsers(Integer users) {
        this.users = users;
    }

    public Integer getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Integer warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "UserWarehousedto{" +
                "users=" + users +
                ", warehouse=" + warehouse +
                '}';
    }
}
