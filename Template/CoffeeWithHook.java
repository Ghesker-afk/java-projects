
import java.io.*;

public class CoffeeWithHook extends CaffeineBeverageWithHook {

  public void brew() {
    System.out.println("Dripping Coffee through filter");
  }

  public void addCondiments() {
    System.out.println("Adding Sugar and Milk");
  }

  // Here's where you override the hook and provide your own functionality
  
  public boolean customerWantsCondiments() {
    
    // Get the user's input on the condiment decision and return true or false depending on the input

    String answer = getUserInput();

    if (answer.toLowerCase().startsWith("y")) {
      return true;
    } else {
      return false;
    }
  }

  private String getUserInput() {
    String answer = null;

    System.out.print("Would you like milk and sugar with your coffee? (y/n) ");

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    try {
      answer = in.readLine();
    } catch (IOException ioe) {
      System.err.println("IO error trying to read your answer");
    }

    if (answer == null) {
      return "no";
    }

    return answer;
  }
}