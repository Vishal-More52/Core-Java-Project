package exception;

public class DuplicateStudentException extends Exception {
  private int studentId;

  public DuplicateStudentException(int studentid){
    super("⚠️ Student with ID [" + studentId + "] already exists in the system");
    this.studentId = studentId;
  }

  public getStudentId(){
    return studentId;
  }
}
