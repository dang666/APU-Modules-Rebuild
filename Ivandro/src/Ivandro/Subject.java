
package ivandroassignment;


public class Subject {
    String 	SubjectNumber;
    String 	SubjectName;
    
    
    public Subject  () {
    }
    
    public Subject(String SubjectNumber , String SubjectName) {
		this.SubjectName= SubjectName;
                this.SubjectNumber = SubjectNumber; 
    }
    
    public String getSubjectNumber() {
        return SubjectNumber;
    }

    public void setSubjectNumber(String SubjectNumber) {
        this.SubjectNumber = SubjectNumber;
    }
    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String SubjectName) {
        this.SubjectName = SubjectName;
    }
    
   
    
    
    Subject(String data) {
        String[] dataArray = data.split(",");
        this.SubjectNumber = dataArray[0];
        this.SubjectName = dataArray[1];
    }
}
