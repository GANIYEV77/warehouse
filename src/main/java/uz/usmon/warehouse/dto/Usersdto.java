package uz.usmon.warehouse.dto;


import jakarta.persistence.Column;

public class Usersdto {
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String code;
    private String password;
    private boolean active=true;


    public Usersdto(String firstname, String lastname, String phonenumber, String code, String password, boolean active) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.code = code;
        this.password = password;
        this.active = active;
    }

    public Usersdto() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Usersdto{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", code='" + code + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}
