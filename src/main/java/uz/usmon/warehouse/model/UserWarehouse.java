package uz.usmon.warehouse.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserWarehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<Users> users;

    @OneToOne
    private Warehouse warehouse;

    public UserWarehouse(Integer id, List<Users> users, Warehouse warehouse) {
        this.id = id;
        this.users = users;
        this.warehouse = warehouse;
    }

    public UserWarehouse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "UserWarehouse{" +
                "id=" + id +
                ", users=" + users +
                ", warehouse=" + warehouse +
                '}';
    }

    public void setUsers(Integer users) {
    }
}
