// As in our design, Tea and Coffee now extend CaffeineBeverage
public class Tea extends CaffeineBeverage {
  
  // Tea needs to define brew() and addCondiments() - the two abstract methods from Beverage 

  public void brew() {
    System.out.println("Steeping the tea");
  }

  public void addCondiments() {
    System.out.println("Adding Lemon");
  }
}