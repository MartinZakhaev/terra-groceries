package model;

public class Customer {
    private int id;
    private String username, password, fName, lName, phone, address, email, createdAt;

    public Customer() {
    }

    public Customer(String username, String password, String fName, String lName, String phone, String address, String email) {
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.address = address;
        this.email = email;        
    }

    public Customer(int id, String username, String fName, String lName, String phone, String address, String email) {
        this.id = id;
        this.username = username;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }        

    public Customer(int id) {
        this.id = id;
    }        

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", username=" + username + ", password=" + password + ", fName=" + fName + ", lName=" + lName + ", phone=" + phone + ", address=" + address + ", email=" + email + ", createdAt=" + createdAt + '}';
    }
    
}
