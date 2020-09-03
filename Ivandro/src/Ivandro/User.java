
package ivandroassignment;


public class User {
    
     String id;
    String firstname;
    String lastname;
     String birth;
    String gender;
    String email;
    String phone;
    String address;
    String house;

    public User() {
    }

    public User(String id, String firstname, String lastname, String birth, String gender, String email, String phone, String address, String house) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birth = birth;
        this.gender= gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.house = house;
        
        
    }

    User(String data) {
        String[] dataArray = data.split(",");
        
        this.id = dataArray[0];
        this.firstname = dataArray[1];
        this.lastname = dataArray[2];
        this.birth = dataArray[3];
        this.gender= dataArray[4]; 
        this.email = dataArray[5];
        this.phone = dataArray[6];
        this.address = dataArray[7];
        this.house = dataArray[8];
        
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
     public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
     public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
     public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }
     public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
     public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return (this.id + "," + this.firstname + "," + this.lastname + "," + this.birth 
                + "," + this.gender + "," + this.email + "," + this.phone + "," + this.address + "," + this.house);
    } 
}
