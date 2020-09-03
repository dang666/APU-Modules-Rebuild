
package ivandroassignment;


public class Lecturer extends User{
    private String yearhired;
    private String field; 
    
     public Lecturer (String id, String firstname, String lastname, String birth, String gender, String email, String phone, String address, String house, String field, String yearhired) 
    {
        super (id, firstname, lastname, birth , gender, email, phone, address, house);
         this.field= field;
         this.yearhired = yearhired; 
    }
     public String getField() {
        return field;
    }

    public void setField(String Field) {
        this.field = field;
    }
    public String getYearhired() {
        return yearhired;
    }

    public void setYearhired(String yearhired) {
        this.yearhired = yearhired;
    }
   Lecturer(String data) {
        String[] dataArray = data.split(",");
        this.id = dataArray[0];
        this.firstname = dataArray[1];
        this.lastname = dataArray[2];
        this.birth= dataArray[3]; 
        this.gender = dataArray[4];
        this.email = dataArray[5];
        this.phone = dataArray[6];
        this.address = dataArray[7];
        this.house = dataArray[8];
        this.field = dataArray[9];
        this.yearhired = dataArray[10];
        
    }
      
     @Override
    public String toString() {
        return super.toString() + "," + this.field + "," + this.yearhired;
    } 
    
    
    
}
