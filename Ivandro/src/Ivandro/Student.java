
package ivandroassignment;


public class Student extends User {
     private String course;
     
      public Student (String id, String firstname, String lastname, String birth, String gender, String email, String phone, String address, String house, String course) 
    {
        super (id, firstname, lastname, birth , gender, email, phone, address, house);
        this.course = course; 
    }
      
      public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
      
   Student(String data) {
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
        this.course = dataArray[9];
    }
      
     @Override
    public String toString() {
        return super.toString() + "," + this.course;
    } 
}
