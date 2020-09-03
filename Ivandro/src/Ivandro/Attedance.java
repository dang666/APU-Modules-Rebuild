
package ivandroassignment;


public class Attedance extends Subject{
    
	private String status;
	private String id;
	private String lastname;
        private String date;  
        private String firstname;
        
     
    
    public Attedance(String SubjectNumber , String SubjectName, String id,String firstname, String lastname, String date, String status) {
	super (SubjectNumber, SubjectName);
        this.status = status; 
        this.id = id; 
        this.firstname=firstname;
        this.lastname = lastname; 
        this.date = date; 
    }

    public Attedance() {
        
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.lastname = firstname;}
    
    Attedance(String data) {
        String[] dataArray = data.split(",");
        this.SubjectNumber = dataArray[0];
        this.SubjectName = dataArray[1];
        this.id = dataArray[2];
        this.firstname = dataArray[3];
        this.lastname = dataArray[4];
        this.date= dataArray[5]; 
        this.status = dataArray[6];
        
    }
}
