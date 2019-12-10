package Homerealtor;

public class User implements java.io.Serializable {
   private int id;
   private String name,email,propertyAddress,username,time, phoneNum;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
