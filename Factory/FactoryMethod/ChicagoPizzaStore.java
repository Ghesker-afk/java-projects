public class ChicagoPizzaStore extends PizzaStore {

  // We have got to implement createPizza(), since it is abstract in PizzaStore
  protected Pizza createPizza(String item) {
    if (item.equals("cheese")) {
      return new ChicagoStyleCheesePizza();
    } else if (item.equals("veggie")) {
      return new ChicagoStyleVeggiePizza();
    } else if (item.equals("clam")) {
      return new ChicagoStyleClamPizza();
    } else if (item.equals("pepperoni")) {
      return new ChicagoStylePepperoniPizza();
    } else {
      return null;
    }
  }
}