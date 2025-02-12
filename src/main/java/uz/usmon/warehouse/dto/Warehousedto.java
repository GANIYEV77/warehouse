package uz.usmon.warehouse.dto;

import jakarta.persistence.Column;

public class Warehousedto {
    private String name;
    @Column(nullable = false)
    private String active;

    public Warehousedto(String name, String active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Warehousedto{" +
                "name='" + name + '\'' +
                ", active='" + active + '\'' +
                '}';
    }
}
