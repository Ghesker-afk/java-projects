public class NYPizzaStore extends PizzaStore {

  // We have got to implement createPizza(), since it is abstract in PizzaStore
  protected Pizza createPizza(String item) {
    if (item.equals("cheese")) {
      return new NYStyleCheesePizza();
    } else if (item.equals("veggie")) {
      return new NYStyleVeggiePizza();
    } else if (item.equals("clam")) {
      return new NYStyleClamPizza();
    } else if (item.equals("pepperoni")) {
      return new NYStylePepperoniPizza();
    } else {
      return null;
    }
  }
}