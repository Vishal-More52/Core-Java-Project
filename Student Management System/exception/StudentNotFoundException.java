package exception;

public class StudentNotFoundException extends Exception {
  private int studentId;

  public StudentNotFoundException(int studentId){
    super("❌ Student with Id [" + studentId + "] not found in the system");
    this.studentId = studentId;
  }

  public StudentNotFoundException(String message){
    super("❌ " + message);
  }

  public int getStudentId(){
    return studentId;
  }
}
