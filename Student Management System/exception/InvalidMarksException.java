package exception;

import java.nio.InvalidMarkException;

public class InvalidMarksException extends RuntimeException {
  private double invalidValue;

  public InvalidMarkException(double value){
    super("❌ Invalid marks value: " + value + ". Marks must be between 0 and 100.");
  }
  public double getInvalidValue() {
    return invalidValue;
  }
}
